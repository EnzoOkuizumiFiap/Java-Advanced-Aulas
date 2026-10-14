package br.com.fiap.tripcanvas.service;

import br.com.fiap.tripcanvas.model.Activity;
import br.com.fiap.tripcanvas.repository.RestaurantRepository;
import br.com.fiap.tripcanvas.tools.ReservationTool;
import br.com.fiap.tripcanvas.tools.RestaurantTools;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TripService {
    private final ChatClient chatClient;
    private final RestaurantRepository restaurantRepository;
    private final ReservationService reservationService;

    private final MessageWindowChatMemory memory = MessageWindowChatMemory.builder()
            .maxMessages(10)
            .build();

    private PromptTemplate promptTemplate = new PromptTemplate("""
                Crie uma sugestão de roteiro de atividades viagem para fazer em {destionation}.
                Cada atividade deve ter título, descrição, duração e tipo.
                Os tipos válidos são: MUSEM, PARK, RESTAURANT, SHOPPING, ENTERTAINMENT, HOTEL, NATURE.
                Crei no máximo 5 atividades.
                Sugira restaurantes usando a ferramenta getRestaurants(location) para obter restaurantes do destino.
                Caso não encontre restaurantes, sugira outros restaurantes.
            """);

    public TripService(ChatClient.Builder builder, RestaurantRepository restaurantRepository, ReservationService reservationService) {
        this.chatClient = builder.build();
        this.restaurantRepository = restaurantRepository;
        this.reservationService = reservationService;
    }

    public List<Activity> generateTripPlan(String destination) {
        return chatClient
                .prompt(promptTemplate.create(Map.of("destination", destination)))
                .tools(new RestaurantTools(restaurantRepository))
                .call()
                .entity(new ParameterizedTypeReference<List<Activity>>() {}, ChatClient.EntityParamSpec::validateSchema);
    }

    public String sendChatMessage(String message) {
        var conversationId = VaadinSession.getCurrent().getSession().getId();
        return chatClient
                .prompt(message)
                .system("""
                        Você é um assistente de reserva de restaurantes
                        Use a ferramenta makeReservation para fazer reservas em restaurantes
                        No final da reserva, retorne o código de confirmação para o usuário.
                        """)
                .tools(
                        new RestaurantTools(restaurantRepository),
                        new ReservationTool(reservationService)
                )
                .advisors(
                        a -> {
                            a.param(ChatMemory.CONVERSATION_ID, conversationId);
                            a.advisors(MessageChatMemoryAdvisor.builder(memory).build());
                        }
                )
                .call()
                .content();
    }
}
