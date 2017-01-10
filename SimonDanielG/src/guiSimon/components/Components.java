package guiSimon.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Components implements Visible{

	private int x;
	private int y;
	private int w;
	private int h;
	private BufferedImage image;
	public Components(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		update(image.createGraphics());
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getx() {
		return x;
	}

	public int gety() {
		return y;
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public boolean isAnimated() {
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void update() {
		update(image.createGraphics());
	}
	public abstract void update(Graphics2D g);
	
	public Graphics2D clear(){
		image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		return image.createGraphics();
	}
}
