package br.com.fiap.navi.views;

import br.com.fiap.navi.service.NaviService;
import br.com.fiap.navi.views.components.NaviTextArea;
import br.com.fiap.navi.views.components.StyleSelector;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

    private final NaviService naviService;
    private TextArea originalTextArea = new NaviTextArea("Texto Original", VaadinIcon.PENCIL.create());
    private TextArea translatedTextArea = new NaviTextArea("Texto Traduzido", VaadinIcon.OPEN_BOOK.create());
    private Select<String> selectStyle = new StyleSelector();

    public HomeView(NaviService naviService) {
        this.naviService = naviService;
        addClassName("navi-view");

        translatedTextArea.setReadOnly(true);
        var split = new SplitLayout(originalTextArea, translatedTextArea);
        split.setWidthFull();
        split.setHeight("100%");
        split.addClassName("navi-editor");

        var button = new Button("Traduzir", VaadinIcon.ARROW_RIGHT.create());
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClassName("navi-translate-button");
        button.addClickListener(event -> translatedTextArea.setValue(
                naviService.translate(originalTextArea.getValue(), selectStyle.getValue())
        ));
        var title = new H1("Navi");
        title.addClassName("navi-title");
        var subtitle = new Paragraph("Tradutor de textos universais");
        subtitle.addClassName("navi-subtitle");
        var controls = new HorizontalLayout(selectStyle, button);
        controls.addClassName("navi-controls");
        controls.setWidthFull();

        add(title);
        add(subtitle);
        add(split);
        add(controls);
    }
}
