package simonDaniel;

import gui.GUIApplication;

public class SimonSays extends GUIApplication {
	
	private static SimonSays game;
	private static SimonScreen screen;
	public SimonSays(int width, int height) {
		super(width, height);
	}
	public void initScreen() {
		screen = new SimonScreen(getWidth(),getHeight());
		setScreen(screen);

	}

	public static void main(String[] args) {
		game = new SimonSays(800,600);
		Thread app = new Thread(game);
		app.start();
	}

}
