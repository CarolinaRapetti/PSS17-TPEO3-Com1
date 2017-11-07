package game.display;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

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
	private int idiom;
	private JMenuItem idioma,acerca,salir,puntos;
	
	//constructor
	public Display(String title, int width, int height, Game g){

		idiom=0;
		
		myGame = g;
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JMenuBar barra= new JMenuBar();
		idioma= new JMenuItem("Idioma");
		
		idioma.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object seleccion = JOptionPane.showInputDialog(null, "Seleccione el idioma", "Idioma", JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Ingles", "Castellano"}, null); 
				idiomaSeleccionado(seleccion);			
			}
		});
		
		acerca = new JMenuItem("Acerca");		
		acerca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "TDP: Vicencio Florencia, Rodriguez Emanuel, Rodriguez Joaquin.\n PSS: Manuela Fernandez, Contanza Giorgetti, Carolina Rapetti",
						"Acerca de", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		salir= new JMenuItem("Salir");
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		puntos= new JMenuItem("Puntajes historicos");
		puntos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cargarTabla();
			}
		});
				
		barra.add(idioma);
		barra.add(acerca);
		barra.add(salir);
		barra.add(puntos);
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
	
	private void cargarTabla(){
		String[] columnNames = {"Puntaje",
                "Fecha",
                "Hora"};
		
		DisplayJuego d = new DisplayJuego(myGame);
		String p=d.getPanelTienda().obtenerPuntaje();
		String f=d.getPanelTienda().obtenerFecha();
		String h=d.getPanelTienda().obtenerHora();
		
		
		Object[][] data = {
			    {p,f,h},
			    {"1220", "01/11/2017",
			     "12:30"},
			    {"470", "29/10/2017",
			     "15:00"},
			    {"5000", "20/10/2017",
			     "16:40"},
			    {"900", "11/10/2017",
			     "14:25"},
			    {"20", "09/10/2017",
			     "04:00"},
			    {"100", "07/10/2017",
			     "13:32"},
			    {"90", "03/10/2017",
			     "01:20"},
			    {"990", "21/09/2017",
			     "20:38"},
			    {"10", "18/09/2017",
			     "11:11"},
			};
		
		JTable table = new JTable(data, columnNames);
				
		table.setSize(450, 400);		
		
		JFrame nuevo = new JFrame("Puntajes Historicos");
		nuevo.setVisible(true);
		nuevo.setExtendedState(JFrame.MAXIMIZED_BOTH);
		nuevo.setSize(450, 400);
		nuevo.setLayout(new BorderLayout());
		nuevo.add(table.getTableHeader(), BorderLayout.PAGE_START);
		nuevo.add(table, BorderLayout.CENTER);
	}
	
	
	private void idiomaSeleccionado(Object s){
		
		if(s=="Ingles"){
			idiom=1;
		}
	}
}
