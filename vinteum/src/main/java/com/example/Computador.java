package com.example;

public class Computador extends Jogador{
    //Sobrescrita de metodo
    @Override //Avisa que estamos fazendo uma sobrescrita
    public boolean parou() {
        return getPontos() > 16;
    }
}
