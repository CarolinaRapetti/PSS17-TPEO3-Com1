package logica;

import objeto.atravesable.*;
import objeto.noAtravesable.*;

public class ObjectManager {
	//metodos
	public void visit(Aliado a){
		boolean ataque=false;
		Tile actual = a.getTile().getLeft();
		for(int i=0; i<a.getAlcance() && !ataque; i++){
			if(actual.getComponente()!=null){
				ataque=actual.getComponente().serAtacado(a);;
			}
			actual=actual.getLeft();
		}
		if(!ataque)
			a.aumentarReloj();
	}
	public void visit(Enemigo e){
		boolean encontre=false;
		Tile actual=e.getTile();
		if (actual.getColumna()==11){
			encontre=true;
		}
		for(int i=0; i<e.getAlcance() && !encontre; i++){
			actual=actual.getRight();
			if(actual.getComponente()!=null){
				encontre=true;
				actual.getComponente().serAtacado(e);
			}
		}
		if(!encontre){
			e.avanzar();
		}
	}
	public void visit(ObjetoAtravesable oa){
		oa.modificar(oa.getTile().getComponente());
	}
}
