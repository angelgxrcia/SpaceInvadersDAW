package com.politecnicomalaga.game;

import com.badlogic.gdx.ApplicationAdapter;

public class MyGdxSpaceInvaders extends ApplicationAdapter {

	private Controlador vgControlador;
	/*
	SpriteBatch batch;
	Texture img;
	Texture fondo;

	 */
	
	@Override
	public void create () {
		/*
		batch = new SpriteBatch();
		img = new Texture("Navealiada.png");
		fondo = new Texture ("Galaxia.jpg");

		 */
		vgControlador = new Controlador();
	}

	@Override
	public void render () {
		/*

		batch.begin();
		batch.draw(fondo, 0, 0);
		batch.draw(img, Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth()/2);
		batch.end();

		 */
		vgControlador.render();
	}
	
	@Override
	public void dispose () {
		/*
		batch.dispose();
		img.dispose();

		 */
		vgControlador.dispose();
	}
}
