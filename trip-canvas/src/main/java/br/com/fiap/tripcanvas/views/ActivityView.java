package br.com.fiap.tripcanvas.views;

import br.com.fiap.tripcanvas.model.Activity;
import br.com.fiap.tripcanvas.model.ActivityType;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.badge.Badge;
import com.vaadin.flow.component.badge.BadgeVariant;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.card.CardVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;

public class ActivityView extends Card {

    public ActivityView(Activity activity) {
        add(new Paragraph(activity.getDescription()));
        setTitle(new Div(activity.getTitle()));

        Badge badge = new Badge(activity.getDuration() + " min");
        badge.addThemeVariants(BadgeVariant.SUCCESS);
        setHeaderSuffix(badge);

        addThemeVariants(CardVariant.ELEVATED);
        addThemeVariants(CardVariant.HORIZONTAL);

        setMedia(getIconFromType(activity.getType()));
    }

    private Component getIconFromType(ActivityType type) {
        return switch (type) {
            case MUSEUM -> VaadinIcon.CAMERA.create();
            case RESTAURANT ->  VaadinIcon.CUTLERY.create();
            case SHOPPING ->  VaadinIcon.PLUS.create();
            case ENTERTAINMENT -> VaadinIcon.MUSIC.create();
            case HOTEL ->   VaadinIcon.BED.create();
            default -> VaadinIcon.MAP_MARKER.create();
        };
    }
}
