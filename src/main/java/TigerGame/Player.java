package TigerGame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GImage;


public class Player implements ActionListener {

	
	public static final int TIGER_WIDTH = 100;
	public static final int TIGER_HEIGHT = 60;
	public static final int START_X = 20;
	public static final int START_Y = 300;
	public static final int GROUND_Y = 300;
	public static final int GRAVITY = 15;
	
	private MainApplication program;
	
	private int jumpPower;
	private int gravity;
	private double posX;
	private double posY;
	private double playerScore;
	private Timer gravityTimer;
	private boolean continueGame;
	
	GImage tigerImage;

	public Player(MainApplication app) {
		continueGame = true;
		program = app;
		playerScore = 0;
		jumpPower = 200;
		gravity = 20;
		
		tigerImage = new GImage("sounds/tiger_orange.png");
		tigerImage.setSize(TIGER_WIDTH,TIGER_HEIGHT);
		tigerImage.setLocation(START_X, START_Y);
		program.add(tigerImage);
		gravityTimer = new Timer(100, this);
		gravityTimer.start();
		
		for (double i = 0; continueGame == false; i++) {
			i++;
			i = playerScore;
		}
//		g = new Graphics()
//		paint();
		
	}
		
	public void actionPerformed(ActionEvent e) {
		land();
	}
	
	public void jump() {
		posY = posY - jumpPower;
		tigerImage.move(0, -jumpPower);
	}
	
	public void land() {
		if (tigerImage.getY() < GROUND_Y) {
			tigerImage.move(0, gravity);
		}
	}
	
	public boolean isCollided(Obstacle obstacle) {
		double tx = tigerImage.getX();
		double ty = tigerImage.getY();
		double tw = TIGER_WIDTH;
		double th = TIGER_HEIGHT;
;		double x = obstacle.getX();
		double y = obstacle.getY(); 
		double w = obstacle.getWidth();
		double h = obstacle.getHeight();
		
		// check collision in x
		if((tx < x && (tx + tw > x) && (tx + tw < x + w)) || (tx > x && tx < x + w)) {
			return true;
		}
		// check collision in y
		if((ty < y && (ty + th > y) && (ty + th < (h + y)) || (ty > y && ty < y + h))) {
			return true;
		}
		
		return false;
		
	}
	
	public double getPosX() {
		return tigerImage.getX();
	}

	public double getPosY() {
		return tigerImage.getY();
	}
	
	public void delete() {
		program.remove(tigerImage);
	}
	
	public void paint(Graphics g) {
		
	Graphics2D g2D = (Graphics2D) g;
	g2D.drawString(Double.toString(playerScore), 300, 100);		
//	super.paint(g);
//	g.setFont(new Font("Courier New", Font.BOLD, 25));
//	g.drawString(Integer.toString(score), getWidth()/2 - 5, 100);
//	ground.create(g);
//	dino.create(g);
//	obstacles.create(g);
}
	
}