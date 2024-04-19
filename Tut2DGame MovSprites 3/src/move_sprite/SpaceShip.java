package move_sprite;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class SpaceShip {

	private int dx;
	private int dy;
	private int x = 40;
	private int y = 60;
	private int w;
	private int h;
	private Image Spaceship;
	
	public SpaceShip() {
		loadImage();
	}
	
	private void loadImage(){
		ImageIcon ii = new ImageIcon("ImageS/Spaceship.png");
		Spaceship = ii.getImage();
		
		w = Spaceship.getWidth(null);
		h = Spaceship.getHeight(null);
	}
	
	// changes the coordinates of the sprite, x/y values used in paintComponent() method
	public void move(){
		x +=dx;
		y +=dy;
	}
	
	public int getx(){
		return x;
	}
	
	public int gety(){
		return y;
	}
	
	public int getwidth(){
		return w;
	}
	
	public int getheight(){
		return h;
	}
	
	public Image getimage(){
		return Spaceship;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT){
			dx = -2;
		}
		if(key == KeyEvent.VK_RIGHT){
			dx = 2;
		}
		if(key == KeyEvent.VK_UP){
			dy = -2;
		}
		if(key == KeyEvent.VK_DOWN){
			dy = 2;
		}	
	}
	
	// here we need to stop spacecraft from moving when release the key 
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT){
			dx = 0;
		}
		if(key == KeyEvent.VK_RIGHT){
			dx = 0;
		}
		if(key == KeyEvent.VK_UP){
			dy = 0;
		}
		if(key == KeyEvent.VK_DOWN){
			dy = 0;
		}	
	}
}
