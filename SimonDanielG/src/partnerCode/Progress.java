package partnerCode;

import java.awt.Color;

import java.awt.Graphics2D;

import gui.components.Components;
import guiSimon.components.ProgressInterfaceDaniel;
import gui.components.Visible;

public class Progress extends Components implements ProgressInterfaceDaniel, Visible {
	private int score;
	private int difficulty;
	public Progress(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void increaseScore(int i) {
		score += i;
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

	@Override
	public void setGameDifficulty(int i) {
		difficulty = i;
		update();
	}

}
