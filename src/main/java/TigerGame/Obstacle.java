package TigerGame;
import acm.graphics.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import acm.util.RandomGenerator;


public class Obstacle implements ActionListener  {
	// TODO add obstacle movement. add limits of a screen
	// TODO random obstacletype when created in constructor
	
	public static final int OBSTACLE_WIDTH = 50;
	public static final int OBSTACLE_HEIGHT = 90;
	public static final int START_X = 600;
	public static final int START_Y = 280;
	private MainApplication program;
	
	private ObstacleType obstacleType;
	private double posX;
	private double posY;
	private double moveSpeed;
	private GImage obsImage;
	private Timer obsMoveTimer;
	public SinglePlayerModePane gameWindow;
	public RandomGenerator rgen;
	
	
	public Obstacle(MainApplication app, Level level) {
		rgen = RandomGenerator.getInstance();
		obsImage = randomizeObstacleImage();
		program = app;
		moveSpeed = 5;
		posX = START_X;
		if (level.isTwoPlayers() == false) {
			posY = START_Y;
		}else {
			posY = 320 + START_Y;
		}

		obsImage.move(posX, posY);
		program.add(obsImage);
		obsImage.setSize(OBSTACLE_WIDTH,OBSTACLE_HEIGHT);
		obsMoveTimer = new Timer(15, this);
		obsMoveTimer.start();
	}

	public void actionPerformed(ActionEvent e) {
		obsImage.move(-moveSpeed, 0);
	}
	
	public GImage randomizeObstacleImage() {
		int randNum = rgen.nextInt(1,4);
		if(randNum == 1) {
			return new GImage("sounds/trashcan.png");
		}
		if(randNum == 2) {
			
			return new GImage("sounds/acorn.png");
		}
		if(randNum == 3) {
			return new GImage("sounds/bench.png");
		}
		else {
			//GImage temp = new GImage("sounds/rock.png");
			//temp.setSize(100,100);
			return new GImage("sounds/rock.png");
		}
		
	}
	
	public ObstacleType getObstacleType() {
		return obstacleType;
	}
	
	public double getX() {
		return obsImage.getX();
	}
	
	public double getY() {
		return obsImage.getY();
	}
	
	public double getWidth() {
		return obsImage.getWidth();
	}
	
	public double getHeight() {
		return obsImage.getHeight();
	}
	
	public void move(int distance) {
		obsImage.move(-distance, 0);
	}
	
	public Timer getObsMoveTimer() {
		return obsMoveTimer;
	}
	
}
