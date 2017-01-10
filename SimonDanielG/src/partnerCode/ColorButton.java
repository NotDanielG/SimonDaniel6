package partnerCode;

import java.awt.Color;


import gui.components.Action;
import gui.components.Button;
import gui.components.Visible;
import guiSimon.components.ButtonInterfaceDaniel;

public class ColorButton extends Button implements ButtonInterfaceDaniel, Visible {
	private int colorIdentifier;
	private Action buttonAction;
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
		
		
	}
	public void dim() {
		
		
	}
}
