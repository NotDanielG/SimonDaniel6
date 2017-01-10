package simonDaniel;

import java.awt.Color;


import java.util.ArrayList;
import java.util.List;

import gui.components.TextLabel;
import guiSimon.components.ButtonInterfaceDaniel;
import guiSimon.components.ColorButton;
import guiSimon.components.MoveInterfaceDaniel;
import guiSimon.components.ProgressInterfaceDaniel;
import partnerCode.Progress;
import gui.components.Button;
import gui.components.ClickableScreen;
import gui.components.Visible;
import gui.components.Action;

public class SimonScreenDaniel extends ClickableScreen implements Runnable{
	private int gameLength;
	private ArrayList<ButtonInterfaceDaniel> buttons;
	private ArrayList<MoveInterfaceDaniel> compMoves;
	private ProgressInterfaceDaniel player;
	private int[] playerStorage;
	private int[] computerStorage;
	private Color[] colorRoom;
	private static int amountClicked;
	
	public SimonScreenDaniel(int x, int y) {
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
		buttons = new ArrayList<ButtonInterfaceDaniel>();
		player = makePlayer();
		addColorButtons();
		viewObjects.add((Visible) player);
		viewObjects.add((Visible) buttons);
//		addButtons()
//		progress = getProgress();
//		label = new TextLabel(130,230,300,40,"Let's play Simon!");
//		sequence = new ArrayList<MoveInterface>();
//		//add 2 moves to start
//		lastSelectedButton = -1;
//		sequence.add(randomMove());
//		sequence.add(randomMove());
//		roundNumber = 0;
//		viewObjects.add(progress);
//		viewObjects.add(label);
	}

	private void addColorButtons() {
		int x = 20;
		int y = 200;
		for(int i = 0; i < colorRoom.length;i++){
			ButtonInterfaceDaniel button = makeButton(i, colorRoom[i]);
			buttons.add(button);
		}
	}

	private ProgressInterfaceDaniel makePlayer() {
		return new Progress(20,20,120,120);
	}
	private ButtonInterfaceDaniel makeButton(int value, Color color) {
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
