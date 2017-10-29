package logica.visitor;

import objeto.atravesable.Agua;
import objeto.noAtravesable.objetoConVida.OMConVida.OMConVida;
import objeto.noAtravesable.objetoConVida.OTConVida.OTConVida;
import objeto.noAtravesable.objetoConVida.Premios.Premio;
import objeto.noAtravesable.objetoConVida.personaje.Aliado;
import objeto.noAtravesable.objetoConVida.personaje.Enemigo;

public class VisitorAgua extends Visitor{
	//atributos
	protected Agua agua;
	
	//constructor
	public VisitorAgua(Agua a){
		agua=a;
	}
	
	//metodos
	public void afectar(Aliado a) {}
	public void afectar(Enemigo e) {
		e.modificarVelocidad(agua.getRall());
	}
	public void afectar(OTConVida otcv) {}
	public void afectar(OMConVida omcv) {}
	public void afectar(Premio p) {}
	
}
