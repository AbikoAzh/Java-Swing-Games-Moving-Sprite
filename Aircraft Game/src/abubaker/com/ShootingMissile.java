package abubaker.com;

import javax.swing.JFrame;

public class ShootingMissile extends JFrame{

	public ShootingMissile() {
		initUi();
	}
	
	public void initUi(){
		add(new Board());
		setTitle("Aircraft Game By Abubaker Azhari");
		setSize(900, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		ShootingMissile sm = new ShootingMissile();
		sm.setVisible(true);
	}

}
