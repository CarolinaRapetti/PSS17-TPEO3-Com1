package game.display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.Game;
import game.GameState;
import game.MenuState;
import game.UIState;

public class Display {
	//atributos
	private JFrame frame;
	private JPanel panel;
	private UIState state;
	private Game myGame;
	
	//constructor
	public Display(String title, int width, int height, Game g){
		
		myGame = g;
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JMenuBar barra= new JMenuBar();
		JMenuItem acerca= new JMenuItem("Acerca");
		acerca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "TDP: Vicencio Florencia, Rodriguez Emanuel, Rodriguez Joaquin.\n PSS: Manuela Fernandez, Constanza Giorgetti, Carolina Rapetti",
						"About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		barra.add(acerca);
		barra.add(salir);
		frame.setJMenuBar(barra);
		
		
		frame.pack();
	}
	public void setJuego(){
		if(panel!=null)
			frame.remove(panel);
		DisplayJuego d = new DisplayJuego(myGame);
		state = new GameState(d);
		panel = d;
		frame.add(panel);
		frame.pack();
	}
	public void setMenu(){
		if(panel!=null)
			frame.remove(panel);
		Menu m = new Menu(myGame);
		state = new MenuState(m);
		panel = m;
		frame.add(panel);
		frame.pack();
	}
	public UIState getState(){
		return state;
	}
}
