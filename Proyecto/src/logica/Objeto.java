package logica;

import java.awt.image.BufferedImage;

public abstract class Objeto {
	//atributos
	protected Tile miTile;
	protected BufferedImage image;
	protected int ancho;
	protected int alto;
	
	//metodos
	public BufferedImage getImage(){
		return image;
	}
	public Tile getTile(){
		return miTile;
	}
	public void setTile(Tile t){
		miTile=t;
	}
	
	public void accept(ObjectManager o){	
	}

	public int getAncho(){
		return ancho;
	}
	public int getAlto(){
		return alto;
	}
}
