package guiSimon.components;

import java.awt.Color;
import java.awt.Graphics2D;

import guiSimon.components.Components;
import guiSimon.components.Visible;

public class Player extends Components implements PlayerInterface, Visible {
	private int score;
	private int difficulty;
	public Player(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void increaseScore(int i) {
		//Increase the score of the player
		score++;
		update();

	}

	@Override
	public void increaseLength(int i) {
		//Number of sequences player needs to remember
		difficulty++;
		update();

	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(new Color (200,220,255));
		g.fillOval(0, 0, 109, 109);
		g.setColor(Color.black);
		g.drawOval(0, 0, 109, 109);
		g.drawString("Score = "+score, 30, 55);
		g.drawString("Length = "+difficulty, 30, 75);
	}

}
