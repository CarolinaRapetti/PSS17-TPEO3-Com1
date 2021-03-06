package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.display.DisplayJuego;
import game.gfx.GameGraphics;
import logica.Logica;

public class GameState implements UIState{

	private GameGraphics graphics;
	private static Logica logica = Logica.getLogica();
	private DisplayJuego display;
	private BufferStrategy bs;
	
	
	public GameState(DisplayJuego display){
		this.display = display;
		this.graphics = new GameGraphics();
	}
	
	@Override
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		graphics.setGraphics(g);
		graphics.dibujarMapa();
		
		bs.show();
		g.dispose();
	}

	@Override
	public void actualizar() {
		logica.actualizar();
		display.actualizarPuntaje(logica.getScore());
	}

	@Override
	public void interactuar() {
		
	}

	
	
}
