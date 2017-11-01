package objeto.noAtravesable.objetoConVida.Premios;

import java.util.LinkedList;

import game.display.PremioManager;
import game.gfx.ImageLoader;
import logica.Tile;
import logica.visitor.VisitorFrenzy;
import objeto.noAtravesable.ObjetoNoAtravesable;
import objeto.noAtravesable.objetoConVida.personaje.Aliado;
import objetosTemporales.EfectoFrenzy;

public class Frenzy extends Premio{
	
	private EfectoFrenzy efecto;
	private LinkedList<Aliado> lista;
	private VisitorFrenzy visitor;
	
	public Frenzy(){
		super();
		image = ImageLoader.pFrenzy;
		b = PremioManager.frenzy;
		lista = new LinkedList<Aliado>();
		visitor = new VisitorFrenzy(this);
	}
	
	public void agregarALista(Aliado aliado){
		lista.addLast(aliado);
	}
	
	public ObjetoNoAtravesable clone() {
		return new Frenzy();
	}
	
	public void efecto(Tile t) {
		
		int x=t.getFila();
		int y=t.getColumna();
		
		if(t.getComponente()!=null)
			t.getComponente().accept(visitor);
		
		if (x != 0 && y != 0 && t.getLeft().getArriba().getComponente()!=null)
			t.getLeft().getArriba().getComponente().accept(visitor);
		
		if (x != 0 && t.getArriba().getComponente()!=null)
			t.getArriba().getComponente().accept(visitor);
		
		if (x != 0 && y != 11 && t.getArriba().getRight().getComponente()!=null)
			t.getArriba().getRight().getComponente().accept(visitor);
		
		if (y != 0 && t.getLeft().getComponente()!=null)
			t.getLeft().getComponente().accept(visitor);
		
		if (x != 5 && y != 0 && t.getAbajo().getLeft().getComponente()!=null)
			t.getAbajo().getLeft().getComponente().accept(visitor);
		
		if (x != 5 && t.getAbajo().getComponente()!=null)
			t.getAbajo().getComponente().accept(visitor);
		
		if (x != 5 && y != 11 && t.getAbajo().getRight().getComponente()!=null)
			t.getAbajo().getRight().getComponente().accept(visitor);
		
		if (y != 11 && t.getRight().getComponente()!=null)
			t.getRight().getComponente().accept(visitor);
		
		efecto = new EfectoFrenzy(300, logica, 1.2f, lista);
	}
	
}
