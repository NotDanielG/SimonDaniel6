package simonDaniel;

import java.awt.Color;


import java.util.ArrayList;
import java.util.List;

import gui.components.TextLabel;
import guiSimon.components.ButtonInterface;
import guiSimon.components.ColorButton;
import guiSimon.components.Player;
import guiSimon.components.PlayerInterface;
import gui.components.Button;
import gui.components.ClickableScreen;
import gui.components.Visible;
import gui.components.Action;

public class SimonScreen extends ClickableScreen implements Runnable{
	private int gameLength;
	private ArrayList<ButtonInterface> buttons;
	private PlayerInterface player;
	private int[] playerStorage;
	private int[] computerStorage;
	private Color[] colorRoom;
	private static int amountClicked;
	
	public SimonScreen(int x, int y) {
		super(x, y);
		Thread start = new Thread(this);
		start.start();
		
	}

	public void initAllObjects(List<Visible> viewObjects) {
		gameLength = 3;
		playerStorage = new int[gameLength];
		computerStorage = new int[gameLength];
		colorRoom = new Color[6];
		colorRoom[0] = Color.black;
		colorRoom[1] = Color.blue;
		colorRoom[2] = Color.green;
		colorRoom[3] = Color.yellow;
		colorRoom[4] = Color.red;
		colorRoom[5] = Color.cyan;
		buttons = new ArrayList<ButtonInterface>();
		player = makePlayer();
		addColorButtons();
		viewObjects.add((Visible) player);
		viewObjects.add((Visible) buttons);
	}

	private void addColorButtons() {
		int x = 20;
		int y = 200;
		for(int i = 0; i < colorRoom.length;i++){
			ButtonInterface button = makeButton(i, colorRoom[i]);
			buttons.add(button);
		}
	}

	private PlayerInterface makePlayer() {
		return new Player(20,20,120,120);
	}
	private ButtonInterface makeButton(int value, Color color) {
		return new ColorButton(20, 200, 50, 50, "Button 0", color, new Action(){
			public void act(){
				
			}
		}, value);
		
		
	}
	public static void setAmountClicked(){
		amountClicked++;
	}
	public void run() {
		if(amountClicked == gameLength){
			if(checkCondition()){
				gameLength++;
			}
			else{
				//Try Again;
				amountClicked = 0;
			}
		}
		
	}

	private boolean checkCondition() {
		for(int i = 0; i < computerStorage.length; i++){
			if(computerStorage[i] != playerStorage[i]){
				return false;
			}
		}
		return true;
	}

}
