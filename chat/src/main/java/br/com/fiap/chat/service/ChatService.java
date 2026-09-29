package br.com.fiap.chat.service;

import com.vaadin.flow.server.VaadinSession;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatService {

    private final ChatClient chatClient;

    private final String systemMessage ="""
        Você é um professor de ciências muito inteligente e prestativo. 
        Responda de forma clara e objetiva as perguntas dos alunos.
        Seus alunos tem 10 anos de idade.
        Use exemplos e analogias para explicar conceitos complexos.
        Se não souber a resposta, admita que não sabe.
        Nunca responda temas fora da área de ciências.
        Se a pergunta for sobre outro assunto, responda que só pode responder perguntas sobre ciências.
        Sempre use Markdown e Emojis para formatar suas respostas.
        """;


    MessageWindowChatMemory memory = MessageWindowChatMemory.builder()
            .maxMessages(10)
            .build();

    OpenAiChatOptions.Builder options = OpenAiChatOptions.builder()
            .model("gpt-4o-mini")
            .temperature(1.0)
            .presencePenalty(1.0)
            .frequencyPenalty(0.7);

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem(systemMessage)
                .defaultAdvisors(
                        new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor.builder(memory).build()
                )
                .defaultOptions(options)
                .build();
    }


    public Flux<String> sendMessage(String userMessage) {
        var conversationId = VaadinSession.getCurrent().getSession().getId();
        return chatClient.prompt()
                .user(userMessage)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
                .stream()
                .content();
    }
}
