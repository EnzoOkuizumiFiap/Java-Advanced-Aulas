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
    public String imagePath() {
        String[] prefixos = {"", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        return "classic-cards/" + prefixos[numero] + naipe + ".png";
    }

}
