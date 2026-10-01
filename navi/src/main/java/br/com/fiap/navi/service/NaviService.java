package br.com.fiap.navi.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class NaviService {

    private final ChatClient chatClient;

    private final String systemMessage = """
            Você é um tradutor de estilos de linguagem.

            Sua função é reescrever o texto fornecido pelo usuário
            utilizando exatamente o estilo solicitado.

            Não explique a tradução.
            Não adicione comentários.
            Não altere o significado original do texto.
            Apenas reescreva o texto no estilo solicitado.

            Estilos disponíveis:
            - Gíria das ruas
            - Criança de 2 anos
            - Juridiquês
            - Caipira
            - Fausto Silva
            """;

    private final GoogleGenAiChatOptions.Builder options = GoogleGenAiChatOptions.builder()
            .model("gemini-3.5-flash-lite")
            .temperature(1.0);

    public NaviService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem(systemMessage)
                .defaultOptions(options)
                .build();
    }

    public String translate(String originalText, String style) {

        String userMessage = """
                Texto original:
                %s

                Estilo escolhido:
                %s

                Reescreva o texto original utilizando o estilo escolhido.
                """.formatted(originalText, style);

        return chatClient.prompt()
                .user(userMessage)
                .call()
                .content();
    }
}
