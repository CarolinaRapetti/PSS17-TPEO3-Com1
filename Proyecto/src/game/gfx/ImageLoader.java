package game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	private static int width = 32, height = 32;
	private static BufferedImage sheet;
	public static BufferedImage tierra, agua, piedra , arbol, fondo;
	public static BufferedImage mago, espadachin, paladin, arquero, monje, campeonEnano, cazadorEnano, druida, oso, treant;
	public static BufferedImage goblin, brujo, grunt, jefeOrco, orcoBallestero;
	public static BufferedImage pBolaDeFuego, pBomba, pEscudo, pFrenzy, pPeste, pWololo;
	public static BufferedImage[] vida = new BufferedImage[3];
	public static BufferedImage[] goblinMove = new BufferedImage[4];
	public static BufferedImage[] goblinAtk = new BufferedImage[4];
	public static BufferedImage[] mageAtk = new BufferedImage[4];
	public static BufferedImage[] warriorAtk = new BufferedImage[4];
	public static BufferedImage[] monkAtk = new BufferedImage[4];
	public static BufferedImage[] paladinAtk = new BufferedImage[4];
	public static BufferedImage[] arqueroAtk = new BufferedImage[4];
	public static BufferedImage[] dwarfHunterAtk = new BufferedImage[4];
	public static BufferedImage[] warlockAtk = new BufferedImage[4];
	public static BufferedImage[] warlockMove = new BufferedImage[4];
	public static BufferedImage[] gruntAtk = new BufferedImage[4];
	public static BufferedImage[] gruntMove = new BufferedImage[4];
	public static BufferedImage[] portalBlue = new BufferedImage[4];
	public static BufferedImage[] aguaMov = new BufferedImage[4];
	public static BufferedImage[] lava = new BufferedImage[4];
	public static BufferedImage[] portalOrange = new BufferedImage[4];
	public static BufferedImage[] jefeOrcoMov = new BufferedImage[4];
	public static BufferedImage[] orcoBallestaMov = new BufferedImage[4];
	public static BufferedImage[] orcoBallestaAtk = new BufferedImage[4];
	public static BufferedImage[] campeonEnanoAtk = new BufferedImage[4];
	
 	public static void init(){
 		fondo = loadImage("/Textures/Fondo.png");
		sheet = loadImage("/Textures/SpriteSheet3x2.png");
		//tierra = new BufferedImage[1]; 
		tierra = sheet.getSubimage(0, 0, width, height);
		//agua = new BufferedImage[1];
		agua = sheet.getSubimage(0, height, width, height);
		//piedra = new BufferedImage[1]; 
		piedra = sheet.getSubimage(width, 0, width, height);
		//arbol = new BufferedImage[1];
		arbol = loadImage("/Textures/arbol.png");
		lava[0] = sheet.getSubimage(0, 64, 32, 32);
		lava[1] = sheet.getSubimage(0, 64, 32, 32);
		lava[2] = sheet.getSubimage(0, 64, 32, 32);
		lava[3] = sheet.getSubimage(0, 64, 32, 32);
		espadachin = loadImage("/Textures/Personajes/Soldado.png");
		paladin = loadImage("/Textures/Personajes/Paladin.png");
		arquero = loadImage("/Textures/Personajes/Arquero.png");
		monje = loadImage("/Textures/Personajes/Clerigo.png");
		mago = loadImage("/Textures/Personajes/mago.png");
		druida = loadImage("/Textures/Personajes/Druida.png");
		treant = loadImage("/Textures/Personajes/Treant.png");
		goblin=loadImage("/Textures/Personajes/Goblin.png");
		brujo=loadImage("/Textures/Personajes/OrcoBrujo.png");
		orcoBallestero=loadImage("/Textures/Personajes/Orco Ballestero.png");
		campeonEnano=loadImage("/Textures/Personajes/Campeon Enano.png");
		cazadorEnano=loadImage("/Textures/Personajes/Cazador Enano.png");
		oso=loadImage("/Textures/Personajes/Oso.png");
		grunt=loadImage("/Textures/Personajes/Grunt.png");
		jefeOrco = loadImage("/Textures/Personajes/Jefe Orco.png");
		vida[0] =loadImage("/Textures/VidaVerde.png");
		vida[1] =loadImage("/Textures/VidaRoja.png");
		vida[2] =loadImage("/Textures/VidaAzul.png");
		sheet = loadImage("/Textures/Animations/Goblin walk.png");
		pBolaDeFuego = loadImage("/Textures/Premios/PremioBolaFuego.png");
		pBomba = loadImage("/Textures/Premios/PremioBomba.png");
		pEscudo = loadImage("/Textures/Premios/PremioEscudo.png");
		pFrenzy = loadImage("/Textures/Premios/PremioFrenzy.png");
		pPeste = loadImage("/Textures/Premios/PremioPeste.png");
		pWololo = loadImage("/Textures/Premios/PremioWololo.png");
		goblinMove[0] = sheet.getSubimage(0, 0, 64, 64);
		goblinMove[1] = sheet.getSubimage(64, 0, 64, 64);
		goblinMove[2] = sheet.getSubimage(128, 0, 64, 64);
		goblinMove[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/Goblin attack.png");
		goblinAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		goblinAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		goblinAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		goblinAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		warriorAtk[0] = espadachin;
		warriorAtk[1] = espadachin;
		warriorAtk[2] = espadachin;
		warriorAtk[3] = espadachin;
		monkAtk[0] = monje;
		monkAtk[1] = monje;
		monkAtk[2] = monje;
		monkAtk[3] = monje;
		paladinAtk[0] = paladin;
		paladinAtk[1] = paladin;
		paladinAtk[2] = paladin;
		paladinAtk[3] = paladin;
		sheet = loadImage("/Textures/Animations/Archer attack.png");
		arqueroAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		arqueroAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		arqueroAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		arqueroAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/Mage attack.png");
		mageAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		mageAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		mageAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		mageAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/DwarfHunter attack.png");
		dwarfHunterAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		dwarfHunterAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		dwarfHunterAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		dwarfHunterAtk[3] = sheet.getSubimage(192, 0, 64, 64);
		warlockAtk[0] = brujo;
		warlockAtk[1] = brujo;
		warlockAtk[2] = brujo;
		warlockAtk[3] = brujo;
		sheet = loadImage("/Textures/Animations/Warlock Walk.png");
		warlockMove[0] = sheet.getSubimage(0, 0, 64, 64);
		warlockMove[1] = sheet.getSubimage(64, 0, 64, 64);
		warlockMove[2] = sheet.getSubimage(128, 0, 64, 64);
		warlockMove[3] = sheet.getSubimage(192, 0, 64, 64);
		gruntAtk[0] = grunt;
		gruntAtk[1] = grunt;
		gruntAtk[2] = grunt;
		gruntAtk[3] = grunt;
		sheet = loadImage("/Textures/Animations/OrcoWalk.png");
		gruntMove[0] = sheet.getSubimage(0, 0, 64, 64);
		gruntMove[1] = sheet.getSubimage(64, 0, 64, 64);
		gruntMove[2] = sheet.getSubimage(128, 0, 64, 64);
		gruntMove[3] = sheet.getSubimage(192, 0, 64, 64);
		sheet = loadImage("/Textures/Animations/PortalBlue.png");
		portalBlue[0] = sheet.getSubimage(0, 0, 32, 32);
		portalBlue[1] = sheet.getSubimage(32, 0, 32, 32);
		portalBlue[2] = sheet.getSubimage(64, 0, 32, 32);
		portalBlue[3] = sheet.getSubimage(96, 0, 32, 32);
		sheet = loadImage("/Textures/Animations/PortalOrange.png");
		portalOrange[0] = sheet.getSubimage(0, 0, 32, 32);
		portalOrange[1] = sheet.getSubimage(32, 0, 32, 32);
		portalOrange[2] = sheet.getSubimage(64, 0, 32, 32);
		portalOrange[3] = sheet.getSubimage(96, 0, 32, 32);
		aguaMov[0] = agua;
		aguaMov[1] = agua;
		aguaMov[2] = agua;
		aguaMov[3] = agua;
		jefeOrcoMov[0] = jefeOrco;
		jefeOrcoMov[1] = jefeOrco;
		jefeOrcoMov[2] = jefeOrco;
		jefeOrcoMov[3] = jefeOrco;
		orcoBallestaMov[0] = orcoBallestero;
		orcoBallestaMov[1] = orcoBallestero;
		orcoBallestaMov[2] = orcoBallestero;
		orcoBallestaMov[3] = orcoBallestero;
		orcoBallestaAtk[0] = orcoBallestero;
		orcoBallestaAtk[1] = orcoBallestero;
		orcoBallestaAtk[2] = orcoBallestero;
		orcoBallestaAtk[3] = orcoBallestero;
		sheet = loadImage("/Textures/Animations/DwarfChampion attack.png");
		campeonEnanoAtk[0] = sheet.getSubimage(0, 0, 64, 64);
		campeonEnanoAtk[1] = sheet.getSubimage(64, 0, 64, 64);
		campeonEnanoAtk[2] = sheet.getSubimage(128, 0, 64, 64);
		campeonEnanoAtk[3] = sheet.getSubimage(192, 0, 64, 64);	
	}
	
	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
