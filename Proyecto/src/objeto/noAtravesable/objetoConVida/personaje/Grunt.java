package objeto.noAtravesable.objetoConVida.personaje;

import game.gfx.AnimationEnemy;
import game.gfx.ImageLoader;
import logica.visitor.VisitorEnemigo;
import objeto.noAtravesable.ObjectStateMoving;
import objeto.noAtravesable.ObjetoNoAtravesable;
import logica.*;

public class Grunt extends Enemigo{
	public Grunt(Tile t){
		super();
		vida=45;
		maxVida=45;
		miTile=t;
		velocidadMov = 0.5f;
		velocidadAt=3.0f;
		animation = new AnimationEnemy(this,0, t.getFila() * 64, velocidadAt, velocidadMov, ImageLoader.gruntAtk, ImageLoader.gruntMove);
		t.setComponente(this);
		image = ImageLoader.grunt;
		ancho=1;
		alto=1;
		impacto=20;
		alcance=1;
		velMovMaxima=2.0f;
		velAtMaxima=0.7f;
		puntaje=20;
		Coins=15;
		reloj=1;
		v = new VisitorEnemigo(this);
		state = new ObjectStateMoving();
	}
	public ObjetoNoAtravesable clone(){
		return new Grunt(new Tile(null,0,0));
	}
}
