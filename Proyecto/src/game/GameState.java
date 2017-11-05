package game;

import java.awt.Graphics;

import game.display.Display;
import game.gfx.GameGraphics;
import logica.Logica;

public class GameState implements UIState{

	private GameGraphics graphics;
	private static Logica logica = Logica.getLogica();
	private Display display;
	
	
	public GameState(Display display, GameGraphics graphics){
		this.display = display;
		this.graphics = graphics;
	}
	
	@Override
	public void render(Graphics g) {
		graphics.setGraphics(g);
		graphics.dibujarMapa();
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
