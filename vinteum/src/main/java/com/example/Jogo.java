package com.example;

public class Jogo {
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo() {
        monte.embaralhar();
    }

    public Carta distribuirCartaParaJogador(Jogador jogador) {
        if(jogador.parou()) return null; //early return

        var carta = monte.virar();
        jogador.receberCarta(carta);
        return carta;
    }

    public boolean acabou() {
        var jogadorEstourou = jogador.getPontos() > 21;
        var computadorEstourou = computador.getPontos() > 21;

        if (jogadorEstourou || computadorEstourou) return true;
        if (jogador.parou() && computador.parou()) return true;

        return false;
    }

    public String resultado() {
        var jogadorEstourou = jogador.getPontos() > 21;
        var computadorEstourou = computador.getPontos() > 21;

        if(jogador.getPontos() ==  computador.getPontos()) return "Empatou!";
        if(jogadorEstourou && computadorEstourou) return "Empatou!";

        if(jogador.getPontos() > computador.getPontos() && !jogadorEstourou) return "Você Ganhou!";
        if(computadorEstourou) return "Você Ganhou!";

        return "Você Perdeu!";
    }
}
