package com.example;

public class Carta {
    //Atributos
    private int numero;
    private Naipe naipe;

    //Construtores
    public Carta() {
    }

    public Carta(int numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    //Getters and Setters
    public int getNumero() {
        return numero;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    //Métodos
    public String ImagePath() {
        return "classic-cards" + numero + naipe + ".png";
    }

}
