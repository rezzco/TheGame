package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Render {

	private GameScreen gameScreen;
	private BufferedImage img;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private Random random;

	public Render(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		random = new Random();
		importImage();
		loadSprites();
		
	}

	public void render(Graphics g) {
		switch (GameStates.gameStates) {
		case PLAYING:
			break;
		case MENU:
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {

					g.setColor(getRandomColore());
					// g.fillRect(i * 32, j * 32, 32, 32);
					g.drawImage(sprites.get(getRandomIndex()), i * 32, j * 32, null);
				}
			}
			break;
		case SETTINGS:
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + GameStates.gameStates);
		}
	}

	private void loadSprites() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				sprites.add(img.getSubimage(j * 32, i * 32, 32, 32));
			}

		}

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
	private Color getRandomColore() {
		return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
	}

	private int getRandomIndex() {
		return random.nextInt(sprites.size());
	}

}
