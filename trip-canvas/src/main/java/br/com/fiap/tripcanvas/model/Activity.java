package br.com.fiap.tripcanvas.model;

import lombok.Data;

@Data
public class Activity {

    private String title;
    private int duration; // em minutos
    private String description;
    private ActivityType type;

}
