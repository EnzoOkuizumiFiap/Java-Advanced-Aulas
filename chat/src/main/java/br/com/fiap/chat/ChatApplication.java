package br.com.fiap.chat;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.theme.aura.Aura;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@StyleSheet(Aura.STYLESHEET)
@Push
public class ChatApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }
}
