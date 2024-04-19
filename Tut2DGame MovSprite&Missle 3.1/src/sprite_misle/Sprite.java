package sprite_misle;

import java.awt.Image;
import javax.swing.ImageIcon;

// here we have class that shares common code from the Missile and Spaceship classes
public class Sprite {

	// this all the variable that are shared
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean visible;
	protected Image image;
	
	// initiates the x,y,visible variable
	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		visible = true;
	}
	
	protected void loadimage(String imageName){
		ImageIcon ii = new ImageIcon(imageName);
		image = ii.getImage();
	}
	
	protected void getImageDimension(){
		width= image.getWidth(null);
		height = image.getHeight(null);
	}
	
	public Image getImage(){
		return image;
	}
	
	// this to return the missile status. true move , false remove missile from list 
	public boolean isVisible(){
		return visible;
	}
	
	// WE CAN use it or we can remove it
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public int getx(){
		return x;
	}
	
	public int gety(){
		return y;
	}
}

