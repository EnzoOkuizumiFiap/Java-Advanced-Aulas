package br.com.fiap.recipeplan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @JsonIgnore
    private UUID id = UUID.randomUUID();
    private String name;
    private String quantity;
    private String unit;
}