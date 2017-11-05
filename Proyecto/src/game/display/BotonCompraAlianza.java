package game.display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import game.gfx.ImageLoader;

@SuppressWarnings("serial")
public class BotonCompraAlianza extends BotonCompra{
	//atributos
		protected String alianza;
		
		
		public BotonCompraAlianza(PanelTienda pan, int valor, String al){
			super(pan, valor);
			setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAlianza.png")));
			setDisabledIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAlianzaAnulado.png")));
			alianza=al;
			addMouseListener(new OyenteCompra());
			setearTexto("Buy alliance with "+al);
		}
		
		private class OyenteCompra implements MouseListener{
			public void mouseClicked(MouseEvent arg0) {
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
				setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAlianzaPresionado.png")));
			}
			public void mouseReleased(MouseEvent arg0) {
				if(((BotonCompra)arg0.getSource()).isEnabled()){
					setIcon(new ImageIcon(ImageLoader.loadImage("/Textures/BotonAlianza.png")));
					p.comprarAlianza(alianza, valor);
				}
			}
		}
}
