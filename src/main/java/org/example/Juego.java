package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Juego {
    private ArrayList<Carta> baraja;
    private ArrayList<Carta> monton;


    public Juego() {
        baraja = crearBaraja();
        monton = new ArrayList<>();
    }

    private ArrayList<Carta> crearBaraja(){
        char[] palos = {'O','E','P','C'};
        ArrayList<Carta> baraja = new ArrayList<>();

        for (int i = 0; i < palos.length; i++) {
            for (int j = 1; j < 13; j++) {
                if (j == 8 || j == 9) continue;
                baraja.add(new Carta(j,palos[i]));
            }
        }
        return baraja;
    }

    /**
     * Mezcla la baraja
     * @return void
     */
    public void barajar (){
        Collections.shuffle(baraja);
    }

    /**
     * Muestra y remueve una carta de la baraja principal
     * @return Carta
     */
    public Carta siguienteCarta(){
        if (cartasDisponibles() < 1) {
            System.out.println("En la baraja no se encuentra la cantidad de cartas indicada.");

            return null;
        }

        Carta cartaRemovida = baraja.remove(baraja.size()-1);
        monton.add(cartaRemovida);

        return cartaRemovida;
    }

    /**
     * Muestra el numero de cartas disponibles dentro de la baraja
     * @return int || null
     */
    public int cartasDisponibles(){
        System.out.println("La cantidad de cartas disponibles es: " + baraja.size());

        return baraja.size();
    }

    /**
     * Reparte la cantidad de cartas solicitadas en caso de ser suficientes
     * @param int cantidad
     * @return ArrayList<Carta> || null
     */
    public ArrayList<Carta> darCartas(int cantidad){
        if (cartasDisponibles() < cantidad) {
            System.out.println("En la baraja no se encuentra la cantidad de cartas indicada.");

            return null;
        }
        int aux = 1;
        ArrayList<Carta> mano = new ArrayList<>();

        for (int i = baraja.size()-1 ;aux <= cantidad ; i--) {
            Carta carta = baraja.remove(i);
            mano.add(carta);
            monton.add(carta);
            aux++;
        }

        return mano;
    }

    /**
     * Muestra el monton con las cartas descartadas
     * @return void
     */
    public void mostrarMonton(){
        if (monton.isEmpty()) System.out.println("El monton aun no tinene ninguna carta.");

        for (Carta carta : monton) {
            System.out.println(carta);
        }

    }

    /**
     * Muestra la baraja de cartas
     * @return void
     */
    public void mostrarBaraja(){
        if (baraja.isEmpty()) System.out.println("La baraja no tinene ninguna carta.");

        for (Carta carta : baraja) {
            System.out.println(carta);
        }

    }


}
