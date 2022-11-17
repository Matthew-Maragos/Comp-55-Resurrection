package TigerGame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GLabel;


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
		scoreLabel = new GLabel("Score: " + playerScore);		//Made by Vesasna
		
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
		
//		scoreLabel.setFont(new Font("Serif", Font.BOLD, 18));
		scoreLabel.setLabel("Score: " + playerScore);
		program.add(scoreLabel);
		scoreLabel.setLocation(200, 200);
		
	}
		
	public void actionPerformed(ActionEvent e) {
		land();
	}
	
	public void jump() {
		posY = posY - jumpPower;
		tigerImage.move(0, -jumpPower);

		
//		Trying to make jump smoother instead of teleport tiger to top
//		for (int i = 0; i < 20; i++) 
//		{
//			posY = posY - 200;
//			tigerImage.move(0, -i);
//			System.out.println(posY + " " + jumpPower+ " " + i);
//			posY = posY - i;		//tigers y = tigers y - jumppower(200)
//			tigerImage.move(0, -i);
//		}
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
		// check collision in x
		System.out.println("x: " + x + " , y: " + y  + " , w :" + w + ", h: " + h);
		if((tx < x && tx + tw > x && tx + tw < x + w || tx > x && tx < x + w)
		&& (ty < y && ty + th > y && ty + th < h + y || ty > y && ty < y + h)) {
			System.out.println("Player has collided");
			
			return true;
		}
		/*
			System.out.println("Player has collided in x");
			System.out.println("tx: " + tx + " , ty: " + ty + " , tw :" + tw + ", th: " + th);
			System.out.println("x: " + x + " , y: " + y  + " , w :" + w + ", h: " + h);
			return true;
			
		}
		// check collision in y
		if((ty < y && (ty + th > y) && (ty + th < (h + y)) || (ty > y && ty < y + h))) {
			System.out.println("Player has collided in y");
			System.out.println("tx: " + tx + " , ty: " + ty + " , tw :" + tw + ", th: " + th);
			System.out.println("x: " + x + " , y: " + y  + " , w :" + w + ", h: " + h);
			return true;
		}
		*/
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

	
}