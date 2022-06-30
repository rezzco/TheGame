package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class GameScreen extends JPanel {

	private Random random;
	private BufferedImage img;
	private long lastTime;
	private int  frames;


	private ArrayList<BufferedImage> sprites = new ArrayList<>();

	public GameScreen(BufferedImage img) {
		super(new FlowLayout(FlowLayout.CENTER, 0, 0));
		this.img = img;
		loadSprites();
		random = new Random();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {

				g.setColor(getRandomColore());
				//g.fillRect(i * 32, j * 32, 32, 32);
				g.drawImage(sprites.get(getRandomIndex()), i * 32, j * 32, null);
			}
		}
//		BufferedImage ork = img.getSubimage(0, 32, 32, 32);
		 getFPS();

		
	}

	
	private void getFPS() {
		frames++;
		if (System.currentTimeMillis()-lastTime>=1000) {
			System.out.println("FPS: " +frames);
			frames=0;
			lastTime=System.currentTimeMillis();
		}
	}
	private Color getRandomColore() {
		return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
	}

	private int getRandomIndex() {
		return random.nextInt(sprites.size());
	}
	private void loadSprites() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				sprites.add(img.getSubimage(j * 32, i * 32, 32, 32));
			}

		}

	}
}
