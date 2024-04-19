package sprite_misle;

import javax.swing.JFrame;

public class ShootingMissilesEx extends JFrame{

	public ShootingMissilesEx(){
		initUI();
	}
	
	public void initUI(){
		add(new Board());
		setSize(800,700);
		setResizable(false);
		setTitle("Shooting Missiles");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		ShootingMissilesEx sme = new ShootingMissilesEx();
		sme.setVisible(true);
	}

}
