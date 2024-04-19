package move_sprite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{

	private Timer timer;
	private SpaceShip spaceship;
	private final int delay = 10;
	
	public Board(){
		initBoard();
	}
	
	private void initBoard(){
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		
		spaceship = new SpaceShip();
		
		timer = new Timer(delay,this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		doDrawing(g);
		
		Toolkit.getDefaultToolkit().sync();
	}

	//here we draw the spaceship, we get image and coordinates from sprite class
	private void doDrawing(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(spaceship.getimage(), spaceship.getx(), spaceship.gety(), this);
	}
	
	// this method is called every delay ms. we call step() method
	@Override
	public void actionPerformed(ActionEvent e) {
		step();		
	}
	
	// we move sprite and repaint the part that has changed. we used here some technique that repaints only
	// the small area of window that actually changed.
	private void step(){
		spaceship.move();
		
		repaint(spaceship.getx()-1,spaceship.gety()-1, spaceship.getwidth()+2, spaceship.getheight()+2);
	}
	
	
	// in this class, we listen for key events, the overridden methods of kayAdapter class delegate the
	// processing to the methods of the craft class
	
	private class TAdapter extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e){
			spaceship.keyReleased(e);
		}
		
		@Override
		public void keyPressed(KeyEvent e){
			spaceship.keyPressed(e);
		}
	}
}
