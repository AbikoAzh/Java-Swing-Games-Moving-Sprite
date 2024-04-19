package sprite_misle;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Spaceship extends Sprite{

	private int dx;
	private int dy;
	// this to keep missile before fired, we use the class Missile as pointer to ArrayList
	private List<Missile> missiles;
	
	
	public Spaceship(int x, int y) {
		super(x,y);
		initSpaceship();
	}
	
	public void initSpaceship(){
		
		missiles = new ArrayList<>();
		
		loadimage("Images/Spacedddddd.png");
		getImageDimension();
	}
	
	public void move(){
		x += dx;
		y += dy;
	}
	
	// returns the list of missiles. it is called from the Board class.
	public List<Missile> getMissile(){
		return missiles;
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			
			fire();
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			dy = -1;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			dy = 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			dx = -1;;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			dx = 1;;
		}
	}
	
	// create new missile object and adds it to the list of missiles
	public void fire(){
		missiles.add(new Missile( x + width-30, y + height /2-16));
	}
	
	public void keyReleased(KeyEvent e){
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			dy = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			dy = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			dx = 0;;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			dx = 0;;
		}
	}
}