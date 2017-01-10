package guiSimon.components;

import java.awt.Color;


import gui.components.Action;
import gui.components.Button;
import gui.components.Visible;
import simonDaniel.SimonScreen;

public class ColorButton extends Button implements ButtonInterface, Visible {
	private int colorIdentifier;
	private Action buttonAction;
	public ColorButton(int x, int y, int w, int h, String text, Color color, gui.components.Action action, int value) {
		super(x, y, w, h, text, color, action);
		colorIdentifier = value;
		buttonAction = action;
		
	}
	@Override
	public int sendValue() {
		//Returns the value;
		return 0;
	}
	@Override
	public void checkNumberOfButtonsClicked() {
		
		
	}

}
