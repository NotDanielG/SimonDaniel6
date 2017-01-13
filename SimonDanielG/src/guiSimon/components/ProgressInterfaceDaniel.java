package guiSimon.components;

import gui.components.Visible;

public interface ProgressInterfaceDaniel extends Visible {
	void increaseScore(int i);
	void setGameDifficulty(int i);
	void gameOver();
}
