package partnerCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Action;
import guiSimon.components.Clickable;
import guiSimon.components.TextLabel;

public class Button extends TextLabel implements Clickable{
	private Color color;
	private Action action;
	public Button(int x, int y, int w, int h, String text, Color color, Action action2) {
		super(x, y, w, h, text);
		this.color = color;
		this.action = action2;
		update();
	}
	public void update(Graphics2D g){
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 25);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 35, 25);
		g.setFont(new Font(getFont(),Font.PLAIN,getSize()));
		FontMetrics fm = g.getFontMetrics();
		
		if(getText()!= null){
			g.setColor(Color.black);
			String t = getText();
			g.drawString(t, (getWidth()-fm.stringWidth(t))/2, (getHeight()+fm.getHeight()-fm.getDescent())/2);
		}
	}
	public boolean isHovered(int x, int y) {
		if(x > getx() && x < getx()+getWidth() && y > gety() && y < gety()+getHeight()){
			return true;
		}
		return false;
	}
	public void setColor(Color c){
		this.color = c;
		update();
	}
	public void act() {
		this.action.act();
	}
//	public void update(Graphics2D g) {
//	g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//	g.setColor(color);
////	g.fillRoundRect(getx(), gety()-50, 125, 100,25,35);
////	g.drawRoundRect(getx(), gety()-50, 125, 100,25,35);
//	g.fillRoundRect(0, 0,getWidth(), getHeight(),25,35);
//	g.drawRoundRect(1,1,getWidth()-2, getHeight()-2,25,35);
//	super.update(g);
//}
}
