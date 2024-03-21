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
    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * Método para crear una baraja completa de cartas.
     * @return Una lista de cartas que representa una baraja completa.
     */
    private ArrayList<Carta> crearBaraja(){
        ArrayList<Carta> baraja = new ArrayList<>();
        for (Palo palo : Palo.values()) {
            for (int i = 1; i < 13 ; i++) {
                if (i == 8 || i == 9)continue;
                baraja.add(new Carta(i , palo));
            }
        }

        return baraja;
    }

    /*private ArrayList<Carta> crearBaraja(){
        char[] palos = {'O','E','P','C'};
        ArrayList<Carta> baraja = new ArrayList<>();

        for (int i = 0; i < palos.length; i++) {
            for (int j = 1; j < 13; j++) {
                if (j == 8 || j == 9) continue;
                baraja.add(new Carta(j,palos[i]));
            }
        }
        return baraja;
    }*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * Mezcla la baraja
     */
    public void barajar (){
        Collections.shuffle(baraja);
    }
    /*----------------------------------------------------------------------------------------------------------------*/
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
    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * Muestra el numero de cartas disponibles dentro de la baraja
     * @return int || null
     */
    public int cartasDisponibles(){
        System.out.println("La cantidad de cartas disponibles es: " + baraja.size());
        return baraja.size();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * Reparte la cantidad de cartas solicitadas en caso de ser suficientes
     * @param cantidad La cantidad de cartas a repartir
     * @return ArrayList<Carta> || null
     */
    public ArrayList<Carta> darCartas(int cantidad){
        //if (cartasDisponibles() < cantidad)
        if (baraja.size() < cantidad) {
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
    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * Muestra el monton con las cartas descartadas
     */
    public void mostrarMonton(){
        System.out.println("MONTON");
        if (monton.isEmpty()) System.out.println("El monton aun no tinene ninguna carta.");

        for (Carta carta : monton) {
            System.out.println(carta);
        }

    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /**
     * Muestra la baraja de cartas
     */
    public void mostrarBaraja(){
        System.out.println("BARAJA");
        if (baraja.isEmpty()) System.out.println("La baraja no tinene ninguna carta.");

        for (Carta carta : baraja) {
            System.out.println(carta);
        }

    }


}
