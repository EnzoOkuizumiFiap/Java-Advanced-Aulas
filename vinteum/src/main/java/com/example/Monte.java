package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monte {
    //Atributos
    private List<Carta> cartas = new ArrayList<Carta>();

    //Construtor
    public Monte(){
        for(Naipe naipe: Naipe.values()) { //For Each... Busca os valores que estão no enum
            for (int numero = 1; numero <= 13; numero++) {
                cartas.add(new Carta(numero, naipe)); //Add no arraylist
            }
        }
    }

    //Métodos
    public void embaralhar() {
        Collections.shuffle(cartas); //.shuffle é um metodo static... é um metodo de classe e não precisa de um objeto para executa-lo
    }

    public Carta virar() {
        return cartas.remove(0);
    }

}
