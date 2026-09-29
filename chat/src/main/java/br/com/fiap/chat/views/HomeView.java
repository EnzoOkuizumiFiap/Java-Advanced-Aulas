package br.com.fiap.chat.views;

import br.com.fiap.chat.service.ChatService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.Instant;

@Route("")
public class HomeView extends VerticalLayout {
    private final MessageList list = new MessageList();
    private final Scroller scroller;
    private final ChatService chatService;

    public HomeView(ChatService chatService) {

        add(new H1("Chat de Ciências"));
        add(new Paragraph("Converse com o seu professor de IA"));


        MessageListItem message = new  MessageListItem(
                "O quê vamos aprender hoje?",
                Instant.now(), "Professor"
        );
        message.setUserColorIndex(1);
        list.addItem(message);
        list.setMarkdown(true);

        scroller = new Scroller(list);
        scroller.setWidthFull();
        setHeightFull();

        add(scroller);


        MessageInput input = new MessageInput();
        input.addSubmitListener(submitEvent -> sendMessage(submitEvent.getValue()));
        input.setWidthFull();
        add(input);
        this.chatService = chatService;
    }



    private void sendMessage(String userMessage) {
        var userMessageItem = new MessageListItem(
                userMessage,
                Instant.now(),
                "Você"
        );
        userMessageItem.setUserColorIndex(2);
        list.addItem(userMessageItem);

        var iaMessageItem = new MessageListItem(
                "",
                Instant.now(),
                "Professor"
        );

        iaMessageItem.setUserColorIndex(1);
        list.addItem(iaMessageItem);

        chatService.sendMessage(userMessage).subscribe(partialResponse -> {
            getUI().ifPresent(ui -> ui.access(() -> {
                iaMessageItem.appendText(partialResponse);
                scroller.scrollToBottom();
            }));
        });
    }

}