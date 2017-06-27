package com.company;

public class GameRunner {

    public static final int MAX = 50;

    private Player player1;
    private Player player2;



    public void run() {
        initPlayers();

    }

    public void initPlayers() {
//        Inicializa el jugador1 y construye su flota
        player1 = new Player(GamePrinter.readPlayerName(1), 1);
        player1.buildFleet();

//        Inicializa el jugador2 y construye su flota
        player2 = new Player(GamePrinter.readPlayerName(2), 2);
        player2.buildFleet();
    }
}
