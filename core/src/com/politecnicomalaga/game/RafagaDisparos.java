package com.politecnicomalaga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class RafagaDisparos {

    public RafagaDisparos(){


    }

    public static void pintarseTodos(SpriteBatch miSB){
        for(Disparo d: disparoList){
            d.pintarse(miSB);
        }
    }

    static private List<Disparo> disparoList;
    public static void control () {
        try{
            for (Disparo d: disparoList) {
                d.moverse();
                d.colisiones();
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void start(){
        disparoList = new ArrayList<>();
        (new Disparo(-9999, -9999, false, 0)).Start();
    }

    public static void destruirme(Disparo d){
        disparoList.remove(d);
    }
}
