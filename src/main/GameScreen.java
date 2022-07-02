package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class GameScreen extends JPanel {

	private Random random;
	private BufferedImage img;

	private Dimension screenSize;

	private ArrayList<BufferedImage> sprites = new ArrayList<>();

	public GameScreen(BufferedImage img) {
		setPanelSize();
		this.img = img;
		loadSprites();
		random = new Random();
	}

	private void setPanelSize() {
		screenSize = new Dimension(640, 640);
		setMinimumSize(screenSize);
		setPreferredSize(screenSize);
		setMaximumSize(screenSize);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {

				g.setColor(getRandomColore());
				// g.fillRect(i * 32, j * 32, 32, 32);
				g.drawImage(sprites.get(getRandomIndex()), i * 32, j * 32, null);
			}
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
