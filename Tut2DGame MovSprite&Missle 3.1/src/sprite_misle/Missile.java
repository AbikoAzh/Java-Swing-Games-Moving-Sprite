package sprite_misle;

public class Missile extends Sprite{

	public final int widthBoard = 805;
	public final int missileSpeed = 2;
	
	public Missile(int x, int y) {
		super(x,y);
		initMissile();
	}
	
	public void initMissile(){
		loadimage("Images/miss1.png");
		getImageDimension();
	}
	
	// missile move at constant speed, when hits the right border, it becomes invisible, then removed from list of missile
	public void move(){
		x += missileSpeed;
		
		if(x > widthBoard){
			setVisible(false);
		}
	}
}
