package TigerGame;

import acm.graphics.*;


public class Player {

	
	public static final int TIGER_WIDTH = 100;
	public static final int TIGER_HEIGHT = 60;
	public static final int START_X = 20;
	public static final int START_Y = 300;
	public static final int GROUND_Y = 300;
	
	private MainApplication program;
	
	private int jumpPower;
	private int gravity;
	private double posX;
	private double posY;
	private double playerScore;
	
	GImage tigerRunImage;
	GImage tigerJumpImage;
	GImage tigerLandImage;
	
	public Player(MainApplication app) {
		tigerRunImage = new GImage("sounds/tiger_orange.png");
		program = app;
		playerScore = 0;
		jumpPower = 30;
		gravity = 15;
		posX = START_X;
		posY = START_Y;
		program.add(tigerRunImage);
		tigerRunImage.setSize(TIGER_WIDTH,TIGER_HEIGHT);
		tigerRunImage.move(posX,posY);
	}
		
	
	public void jump(GObject playerIn) {
		posY = posY - jumpPower;
		playerIn.move(0, -jumpPower);
	}
	
	public void gravity(GObject playerIn) {
		if (posY < GROUND_Y) {
			posY = posY + gravity;
			playerIn.move(0, gravity);
		}
	}
	
	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}
	
	
}