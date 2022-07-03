package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import inputs.KeyboardListener;
import inputs.MouseActionListener;

public class Game extends JFrame implements Runnable {

	private static final double FPS_SET = 120.0;
	private static final double UPS_SET = 60.0;
	private GameScreen gameScreen;
	private BufferedImage img;
	
	private MouseActionListener mouseListener ;
	private KeyboardListener keyboardListener;

	private Thread gameThread;

	public Game() {
		super();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		gameScreen = new GameScreen(this);
		add(gameScreen);
		pack();
		setVisible(true);

	}

	private void initInputs() {
		mouseListener = new MouseActionListener();
		keyboardListener = new KeyboardListener();
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		addKeyListener(keyboardListener);
		
		requestFocus();

	}
	

	private void updateGame() {

	}

	public static void main(String[] args) {
		Game g = new Game();
		g.start();

	}

	private void start() {
		gameThread = new Thread(this) {};
		initInputs();
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
		long now;

		// Render
		while (true) {
			now = System.nanoTime();
			if (now - lastFrame >= timePerFrame) {
				repaint();
				lastFrame = now;
				frames++;
			}
//			Update
			if (now - lastUpdate >= timePerUpdate) {
				updateGame();
				updates++;
				lastUpdate = now;
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
