package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class GameScreen extends JPanel {

	private Dimension screenSize;
	private Render render;
	private Game game;

	public GameScreen(Game game) {
		this.game = game;
		this.render = new Render(this);
		setPanelSize();

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
		render.render(g);

	}

}
