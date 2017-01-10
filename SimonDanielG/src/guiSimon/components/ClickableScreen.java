package guiSimon.components;

import java.awt.event.MouseEvent;


import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import gui.Screen;
import gui.components.Visible;

public abstract class ClickableScreen extends Screen implements MouseListener{
	
	private ArrayList<Clickable> clickables;
	
	public ClickableScreen(int x, int y) {
		super(x,y);
	}
	
	public MouseListener getMouseListener(){
		return this;
	}
	
	public void mouseClicked(MouseEvent e) {
		for(Clickable c: clickables){
			if(c.isHovered(e.getX(), e.getY())){
				c.act();
				break;
			}
		}
		
	}
	public void addObject(Visible v){
		super.addObject(v);
		if(v instanceof Clickable){
			clickables.add((Clickable) v);
		}
	}
	public void remove(Visible v){
		super.remove(v);
		clickables.remove(v);
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public abstract void initAllObjects(List<Visible> viewObjects);
	
	public void initObjects(ArrayList<Visible> viewObjects) {
		initAllObjects(viewObjects);
		clickables = new ArrayList<Clickable>();
		for(Visible v: viewObjects){
			if(v instanceof Clickable){
				clickables.add((Clickable) v);
			}
		}
		
	}
}
