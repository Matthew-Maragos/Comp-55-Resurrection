package TigerGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GLabel;

public class Player extends MainApplication implements ActionListener {

	public static final int TIGER_WIDTH = 100;
	public static final int TIGER_HEIGHT = 60;
	public static final int START_X = 20;
	public static final int START_Y = 300;
	public static final int GROUND_Y = 300;
	public static final int GRAVITY = 5;

	private MainApplication program;
	private AudioPlayer audio = AudioPlayer.getInstance();

	private int jumpPower;
	private int gravity;
	public int playerScore;
	private int secondJump;
	private int fallingSpeed;

	private GLabel scoreLabel;
	private GLabel playerLabel;
	private Timer gravityTimer;

	public boolean continueGame;
	private boolean doubleJump;
	private boolean inv;
	private boolean oneUp;
	private boolean canJump;
	private Level levelToAdd;

	GImage tigerImage;
	GImage powerImage;

	private Timer doubleJumpTimer;
	private Timer invTimer;
	private Timer oneUpTimer;

	public Player(MainApplication app, Level level) {
		continueGame = true;
		doubleJump = false;
		inv = false;
		oneUp = false;
		program = app;
		playerScore = 0;
		jumpPower = -38;
		gravity = GRAVITY;
		scoreLabel = new GLabel("Score is 0");
		levelToAdd = level;
		
		//Game Background Audio
		audio.playSound(MUSIC_FOLDER, "GMusic.mp3");
		
		if (level.isTwoPlayers() == false) {
			playerLabel = new GLabel("Player 1");
			playerLabel.setLocation(10, 50);
			tigerImage = new GImage("sounds/tiger_orange.png");
			tigerImage.setLocation(START_X, START_Y);
		} else {
			playerLabel = new GLabel("Player 2");
			playerLabel.setLocation(10, 340 + 100);
			tigerImage = new GImage("sounds/tiger_yellow.png");
			tigerImage.setLocation(START_X, 400 + START_Y);
		}
		
		program.add(playerLabel);
		playerLabel.setFont(new Font("Serif", Font.BOLD, 26));
		tigerImage.setSize(TIGER_WIDTH,TIGER_HEIGHT);
		program.add(tigerImage);
		gravityTimer = new Timer(40, this);
		gravityTimer.start();

		// adds font, sets location, and sets font/size
		// supported by Veasna
		program.add(scoreLabel);
		if (level.isTwoPlayers() == false) {
			scoreLabel.setLocation(520, 50);
		} else {
			scoreLabel.setLocation(520, 340 + 100);
		}

		scoreLabel.setFont(new Font("Serif", Font.BOLD, 36));	

		powerImage = new GImage("sounds/oneup.png");
		powerImage.setSize(30, 30);
		powerImage.setLocation(540, 70);

		doubleJumpTimer = new Timer(5000, this);
		invTimer = new Timer(5000, this);
		oneUpTimer = new Timer(1000, this);

	}

	public void actionPerformed(ActionEvent e) {
		//Gravity
		if (isOnGround()) {
			canJump = true;
		}
		else {
			canJump = false;
			fall();
		}

		//Update and Print Player Score
		playerScore++;
		scoreLabel.setLabel(" " + playerScore);
		if (playerScore % 100 == 0) {
			scoreLabel.setColor(Color.red);
		}
		else{
			scoreLabel.setColor(Color.black);
		}

		if( e.getSource() == doubleJumpTimer){
			doubleJump = false;
			doubleJumpTimer.stop();
			System.out.println("Double jump expires");
			program.remove(powerImage);
		}
		if (e.getSource()== invTimer) {
			inv = false;
			invTimer.stop();
			System.out.println("Invincibility expires");
			program.remove(powerImage);
		}
		if (e.getSource() == oneUpTimer) {
			oneUpTimer.stop();
			oneUp = false;
			program.remove(powerImage);
		}
	}


	public void jump() {
		
		//Jump Audio
		audio.playSound(MUSIC_FOLDER, "jump-arcade.mp3");
		
		
		// Normal Jump with sound effect
		if (isOnGround() && continueGame == true && doubleJump == false) 	{
			fallingSpeed = jumpPower;
			audio.playSound(MUSIC_FOLDER, "jump-arcade.mp3");
			fall();
			secondJump = 0;
			//System.out.println("SJ " + secondJump);
		}

		// DoubleJump with sound effect
		if (isOnGround() && continueGame == true && doubleJump == true) {
			fallingSpeed = jumpPower;
			audio.playSound(MUSIC_FOLDER, "jump-arcade.mp3");
			fall();
		}

		//DoubleJump when off ground
		if (!isOnGround() && continueGame == true && doubleJump == true){
			secondJump++;

			//Only work if up arrow is pressed twice, resets when ground is hit
			if (!isOnGround() && secondJump == 2){
				fallingSpeed = jumpPower / (23/10);
				audio.playSound(MUSIC_FOLDER, "jump-arcade.mp3");
				fall();
				secondJump = 0;
			}
		}
	}


	public void fall() {
		if (levelToAdd.isTwoPlayers() == false) {
			if (tigerImage.getY() + fallingSpeed <= GROUND_Y) {
				tigerImage.move(0, fallingSpeed); 
				fallingSpeed = fallingSpeed + gravity;
			}
			else {
				tigerImage.setLocation(START_X, START_Y);
			}
		} else {
			if (tigerImage.getY() + fallingSpeed <= 400 + GROUND_Y) {
				tigerImage.move(0, fallingSpeed); 
				fallingSpeed = fallingSpeed + gravity;
			}
			else {
				tigerImage.setLocation(START_X, 400 + START_Y);
			}
		}
		
	}
	
	public boolean isOnGround() {
		if (levelToAdd.isTwoPlayers() == false) {
			if (tigerImage.getY() == GROUND_Y) {
				return true;
			}
			return false;
		}else {
			if (tigerImage.getY() == 400 + GROUND_Y) {
				return true;
			}
			return false;
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

		// if invincible is collided regular calculations ignored
		if (inv == true) {
			continueGame = true;
			return false;
		}

		//if oneUp and obstacle collided, game continues and oneUp is lost (oneUp = false)
		if (oneUp == true) {
			// check collision
			if((tx < x && tx + tw > x && tx + tw < x + w || tx > x && tx < x + w)
					&& (ty < y && ty + th > y && ty + th < h + y || ty > y && ty < y + h)) {
				continueGame = true;
				oneUpTimer.start();
				//System.out.println("Player has collided with obstacle");
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

			//powerUp Audio
			audio.playSound(MUSIC_FOLDER, "PowerUp.mp3");
			
			if(powerUp.getPowerType() == PowerUpType.DOUBLEJUMP) {
				doubleJump = true;
				doubleJumpTimer.start();

				// Adding an icon of the power-up
				powerImage.setImage("sounds/doublejump.png");
				powerImage.setSize(30, 30);
				powerImage.setLocation(540, 70);	
				program.add(powerImage);
			}

			if(powerUp.getPowerType() == PowerUpType.INVINCIBILITY) {
				inv = true;
				invTimer.start();

				// Adding an icon of the power-up
				powerImage.setImage("sounds/invincibility.png");
				powerImage.setSize(30, 30);
				powerImage.setLocation(540, 70);
				program.add(powerImage);
			}

			if(powerUp.getPowerType() == PowerUpType.ONEUP) {
				oneUp = true;

				// Adding an icon of the power-up
				powerImage.setImage("sounds/oneup.png");
				powerImage.setSize(30, 30);
				powerImage.setLocation(540, 70);
				program.add(powerImage);
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