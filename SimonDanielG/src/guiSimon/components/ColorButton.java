package guiSimon.components;

import java.awt.Color;

import gui.components.Action;
import gui.components.Button;
import gui.components.Visible;

public class ColorButton extends Button implements ButtonInterfaceDaniel, Visible {
	private int colorIdentifier;
	private gui.components.Action buttonAction;
	public ColorButton(int x, int y, int w, int h, String text, Color color, Action action, int value) {
		super(x, y, w, h, text, color, action);
		
	}
	public int sendValue() {
		//Returns the value;
		return 0;
	}
	public void setAction(Action action) {
		
		
	}
	public void highlight() {
		// TODO Auto-generated method stub
		
	}
	public void dim() {
		// TODO Auto-generated method stub
		
	}
}
