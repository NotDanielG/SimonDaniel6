package guiSimon.components;

import guiSimon.components.Clickable;

public interface ButtonInterface extends Clickable {
	int sendValue(); 
	void checkNumberOfButtonsClicked();
}
