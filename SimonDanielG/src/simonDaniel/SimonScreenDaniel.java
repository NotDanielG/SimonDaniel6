package simonDaniel;

import java.awt.Color;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import gui.components.TextLabel;
import guiSimon.components.ButtonInterfaceDaniel;
import guiSimon.components.MoveInterfaceDaniel;
import guiSimon.components.ProgressInterfaceDaniel;
import partnerCode.ColorButton;
import partnerCode.Move;
import partnerCode.Progress;
import gui.components.Button;
import gui.components.ClickableScreen;
import gui.components.Visible;
import gui.components.Action;

public class SimonScreenDaniel extends ClickableScreen implements Runnable{
	
	private int gameLength;
	private ArrayList<ButtonInterfaceDaniel> buttons;
	private ArrayList<MoveInterfaceDaniel> compMoves;
	private static int buttonX;
	private static int buttonY;
	private ProgressInterfaceDaniel player;
	private int[] playerStorage;
	private int[] computerStorage;
	private Color[] colorRoom;
	private static int amountClicked;
	private static int buttonsCreated;
	private int previousMove;
	private static ButtonInterfaceDaniel buttonS;
	private static boolean playerTurn;
	private static int playIndex;
	private static int seqIndex;
	
	public SimonScreenDaniel(int x, int y) {
		super(x, y);
		Thread start = new Thread(this);
		start.start();
		
	}

	public void initAllObjects(List<Visible> viewObjects) {
		buttonsCreated = 0;
		playIndex = 0;
		seqIndex = 0;
		previousMove = -1;
		buttonX = 20;
		buttonY = 200;
		gameLength = 3;
		playerTurn = false;
		playerStorage = new int[gameLength];
		computerStorage = new int[gameLength];
		turnNegative();
		colorRoom = new Color[6];
		colorRoom[0] = Color.pink;
		colorRoom[1] = Color.blue;
		colorRoom[2] = Color.green;
		colorRoom[3] = Color.yellow;
		colorRoom[4] = Color.red;
		colorRoom[5] = Color.orange;
		
		buttons = new ArrayList<ButtonInterfaceDaniel>();
		player = makePlayer();
		addColorButtons();
		addAllButtons(viewObjects);
		player.setGameDifficulty(3);
		player.increaseScore(0);
		viewObjects.add(player);
		
		
		
//		ButtonInterfaceDaniel button = makeButton(0, colorRoom[0]);
//		buttons.add(button);
//		viewObjects.add((Visible) buttons.get(0));
		
	}	
	public void addAllButtons(List<Visible> viewObjects){
		for(int i = 0; i < buttons.size(); i++){
			viewObjects.add(buttons.get(i));
		}
	}
	private ButtonInterfaceDaniel randomMove(){
		int rand;
		do{
			rand = (int)(Math.random()*buttons.size());
		}while (rand != previousMove);
		previousMove = rand;
		return buttons.get(rand);
	}
	private MoveInterfaceDaniel getMove(ButtonInterfaceDaniel b){
		return new Move(b);
	}
	private void addColorButtons() {
		for(int i = 0; i < colorRoom.length;i++){
			ButtonInterfaceDaniel button = makeButton(i, colorRoom[i]);
			buttons.add(button);
			
		}
	}
	private void turnNegative(){
		for(int i = 0; i < computerStorage.length; i++){
			computerStorage[i] = -1;
		}
	}
	private ProgressInterfaceDaniel makePlayer() {
		return new Progress(20,20,120,120);
	}
	private boolean IfAlreadyIn(int idx){
		for(int i = 0; i < computerStorage.length; i++){
			if(computerStorage[i] == idx){
				return true;
			}
		}
		return false;
	}
	private int getRandom(){
		return (int)(Math.random()*6);
	}
	private ButtonInterfaceDaniel makeButton(int value, Color color) {
		buttonS = new ColorButton(buttonX, buttonY, 50, 50, null, color, new Action(){
			public void act(){
				Thread buttonPress = new Thread(new Runnable() {
						public void run() {
							if(playerTurn){
								amountClicked++;
								buttons.get(value).highlight();
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								buttons.get(value).dim();
								playerStorage[amountClicked-1] = buttons.get(value).sendValue();
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								buttons.get(value).highlight();
								if(checkCondition()){
									playerTurn = !playerTurn;
									amountClicked = 0;
									gameLength++;
									playerStorage = new int[gameLength];
									computerStorage = new int[gameLength];
									seqIndex = 0;
									turnNegative();
									player.setGameDifficulty(gameLength);
									player.increaseScore(1);
									Thread compGame = new Thread(new Runnable(){
										public void run(){
											
											while(computerStorage[gameLength-1] == -1){
												int rand = getRandom();
												if(!IfAlreadyIn(rand)){
													computerStorage[seqIndex] = rand;
													seqIndex++;
													buttons.get(rand).highlight();
													try {
														Thread.sleep(1000);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													buttons.get(rand).dim();
													try {
														Thread.sleep(1000);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
													buttons.get(rand).highlight();
												}
											}
											playerTurn = !playerTurn;
										}
									});
									compGame.start();
								}
								else{
									if(buttons.get(value).sendValue() != computerStorage[amountClicked-1]){
										player.gameOver();
									}
								}
							}
						}
				});
				buttonPress.start();
			}
		}, value);
		buttonsCreated++;
		if(buttonsCreated < 3 || buttonsCreated > 3){
			buttonY+=120;
		}
		else{
			if(buttonsCreated == 3){
				buttonY-=240;
				buttonX+=200;
			}
		}
		
		return buttonS;
	}
	public void run() {
		Thread compGame = new Thread(new Runnable(){
			public void run(){
				while(computerStorage[gameLength-1] == -1){
					int rand = getRandom();
					if(!IfAlreadyIn(rand)){
						computerStorage[seqIndex] = rand;
						seqIndex++;
						buttons.get(rand).highlight();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						buttons.get(rand).dim();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						buttons.get(rand).highlight();
					}
				}
				playerTurn = !playerTurn;
			}
		});
		compGame.start();
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