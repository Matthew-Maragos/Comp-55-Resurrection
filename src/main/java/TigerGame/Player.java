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
	public static final int GRAVITY = 10;
	
	private MainApplication program;
	
	private int jumpPower;
	private int gravity;
	private int playerScore;
	private GLabel scoreLabel;
	private Timer gravityTimer;
<<<<<<< HEAD
	private Timer jumpTimer;
	private boolean continueGame = false;
=======
>>>>>>> branch 'main' of https://github.com/COMP55Fall2022/final-project-group-1.git
	
	private boolean continueGame;
	private boolean doubleJump;
	//	private double posX;
	//	private double posY;
	
	GImage tigerImage;

	public Player(MainApplication app) {
		continueGame = true;
		doubleJump = false;
		
		program = app;
		playerScore = 0;
		jumpPower = 200;
		gravity = GRAVITY;
		scoreLabel = new GLabel("Score is 0");
		
		tigerImage = new GImage("sounds/tiger_orange.png");
		tigerImage.setSize(TIGER_WIDTH,TIGER_HEIGHT);
		tigerImage.setLocation(START_X, START_Y);
		program.add(tigerImage);
		gravityTimer = new Timer(40, this);
		gravityTimer.start();
		
		// adds font, sets location, and sets font/size
		// supported by Veasna
		program.add(scoreLabel);
		scoreLabel.setLocation(520, 50);
		scoreLabel.setFont(new Font("Serif", Font.BOLD, 36));	

		
	}
		
	public void actionPerformed(ActionEvent e) {
		land();			
		playerScore++;
		scoreLabel.setLabel(" " + playerScore);
		// switch between images
		
//		if (jumpTimer && e.getKeyCode() == 3) {
//		jump();
//	}
//	else {}
		}

	
	public void jump() {
<<<<<<< HEAD
//		Only allows jump when on ground
		if (tigerImage.getY() >= GROUND_Y && continueGame == true) {
			
			tigerImage.move(0, -);
=======
		
		// Only allows jump when on ground
		if (tigerImage.getY() == GROUND_Y && continueGame == true && doubleJump == false) {
			tigerImage.move(0, -jumpPower);
>>>>>>> branch 'main' of https://github.com/COMP55Fall2022/final-project-group-1.git
		}
		
<<<<<<< HEAD
//		System.out.println(continueGame);

=======
		// Allow double jumps
>>>>>>> branch 'main' of https://github.com/COMP55Fall2022/final-project-group-1.git
			
		
		
		
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
//		posY = posY - jumpPower;


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
		
		// check collision
		if((tx < x && tx + tw > x && tx + tw < x + w || tx > x && tx < x + w)
		&& (ty < y && ty + th > y && ty + th < h + y || ty > y && ty < y + h)) {
			
			System.out.println("Player has collided with obstacle");
			continueGame = false;
			return true;
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
					
			System.out.println("Player has collided with power-up");
			
			if(powerUp.getPowerType() == PowerUpType.DOUBLEJUMP) {
				doubleJump = true;
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