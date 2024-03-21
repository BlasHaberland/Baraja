package org.example;

public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();

        juego.cartasDisponibles();
        juego.darCartas(1);
        juego.cartasDisponibles();
        juego.mostrarBaraja();
        System.out.println("MONTON");
        juego.mostrarMonton();
        juego.darCartas(39);
        System.out.println("MONTON");
        juego.mostrarMonton();
        juego.siguienteCarta();
    }
}