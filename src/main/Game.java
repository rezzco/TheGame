package main;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Game extends JFrame{
	
	private GameScreen gameScreen;
	private BufferedImage img;
	private double timePerFrame;
	private long lastFrame;
	
	private double timePerUpdate;
	private long lastUpdate;
	private int updates;
	private long lastTimeUPS;

	public Game() {
		super();

		timePerFrame = 1000000000.0/120.0;
		timePerUpdate = 1000000000.0/60.0;
		
		importImage();
		
		setSize(640, 640);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		gameScreen = new GameScreen(img);
		add(gameScreen);
		setVisible(true);

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
	private void gameLoop() {
		while(true) {
			if(System.nanoTime()-lastUpdate>=timePerUpdate) {				
				updateGame();
				callUPS();
			}
			if (System.nanoTime() - lastFrame>=timePerFrame) {
				repaint();
				lastFrame=System.nanoTime();
			} else {

			}

		}
	}

	private void callUPS() {
		if(System.currentTimeMillis()-lastTimeUPS>=1000) {
			System.out.println("UPS: "+ updates);
			updates=0;
			lastTimeUPS=System.currentTimeMillis();
		}
		
		
	}

	private void updateGame() {
		updates++;
		lastUpdate=System.nanoTime();
		
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.gameLoop();
		

	}

}
