package TigerGame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GLabel;

//	#TODO Make jump action smoother


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
	private int playerScore;
	private GLabel scoreLabel;
	private Timer gravityTimer;
	private boolean continueGame;
	
	GImage tigerImage;

	public Player(MainApplication app) {
		continueGame = true;
		program = app;
		playerScore = 0;
		jumpPower = 200;
		gravity = 20;
		scoreLabel = new GLabel("Score is 0");		
		
		tigerImage = new GImage("sounds/tiger_orange.png");
		tigerImage.setSize(TIGER_WIDTH,TIGER_HEIGHT);
		tigerImage.setLocation(START_X, START_Y);
		program.add(tigerImage);
		gravityTimer = new Timer(100, this);
		gravityTimer.start();
		
		
		//adds font, sets location, and sets font/size		//Supported by Vesasna
		program.add(scoreLabel);
		scoreLabel.setLocation(520, 50);
		scoreLabel.setFont(new Font("Serif", Font.BOLD, 36));	

		
	}
		
	public void actionPerformed(ActionEvent e) {
		land();			
		playerScore++;
		scoreLabel.setLabel(" " + playerScore);
		
	}
	
	public void jump() {
//		Only allows jump when on ground
		if (tigerImage.getY() >= GROUND_Y) {
			posY = posY - jumpPower;
			tigerImage.move(0, -jumpPower);
		}
			
////		IMPLEMENT(UNCOMMENT) ONCE POWERUPS ARE DONE 
		
//////////////////////////////////////////////////////////////////////////////////
//		Only allows jump when on ground
//		if (DoubleUp == false && tigerImage.getY() == GROUND_Y) {
//			posY = posY - jumpPower;
//			tigerImage.move(0, -jumpPower);
//		}
//		
////			Powerup will allow two jumps, jump when on ground and jump on Y: 120 (Y after first jump)
//
//		if (tigerImage.getY() == 120 || tigerImage.getY() == GROUND_Y && DOUBLEUP == false) {
//			posY = posY - jumpPower;
//			tigerImage.move(0, -jumpPower);
//		}
//		System.out.println(tigerImage.getY());
//		System.out.println(GROUND_Y);
//		System.out.println(posY + " " + jumpPower+ " " + i);

	}
	
	public void land() {
		if (tigerImage.getY() < GROUND_Y) {
			tigerImage.move(0, gravity);
		}
	}
	
	public boolean isCollided(Obstacle obstacle) {
		double tx = tigerImage.getX();
		double ty = tigerImage.getY();
		double tw = tigerImage.getWidth();
		double th = tigerImage.getHeight();
;		double x = obstacle.getX();
		double y = obstacle.getY(); 
		double w = obstacle.getWidth();
		double h = obstacle.getHeight();
		// check collision in x and y
//		System.out.println("x: " + x + " , y: " + y  + " , w :" + w + ", h: " + h);
		if((tx < x && tx + tw > x && tx + tw < x + w || tx > x && tx < x + w)
		&& (ty < y && ty + th > y && ty + th < h + y || ty > y && ty < y + h)) {
			System.out.println("Player has collided");
			
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
	
	public Timer getGravityTimer() {
		return gravityTimer;
	}
	
	public void delete() {
		program.remove(tigerImage);
	}

	
}