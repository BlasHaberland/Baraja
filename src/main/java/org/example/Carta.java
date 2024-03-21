package org.example;

public class Carta {
    private int valor;
    private char palo;

    public Carta(int valor, char palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public char getPalo() {
        return palo;
    }

    public void setPalo(char palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "valor=" + valor +
                ", palo=" + palo +
                '}';
    }
}
