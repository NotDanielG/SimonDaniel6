package guiSimon.components;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiSimon.components.Visible;

public abstract class Screen {
	private BufferedImage image;
	private ArrayList<Visible> viewObjects;
	
	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initObjects(viewObjects);
		initImage(width, height);
	}
	public abstract void initObjects(ArrayList<Visible> viewObjects);
	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
		
	}
	public BufferedImage getImage(){
		return image;
	}
	public int getWidth(){
		return image.getWidth();
	}
	public int getHeight(){
		return image.getHeight();
	}
	public void update() {
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0,0,image.getWidth(),image.getHeight());
		for(int i = 0; i < viewObjects.size();i++){
			Visible v = viewObjects.get(i);
			g.drawImage(v.getImage(), v.getx(), v.gety(),null);
		}
//		g.setColor(Color.black);
//		g.drawString("Hello World!",  49, 100);
//		g.drawOval(30, 70, 100, 50);
	}
	public MouseMotionListener getMouseMotionListener(){
		
		return null;
	}
	public MouseListener getMouseListener(){
		
		return null;
	}
	public void addObject(Visible v) {
		viewObjects.add(v);
		
	}
	public void remove(Visible v) {
		//In this implementation, we have a very simple command: remove(v)
		//When an object is removed from a list, every other object after that object is moved up in order
		//therefore, all of there respective indices change, you must be aware of this
		
		/**
		 * Following is an example that is wrong:
		 * suppose you have a List<Integer> with
		 * 4,8,7,1
		 * Suppose you want to remove all integers greater than 5, you do this
		 * for(int i = 0; i < list.size(); i++){
		 * 		if(list.get(i) > 5) list.remove(i);
		 * 		You fail.
		 * }
		 * i = 0, NC
		 * i = 1, 8 removed: 4,7,1
		 * i = 2, NC
		 * i = 3, Out of Loop: 4,7,1 
		 * 
		 * Correct Solutions
		 * 		while(list.get(i) > 5) list.remove(i);
		 * 		or by adding a i--;
		 *If you call list.remove(i), it will remove the object being removed at that indexS
		 *System.out.println(list.remove(0).toString() + " was removed.");
		 */
		viewObjects.remove(v);
		
	}
	public void moveToBack(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(0,v);
			
		}
	}
	public void moveToFront(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(v);
			
		}
	}

}
