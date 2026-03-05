package br.com.fiap.heroes.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hero {
    private Long id;
    private String name;
    private String superPower;
    private int level;
    private Boolean isAlive;
}
