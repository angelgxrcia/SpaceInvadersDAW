package com.politecnicomalaga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Navealiada {

    //Atributos de la nave aliada
    private float posX;                                                 //Posicion X de la nave
    private float posY;                                                 //Posición Y de la nave
    private Texture imagen;                                             //Imagen de la nave
    private short anchoPant;                                            //Ancho de la pantalla para saber hasta donde podemos moverla
    static private final float VELOCIDAD = 3.0f;                        //Velocidad a la que se va a mover la nave
    static public final String SPRITE_NAVE_ALIADA = "Navealiada.png";   //String que contiene el archivo de imagen

    //-----------------------
    private int contador = 0;
    //Constructor, donde se incicializan los valores de nuestra querida nave

    public Navealiada (float posX, float posY, short anchoPantalla) {
        this.posX = posX;
        this.posY = posY;
        imagen = new Texture(SPRITE_NAVE_ALIADA);
        anchoPant = anchoPantalla;
    }

    //Comportamientos
    public void moverse(EstadoTeclado et) {


        if(contador >= 30){
            RafagaDisparos.nuevoDisparo(posX, posY, false, 3);
            contador = 0;
        }
        contador++;

        if (et.isTeclaIzq() && posX-25f > 0) {                //si se pulsa a la izquierda y detecta que no esta en el borde izquierdo, se mueve a la izquierda
            posX -= VELOCIDAD;
        }
        if (et.isTeclaDer() && posX+25f < this.anchoPant) {   //si se pulsa a la derecha y detecta que no esta en el borde derecho, se mueve a la derecha

            posX += VELOCIDAD;
        }

//        contadorFrames++;
//        if(contadorFrames >= 30){
//            DisparoAliado d = new DisparoAliado(this.posX, this.posY, false, 5f);
//            contadorFrames = 0;
//        }


    }
    public void pintarse(SpriteBatch miSB) {
        miSB.draw(imagen, posX-(200/2.0f), posY-(200/2.0f),200,200);
    }

    public void dispose() {
        if (imagen != null) {
            imagen.dispose();
        }
    }

}
