package TigerGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import acm.graphics.*;
import acm.util.RandomGenerator;


public class PowerUp implements ActionListener {

	private MainApplication program;
	
	public static final int POWER_WIDTH = 65;
	public static final int POWER_HEIGHT = 65;
	public static final int START_X = 600;
	public static final int START_Y = 290;
	
	private PowerUpType powerType;
	private double posX;
	private double posY;
	private int moveSpeed;
	private GImage powerImage;
	private Timer powerTimer;
	public RandomGenerator rgen;

	public PowerUp(MainApplication app) {
		rgen = RandomGenerator.getInstance();
		program = app;
		moveSpeed = 5;
		posX = START_X;
		posY = START_Y;
		//powerImage = randomizeObstacleImage();
		powerImage = new GImage("sounds/oneup.png");
		powerImage.move(posX, posY);
		program.add(powerImage);
		powerImage.setSize(POWER_WIDTH, POWER_HEIGHT);
		
		powerTimer = new Timer (15,this);
		powerTimer.start();
	}
		
	public void actionPerformed(ActionEvent e) {
		powerImage.move(-moveSpeed, 0);
	}
	
	public GImage randomizeObstacleImage() {
		int randNum = rgen.nextInt(1,3);
		if(randNum == 1) {
			return new GImage("sounds/invincibility.png");
		}
		if(randNum == 2) {
			return new GImage("sounds/oneup.png");
		}
		if(randNum == 3) {
			return new GImage("sounds/doublejump.png");
		}
		else {
			return new GImage("sounds/jeopardy.png");
		}
	}	

	// getters and setters
	
	public PowerUpType getPowerType (PowerUpType powerType) {
		return this.powerType;
	}
	
	public double getX() {
		return posX;
	}

	public double getY() {
		return posY;
	}

	public void setY(double posY) {
		this.posY = posY;
	}
	
	public void setX(double posX) {
		this.posX = posX;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}
	
	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	public void move(int moveSpeed) {
		powerImage.move(-moveSpeed, 0);
	}

}
