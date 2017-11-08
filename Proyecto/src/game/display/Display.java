package game.display;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	private JMenuItem acerca,salir,puntos;
	
	//constructor
	public Display(String title, int width, int height, Game g, int idiom){
		
		myGame = g;
		this.idiom=idiom;
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JMenuBar barra= new JMenuBar();
		
		String a,s,p;
		if(idiom==0){
			a="Acerca";
			s="Salir";
			p="Puntaje historico";			
		}
		else{
			a="About";
			s="Exit";
			p="Score";
		}
		
		acerca = new JMenuItem(a);		
		acerca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "TDP: Vicencio Florencia, Rodriguez Emanuel, Rodriguez Joaquin.\n PSS: Manuela Fernandez, Contanza Giorgetti, Carolina Rapetti",
						a, JOptionPane.INFORMATION_MESSAGE);
			}
		});

		salir= new JMenuItem(s);
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		puntos= new JMenuItem(p);
		puntos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cargarTabla();
			}
		});
			
		barra.add(acerca);
		barra.add(salir);
		barra.add(puntos);
		frame.setJMenuBar(barra);
		
		
		frame.pack();
	}
	public void setJuego(){
		if(panel!=null)
			frame.remove(panel);
		DisplayJuego d = new DisplayJuego(myGame,idiom);
		state = new GameState(d);
		panel = d;
		frame.add(panel);
		frame.pack();
	}
	public void setMenu(){
		if(panel!=null)
			frame.remove(panel);
		Menu m = new Menu(myGame);
		state = new MenuState();
		panel = m;
		frame.add(panel);
		frame.pack();
	}
	public UIState getState(){
		return state;
	}
	

	
	private void cargarTabla(){
		String s,d,t;
		if(idiom == 1){
			s="Score";
			d="Date";
			t="Time";
		}
		else{
			s="Puntaje";
			d="Fecha";
			t="Hora";
		}	
		String ruta = "res/Puntaje/archivo.txt";
		File archivo = new File(ruta);
		FileReader flwreader = null;	
		BufferedReader br=null;
		
		JTable tabla = new JTable();
		DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
		modelo.addColumn(s);
		modelo.addColumn(d);
		modelo.addColumn(t);
		tabla.setSize(450, 400);
		
		if(archivo.exists()) 
			try {
				flwreader = new FileReader(archivo);
				br = new BufferedReader(flwreader);
				String line=br.readLine();
				while(line!=null){					
					String[] data=line.split(" ");
					modelo.addRow(data);
					line=br.readLine();				
				}
				
				br.close();
			} catch (IOException e) {e.printStackTrace();}		
						
		
		JFrame nuevo = new JFrame("Puntajes Historicos");
		nuevo.setVisible(true);
		nuevo.setExtendedState(JFrame.MAXIMIZED_BOTH);
		nuevo.setSize(450, 400);
		nuevo.setLayout(new BorderLayout());
		nuevo.add(tabla.getTableHeader(), BorderLayout.PAGE_START);
		nuevo.add(tabla, BorderLayout.CENTER);
	}
	
}
