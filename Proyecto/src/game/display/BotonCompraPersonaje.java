package game.display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import game.gfx.ImageLoader;
import logica.Objeto;
import objeto.noAtravesable.ObjetoNoAtravesable;

@SuppressWarnings("serial")
public class BotonCompraPersonaje extends BotonCompra{
	//atributos
	protected ObjetoNoAtravesable o;
	
	public BotonCompraPersonaje(PanelTienda pan, BufferedImage i, ObjetoNoAtravesable ob){
		super(pan, ob.getValor());
		setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
		setDisabledIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAnulado.png")));
		addMouseListener(new OyenteCompra());
		o=ob;
		setearIcono(i);
	}
	
	
	private class OyenteCompra implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
			setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonPresionado.png")));
		}
		public void mouseReleased(MouseEvent arg0) {
			if(((BotonCompra)arg0.getSource()).isEnabled()){
				setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/Boton.png")));
				Objeto aux=o.clone();
				p.setPrototype(aux);
			}
		}
	}
}
