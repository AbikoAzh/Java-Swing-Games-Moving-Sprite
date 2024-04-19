package abubaker.com;

public class Missile extends Sprite{

	private final int boardWidth = 900;
	private final int missSpeed = 2;
	
	public Missile(int x, int y) {
		super(x, y);
		initMiss();
	}
	
	public void initMiss(){
		loadImage("Images/miss1.png");
		getImageDimension();
	}
	
	public void move(){
		x = x + missSpeed;
		
		if(x > boardWidth){
			visible = false;
		}
	}
}
