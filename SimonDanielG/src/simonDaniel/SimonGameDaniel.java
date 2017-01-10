package simonDaniel;

import gui.GUIApplication;

public class SimonGameDaniel extends GUIApplication {
	
	private static SimonGameDaniel game;
	private static SimonScreenDaniel screen;
	public SimonGameDaniel(int width, int height) {
		super(width, height);
	}
	public void initScreen() {
		screen = new SimonScreenDaniel(getWidth(),getHeight());
		setScreen(screen);

	}

	public static void main(String[] args) {
		game = new SimonGameDaniel(800,600);
		Thread app = new Thread(game);
		app.start();
	}

}
