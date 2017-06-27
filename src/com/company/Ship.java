package com.company;

import java.util.ArrayList;


public class Ship {


    private static Integer idsB =0;
    private Integer idB;
    private ArrayList<Point> puntos = new ArrayList<>();
    private ArrayList<Boolean> hits = new ArrayList<>();

    public Ship (Point source, int size, Orientation orientation){

        idB=++idsB;

        for (int i = 0; i < size ; i++) {
            hits.add(false);
        }

        puntos.add(source);


        switch(orientation){

            case NORTE:
                for (int i = 0; i < size; i++) {
                    Point pAnterior= puntos.get(puntos.size()-1);
                    Point pNuevo=new Point(source.getX(), pAnterior.getY() +1 );
                    puntos.add(pNuevo);

                }

            case SUD:
                for (int i = 0; i < size; i++) {
                    Point pAnterior= puntos.get(puntos.size()-1);
                    Point pNuevo=new Point(source.getX(), pAnterior.getY() -1 );
                    puntos.add(pNuevo);
                }

            case ESTE:
                for (int i = 0; i < size; i++) {
                    Point pAnterior= puntos.get(puntos.size()-1);
                    Point pNuevo=new Point(source.getY(), pAnterior.getX() +1 );
                    puntos.add(pNuevo);
                }

            case OESTE:
                for (int i = 0; i < size; i++) {
                    Point pAnterior= puntos.get(puntos.size()-1);
                    Point pNuevo=new Point(source.getY(), pAnterior.getX() -1 );
                    puntos.add(pNuevo);
                }
        }
    }

    public Integer getIdB() {
        return idB;
    }

    public boolean barcoUndido(){

        for (Boolean hit : hits
                ) {
            if(hit == false){
                return false;
            }
        }
        return true;
    }

    public boolean recibeAtaque(Point p){

        for (int i = 0; i < puntos.size() ; i++) {
            if (puntos.get(i).equals(p)){
                hits.set(i,true);
                return true;
            }
        }
        return false;
    }
}