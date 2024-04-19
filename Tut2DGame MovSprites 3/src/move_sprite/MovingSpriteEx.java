package move_sprite;

import javax.swing.JFrame;

public class MovingSpriteEx extends JFrame {
	
	public MovingSpriteEx() {
		initUI();
	}
	
	private void initUI(){
		add(new Board());
		
		setTitle("Moving Sprite");
		setSize(1020, 760);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MovingSpriteEx mse = new MovingSpriteEx();
		mse.setVisible(true);

	}

}
