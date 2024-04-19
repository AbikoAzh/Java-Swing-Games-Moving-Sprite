package abubaker.com;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Spaceship extends Sprite{

	
	public int dx;
	public int dy;
	public ArrayList<Missile> missiles;
	private int count = 0;
	private boolean continueMiss;
	
	public Spaceship(int x, int y) {
		super(x, y);
		initSpaceship();
	}

	public void initSpaceship(){
		loadImage("Images/Spacedddddd.png");
		getImageDimension();
		
		missiles = new ArrayList<>();
		continueMiss = true;
	}
	
	public ArrayList<Missile> getMissiles(){
		return missiles;
	}
	
	public void move(){
		x += dx;
		y += dy;
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			fired();
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			dy = -1;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			dy = 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			dx = -1;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			dx = 1;
		}
	}
	
	public void fired(){
		count ++;
		if(count/8 == 1 || count == 0){
		missiles.add(new Missile( x + width-30, y + height /2-16));
		count -=8; 
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			dy = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			dy = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			dx = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			dx = 0;
		}
	}
}