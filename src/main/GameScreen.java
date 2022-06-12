package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameScreen extends JPanel{

	public GameScreen() {
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillRect(60, 60, 80, 80);
		g.drawRect(50, 50, 100, 100);
	}
	

}
