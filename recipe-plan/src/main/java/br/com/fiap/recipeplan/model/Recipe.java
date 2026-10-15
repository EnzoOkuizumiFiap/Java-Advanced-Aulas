package br.com.fiap.recipeplan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @JsonIgnore
    private UUID id = UUID.randomUUID();
    private String name;
    private String description;
    private List<Ingredient> ingredients = new ArrayList<>();
    private String instructions;
}