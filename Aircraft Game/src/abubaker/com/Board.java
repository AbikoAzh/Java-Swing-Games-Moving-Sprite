package abubaker.com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{

	private int craftx = 40;
	private int crafty = 100;
	private Timer timer;
	private final int delay = 10;
	private Spaceship spaceship;
	public Image we1;
	
	public Board() {
		initBoard();
	}
	
	public void initBoard(){
		
		addKeyListener(new KA());
		setBackground(Color.BLACK);
		setFocusable(true);
		setDoubleBuffered(true);
		
		spaceship = new Spaceship(craftx, crafty);
	
		ImageIcon ii = new ImageIcon("Images/we1.png");
		we1 = ii.getImage();
		
		timer = new Timer(delay,this);
		timer.start();
			
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void draw(Graphics g){
		Graphics2D gd = (Graphics2D)g;
		
		gd.drawImage(we1, 10, 10, this);
		gd.drawImage(we1, we1.getWidth(null)-70, 10, this);		
		gd.drawImage(we1, 50, 360, this);
		gd.drawImage(we1, 160, 400, this);
		gd.drawImage(we1, 460, 300, this);
		
		gd.setColor(new Color(213,113,43));
		gd.setFont(new Font("Ariel",Font.BOLD,12));
		gd.drawString("Developed By: Abubaker Azhari", 380, 15);
		
		ArrayList<Missile> missiles = spaceship.getMissiles();
		for (Missile missile : missiles){
			gd.drawImage(missile.getImage(), missile.getx(), missile.gety(), this);
		}
		
		gd.drawImage(spaceship.getImage(), spaceship.getx(), spaceship.gety(),this);
		
		gd.drawImage(we1, -50, 200, this);
		gd.drawImage(we1, -50, 200, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateMissile();
		updateSpaceship();
		
		repaint();	
	}
	
	public void updateMissile(){
		ArrayList<Missile> missiles = spaceship.getMissiles();
		
		for(int i=0; i < missiles.size(); i++){
			Missile missile =  missiles.get(i);
			if(missile.isVisible()){
				missile.move();
			}else{
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
