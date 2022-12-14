package com.politecnicomalaga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Controlador {

    //Estado
    SpriteBatch batch;
    Navealiada navealiada;
    EstadoTeclado et;
    Texture fondo;
    Nave_Enemiga naveenemiga;
    //Disparo disparos;
    RafagaDisparos rafagaDisparos;






    public Controlador(){                            //incializamos nuestro teclado virtual, nuestro fondo, el batch y la nave estando centrada y en la zona inferior
        batch = new SpriteBatch();
        fondo = new Texture("Galaxia.jpg");
        et = new EstadoTeclado(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        navealiada = new Navealiada(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/10,(short)Gdx.graphics.getWidth());
        naveenemiga = new Nave_Enemiga(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()-60,(short)Gdx.graphics.getWidth());
        rafagaDisparos = new RafagaDisparos();
    }

   public void render(){                                       //dibujamos todo en el batch y controlamos el movimiento de la nave
        this.control();
        batch.begin();
        batch.draw(fondo, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
        naveenemiga.pintarse(batch);
        RafagaDisparos.pintarseTodos(batch);
        navealiada.pintarse(batch);
        batch.end();
    }
    private void control(){             //si pulsan la pantalla, le decimos a estado teclado que lo simule y se lo pasamos a nave para que se mueva
        boolean recienTocado;

        recienTocado = Gdx.input.justTouched();
        if (recienTocado) {
            et.simulaTeclado(Gdx.input.getX(), Gdx.input.getY());
        }
        navealiada.moverse(et);
        naveenemiga.moverse();
        RafagaDisparos.control();
    }

    public void dispose(){
        if (batch != null) {
            batch.dispose();
        }

        navealiada.dispose();
    }

}
