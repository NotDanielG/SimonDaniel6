package guiSimon.components;

import java.awt.image.BufferedImage;

public interface Visible {
	public BufferedImage getImage();
	public int getx();
	public int gety();
	public int getWidth();
	public int getHeight();
	public boolean isAnimated();
	public void update();
}
