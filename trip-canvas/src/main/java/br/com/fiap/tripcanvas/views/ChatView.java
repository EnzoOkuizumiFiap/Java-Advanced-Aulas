package br.com.fiap.tripcanvas.views;

import br.com.fiap.tripcanvas.service.TripService;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.Instant;

@Route("/chats")
public class ChatView extends VerticalLayout {
    private MessageInput messageInput = new MessageInput();
    private final MessageList messageList = new MessageList();
    private final TripService tripService;

    public ChatView(TripService tripService) {
        add(messageInput);
        messageInput.addSubmitListener(event -> sendMessage(event.getValue()));
        this.tripService = tripService;
    }

    private void sendMessage(String message) {
        messageList.addItem(new MessageListItem(
                message,
                Instant.now(),
                "User"
        ));

        var response = tripService.sendChatMessage(message);
        messageList.addItem(new MessageListItem(
                response,
                Instant.now(),
                "AI"
        ));
    }

}
