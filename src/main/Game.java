package main;

import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame{
	
	private GameScreen gameScreen;
	private BufferedImage img;

	public Game() {
		super();

		importImage();
		
		setSize(640, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		gameScreen = new GameScreen(img);
		add(gameScreen);
	}

	private void importImage() {
		InputStream is = getClass().getResourceAsStream("/spriteatlas.png");
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Game g = new Game();
		

	}

}
