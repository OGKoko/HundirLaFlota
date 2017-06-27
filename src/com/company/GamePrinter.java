package com.company;

import java.util.Scanner;

public class GamePrinter {

    private static Scanner scanner = new Scanner(System.in);

    public static String readPlayerName(int numberPlayer) {
        if (numberPlayer == 1) {
            System.out.println("Jugador 1 es tu turno de configurar la flota:");
            System.out.println("Como se llama la flota?");
            return scanner.nextLine();
        } else if (numberPlayer == 2){
            System.out.println("Jugador 2 es tu turno de configurar la flota:");
            System.out.println("Como se llama la flota?");
            return scanner.nextLine();
        } else {
            return "ERROR";
        }
    }

    public static void printFleet(Player player) { System.out.println("Barcos de la flota " + player.getName() + ":" + player.getFleet()); }

    public static void printIntroduceX() { System.out.println("Introduce la coordenada x:"); }

    public static void printIntroduceY() { System.out.println("Introduce la coordenada y:"); }

    public static void printIntroduceShipSource() { System.out.println("Introduce el origen de las coordenadas del barco:"); }

    public static void printIntroduceShipOrientation() { System.out.println("Hacia que dirección? [1]NORTE [2]SUD [3]ESTE [4]OESTE"); }

    public static void printBuildShip(int i) {
        switch (i) {
            case 0:
                System.out.println("Construye tu PORTAVIONES");
                break;
            case 1:
                System.out.println("Construye tu ACORAZADO");
                break;
            case 2:
                System.out.println("Construye tu CRUCERO");
                break;
            case 3:
                System.out.println("Construye tu SUBMARINO");
                break;
            case 4:
                System.out.println("Construye tu DESTRUCTOR");
                break;
        }
    }

    public static void printStartGame() {
        System.out.println();
        System.out.println();
        System.out.println("QUE EMPIECE LA BATALLA!!");
        System.out.println();
        System.out.println();
    }

    public static void printIsSunk(Ship ship) {
        System.out.println("Tocado y hundido!!");
        System.out.println("El barco " + ship.getIdB() + " ha sido hundido!");
    }

    public static void printWinner(Player player1, Player player2) {
        System.out.println("A " + player2.getName() + " no le quedan más barcos.");
        System.out.println("Gana " + player1.getName() + "!!!");
    }
    public static void printTurn(Player player) {
        System.out.println("Turno de " + player.getName() + ":");
        System.out.println("Introduce las coordenadas de tu ataque");
    }

    public static void printHit() { System.out.println("Tocado!"); }

    public static void printMiss() { System.out.println("Agua..."); }

    public static String printErrorTable() { return "Has superado el límite del tablero."; }

    public static String printErrorOverlap(Point points) { return "El punto del barco provoca solapamiento sobre otro: " + points; }

}