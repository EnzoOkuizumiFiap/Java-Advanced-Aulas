package br.com.fiap.dragons.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dragon {
    private Integer id;
    private String nome;
    private String cor;
    private int poderDeFogo;
    private double peso;
    private double altura;
    private Boolean possuiMontador;
}
