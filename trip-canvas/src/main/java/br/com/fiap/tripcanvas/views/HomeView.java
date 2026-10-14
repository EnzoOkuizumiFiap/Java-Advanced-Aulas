package br.com.fiap.tripcanvas.views;

import br.com.fiap.tripcanvas.service.TripService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;

@Route("/")
@Slf4j
public class HomeView extends VerticalLayout {

    private final TripService tripService;
    private TextField textField = new TextField();

    public HomeView(TripService tripService) {

        add(new H1("Trip Canvas"));
        add(new Paragraph("Planeja suas viagens com IA"));

        TextField textField = new TextField();
        //textField.setLabel("Destino");
        textField.setPlaceholder("Digite o destino da viagem");
        textField.setClearButtonVisible(true);
        textField.setPrefixComponent(VaadinIcon.MAP_MARKER.create());

        Button generateButton = new Button("Gerar Roteiro", new Icon(VaadinIcon.MAGIC));
        generateButton.addClickListener(event -> handleGenerateButtonClick());

        var generatePanel = new HorizontalLayout(textField, generateButton);
        add(generatePanel);

        this.tripService = tripService;
    }

    private void handleGenerateButtonClick() {
        var responses = tripService.generateTripPlan(textField.getValue());
        responses.forEach(response -> add(new ActivityView(response)));
    }
}
