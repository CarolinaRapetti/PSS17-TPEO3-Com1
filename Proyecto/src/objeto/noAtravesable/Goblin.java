package objeto.noAtravesable;

import logica.*;

public class Goblin extends Enemigo {
	//constructor
	public Goblin(Tile t){
		vida=35;
		maxVida=35;
		miTile=t;
		image=ImageLoader.goblin;
		ancho=1;
		alto=1;
		impacto=10;
		alcance=1;
		velocidad=0.7f;
		vel=0.7f;
		puntaje=20;
		maxCoins=15;
		minCoins=5;
	}
}