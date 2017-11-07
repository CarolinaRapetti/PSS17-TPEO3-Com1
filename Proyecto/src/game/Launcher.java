package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import sun.audio.*;

public class Launcher {

	public static void main(String[] args) throws Exception{
		String audio = "nix.wav";
		InputStream in = new FileInputStream(audio);
		AudioStream music = new AudioStream(in);

		Object seleccion = JOptionPane.showInputDialog(null, "Seleccione el idioma", "Idioma", JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Ingles", "Castellano"}, null); 

		int idiom=0;
		if(seleccion=="Ingles") 
			idiom=1;
		
		
		Game game = new Game("Juegazo", 768 , 384, idiom);
		
		game.start();
		AudioPlayer.player.start(music);
	}

}
