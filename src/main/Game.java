package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {

	private static final double FPS_SET = 120.0;
	private static final double UPS_SET = 60.0;
	private GameScreen gameScreen;
	private BufferedImage img;

	private Thread gameThread;

	public Game() {
		super();

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

	private void updateGame() {

	}

	public static void main(String[] args) {
		Game g = new Game();
		g.start();

	}

	private void start() {
		gameThread = new Thread(this) {
		};
		gameThread.start();

	}

	@Override
	public void run() {
		double timePerFrame = 1000_000_000.0 / FPS_SET;		
		double timePerUpdate = 1000_000_000.0 / UPS_SET;
		
		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		
		long lastOneSecound = System.currentTimeMillis();

		int updates = 0;
		int frames = 0;

		// Render
		while (true) {
			if (System.nanoTime() - lastFrame >= timePerFrame) {
				repaint();
				lastFrame = System.nanoTime();
				frames++;
			}
//			Update
			if (System.nanoTime() - lastUpdate >= timePerUpdate) {
				updateGame();
				updates++;
				lastUpdate = System.nanoTime();
			}
			if (System.currentTimeMillis() - lastOneSecound >= 1000) {
				System.out.println("FPS: " + frames + "|" + "UPS: " + updates);
				updates = 0;
				frames = 0;
				lastOneSecound = System.currentTimeMillis();

			}

		}

//		Checking FPS and UPS

	}

}
