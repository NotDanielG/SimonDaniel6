package guiSimon.components;

import java.awt.Color;

import gui.components.Action;
import guiSimon.components.Clickable;

public interface ButtonInterfaceDaniel extends Clickable {
	int sendValue(); 
	void setAction(Action action);
	void setX(int x);
	void setY(int y);
	void setColor(Color c);
	void highlight();
	void dim();
	
}
