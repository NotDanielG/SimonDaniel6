package partnerCode;

import java.awt.Color;


import gui.components.Action;
import gui.components.Button;
import gui.components.Clickable;
import gui.components.Visible;
import guiSimon.components.ButtonInterfaceDaniel;

public class ColorButton extends Button implements ButtonInterfaceDaniel{
	private int colorIdentifier;
	private Color color;
	private Color orgColor;
	private Action buttonAction;
	public ColorButton(int x, int y, int w, int h, String text, Color color, Action action, int value) {
		super(x, y, w, h, text, color, action);
		colorIdentifier = value;
		orgColor = color;
	}
	public int sendValue() {
		return colorIdentifier;
	}
	public void setAction(Action action) {
		buttonAction = action;
	}
	public void highlight() {
		this.setColor(orgColor);
	}
	public void dim() {
		this.setColor(Color.WHITE);
	}
//	public void act(){
//		buttonAction.act();
//		//idk if u need this
//	}
}
