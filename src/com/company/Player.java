package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int number;
    private ArrayList<Ship> fleet = new ArrayList<>();

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", fleet=" + fleet +
                '}';
    }

    public Player(String name, int i) {
        this.name = name;
        this.number = i;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ship> getFleet() {
        return fleet;
    }

    //    Pregunta las coordenadas
    public Point askCoordinates() {
        GamePrinter.printIntroduceX();
        int x = scanner.nextInt();
        GamePrinter.printIntroduceY();
        int y = scanner.nextInt();

        Point point = new Point(x, y);
        return point;
    }

    //    Construir el barco
    public Ship buildShip(int i) {
        while (true) {
            String n = "";
            int s = 0;
            GamePrinter.printBuildShip(i);
            switch (i) {
                case 0:
                    n = "Portaviones";
                    s = 5;
                    break;
                case 1:
                    n = "Acorazado";
                    s = 4;
                    break;
                case 2:
                    n = "Crucero";
                    s = 3;
                    break;
                case 3:
                    n = "Submarino";
                    s = 3;
                    break;
                case 4:
                    n = "Destructor";
                    s = 2;
                    break;
            }
            GamePrinter.printIntroduceShipSource();
            Point p = askCoordinates();
            scanner.nextLine();
            GamePrinter.printIntroduceShipOrientation();
            int o = scanner.nextInt();
            scanner.nextLine();

            Orientation orientation = Orientation.values()[o - 1];

            //Ship ship = new Ship(n, p, s, orientation);

            //verifyOverlap(ship);

            //return ship;

        }
    }
/*
    private void verifyOverlap(Ship ship) {
        for (Point points : ship.getPoints()) {
            if (verifyOverlap(points)) {
                throw new RuntimeException(GamePrinter.printErrorOverlap(points));
            }
        }

    }
*/
    //    Construir la flota (5 barcos)
    public void buildFleet() {
        for (int i = 0; i < 5; i++) {
            while (true) {
                try {
                    fleet.add(buildShip(i));
                    GamePrinter.printFleet(this);
                    break;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
    }

    //    Devuelve cierto si el ataque ha dado al blanco
    public boolean verifyAttack(Point p) {
        boolean result = verifyOverlap(p);
        return result;
    }

    public boolean verifyOverlap(Point p) {
        for (Ship ship : fleet) {
            if (ship.recibeAtaque(p)) {
                return true;
            }
        }
        return false;
    }

    //    Devuelve cierto si la flota ha sido hundida
    public boolean sunkenFleet() {
        for (Ship ships : fleet) {
            if (!ships.barcoUndido()) {
                return false;
            }
        }
        return true;
    }

}
