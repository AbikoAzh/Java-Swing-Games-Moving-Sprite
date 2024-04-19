package sprite_misle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{

	public final int craftx = 40;
	public final int crafty = 60;
	public Timer timer;
	public final int delay = 10;
	public Spaceship spaceship;
		
	public Board() {
		initBoard();
	}
	
	public void initBoard(){
		setBackground(Color.BLACK);
		addKeyListener(new KA());
		setFocusable(true);
		setDoubleBuffered(true);
		
		spaceship = new Spaceship(craftx,crafty);
		
		timer = new Timer(delay,this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		draw(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	// here we draw the craft and all the available missiles
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		
		List<Missile> missiles = spaceship.getMissile();
		for (Missile missile : missiles){
			g2d.drawImage(missile.getImage(), missile.getx(), missile.gety(), this);
		}
			
		g2d.drawImage(spaceship.getImage(), spaceship.getx(), spaceship.gety(), this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateMissile();
		updateSpaceship();
		
		repaint();
	}
	
	// we prase all missiles from missile List, depending on what the isVisible() method return.
	public void updateMissile(){
		List<Missile> missiles = spaceship.getMissile();
		
		for (int i=0; i < missiles.size(); i++ ){
			Missile missile = missiles.get(i);
			
			if (missile.isVisible()){
				// move the missile
				missile.move();
				
			}else{
				// remove the missile from container
				missiles.remove(i);
			}
		}
	}
	
	public void updateSpaceship(){
		spaceship.move();
	}
	
	
	
	public class KA extends KeyAdapter{
	
		@Override
		public void keyPressed(KeyEvent e) {
			spaceship.keyPressed(e);					
	    }
		
		@Override
		public void keyReleased(KeyEvent e) {
			spaceship.keyReleased(e);
		}
	}
}
