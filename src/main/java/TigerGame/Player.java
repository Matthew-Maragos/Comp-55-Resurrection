package TigerGame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GLabel;

//	#TODO Make jump action smoother

//	#TODO Program forces one powerup to always be true, double jump 
// 	was always true until oneUp was added, now oneUp is always true
//	should only be true if collected by player, fix later

//	#TODO Remove Image of power up (line 94)

public class Player implements ActionListener {

	public static final int TIGER_WIDTH = 100;
	public static final int TIGER_HEIGHT = 60;
	public static final int START_X = 20;
	public static final int START_Y = 300;
	public static final int GROUND_Y = 300;
	public static final int GRAVITY = 10;
	
	private MainApplication program;
	
	private int jumpPower;
	private int gravity;
	private int playerScore;
	private int secondJump;
	
	private GLabel scoreLabel;
	private Timer gravityTimer;
	
	private boolean continueGame;
	private boolean doubleJump;
	private boolean inv;
	private boolean oneUp;
	
	GImage tigerImage;
	GImage powerImage;
	
	private Timer doubleJumpTimer;
	private Timer invTimer;
	private Timer jpTimer;

	public Player(MainApplication app) {
		continueGame = true;
		doubleJump = false;
		inv = false;
		oneUp = false;
		
		program = app;
		playerScore = 0;
		jumpPower = 200;
		gravity = GRAVITY;
		scoreLabel = new GLabel("Score is 0");
		
		tigerImage = new GImage("sounds/tiger_orange.png");
		tigerImage.setSize(TIGER_WIDTH,TIGER_HEIGHT);
		tigerImage.setLocation(START_X, START_Y);
		program.add(tigerImage);
		gravityTimer = new Timer(50, this);
		gravityTimer.start();
		
		// adds font, sets location, and sets font/size
		// supported by Veasna
		program.add(scoreLabel);
		scoreLabel.setLocation(520, 50);
		scoreLabel.setFont(new Font("Serif", Font.BOLD, 36));	

		doubleJumpTimer = new Timer(1000, this);
		invTimer = new Timer(5000, this);
		jpTimer = new Timer(5000, this);
		

		
	}
		
	public void actionPerformed(ActionEvent e) {
		//Gravity
		land();			
		
		//Update and Print Player Score
		playerScore++;
		scoreLabel.setLabel(" " + playerScore);
		
		//resets secondJump counter once player hits ground
		if (tigerImage.getY() == GROUND_Y && secondJump > 2){
			secondJump = 0;
		}
		
		//Displays image when powerup is collected
		if (oneUp == true){
			powerImage = new GImage("sounds/oneup.png");
			program.add(powerImage);
			powerImage.setSize(30, 30);
			powerImage.setLocation(540, 70);
		}
		else if (inv == true){
			powerImage = new GImage("sounds/invincibility.png");
			program.add(powerImage);
			powerImage.setSize(30, 30);
			powerImage.setLocation(540, 70);
		}
		else if (doubleJump == true){
			powerImage = new GImage("sounds/doublejump.png");
			program.add(powerImage);
			powerImage.setSize(30, 30);
			powerImage.setLocation(540, 70);
		}
		if( e.getSource() == doubleJumpTimer){
			program.remove(powerImage);
			doubleJumpTimer.stop();
			doubleJump = false;
		}
		else if (e.getSource()== invTimer) {
			program.remove(powerImage);
			invTimer.stop();
			inv = false;
		}

		
//		System.out.println("o" + oneUp);
//		System.out.println(doubleJump);

	}

	
	public void jump() {
		// Normal Jump
		if (tigerImage.getY() == GROUND_Y && continueGame == true && doubleJump == false) 	{
			tigerImage.move(0, -jumpPower);
			secondJump = 0;
			System.out.println("SJ " + secondJump);
		}
		
		// DoubleJump
		if (tigerImage.getY() == GROUND_Y && continueGame == true && doubleJump == true) {
			tigerImage.move(0, -jumpPower);
		}
		
		//DoubleJump when off ground
		if (tigerImage.getY() < GROUND_Y && continueGame == true && doubleJump == true){
				secondJump++;
				
				//Only work if up arrow is pressed twice, resets when ground is hit
				if (tigerImage.getY() < GROUND_Y && secondJump == 2){
					tigerImage.move(0, -jumpPower);
					secondJump = 3;
				}
		}
		
	}
	
	
	public void land() {
		if (tigerImage.getY() < GROUND_Y) {
			tigerImage.move(0, gravity);
		}
	}
	
	// Check collision between player and obstacle
	public boolean isCollided(Obstacle obstacle) {
		
		// +10 & -10 to make the obstacle hit box smaller for precision
		double tx = tigerImage.getX() + 10;
		double ty = tigerImage.getY() + 10;
		double tw = tigerImage.getWidth() - 10;
		double th = tigerImage.getHeight() - 10;
		double x = obstacle.getX() + 10;
		double y = obstacle.getY() + 10; 
		double w = obstacle.getWidth() - 10;
		double h = obstacle.getHeight() - 10;
		
		
		//if invincible is collided regular calculations ignored
		if (inv == true) {
			continueGame = true;
			return false;
		}
		
		//if oneUp and obstacle collided, game continues and oneUp is lost (oneUp = false)
//		#TODO add a oneUp 'function for program.remove(powerImage);' to be used 
		if (oneUp == true) {
			// check collision
			if((tx < x && tx + tw > x && tx + tw < x + w || tx > x && tx < x + w)
			&& (ty < y && ty + th > y && ty + th < h + y || ty > y && ty < y + h)) {
				continueGame = true;
				oneUp = false;
				return false;
			}
		}
		
		//else acts like normal function
		else {
			// check collision
			if((tx < x && tx + tw > x && tx + tw < x + w || tx > x && tx < x + w)
			&& (ty < y && ty + th > y && ty + th < h + y || ty > y && ty < y + h)) {
				continueGame = false;
				return true;
				//print gmage
				
			}
		}
		
		return false;
	}
	
	// Check collision between player and power up
	public boolean isCollided(PowerUp powerUp) {
		
		double tx = tigerImage.getX();
		double ty = tigerImage.getY();
		double tw = tigerImage.getWidth();
		double th = tigerImage.getHeight();
		double x = powerUp.getX();
		double y = powerUp.getY(); 
		double w = powerUp.getWidth();
		double h = powerUp.getHeight();
		
		// check collision
		if((tx < x && tx + tw > x && tx + tw < x + w || tx > x && tx < x + w)
		&& (ty < y && ty + th > y && ty + th < h + y || ty > y && ty < y + h)) {
					
			//// when player gets powerup, double jump 				////
			//// is set to true despite invincibility being there	////
			//// need to fix later run program to learn more		////
			if(powerUp.getPowerType() == PowerUpType.DOUBLEJUMP) {
				doubleJump = true;
				doubleJumpTimer.start();
			}
			
			if(powerUp.getPowerType() == PowerUpType.INVINCIBILITY) {
				inv = true;
				invTimer.start();
			}
			
			if(powerUp.getPowerType() == PowerUpType.ONEUP) {
				oneUp = true;
			}
			
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