package TigerGame;
import acm.graphics.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




public class Obstacle implements ActionListener {
	// TODO add obstacle movement. add limits of a screen
	// TODO random obstacletype when created in constructor
	
	public static final int OBSTACLE_WIDTH = 50;
	public static final int OBSTACLE_HEIGHT = 100;
	public static final int START_X = 500;
	public static final int START_Y = 240;
	//public static final int BORDER_X;
	
	private MainApplication program;
	
	private ObstacleType obstacleType;
	private double posX;
	private double posY;
	private double moveSpeed;
	private GImage obsImage;
	private Timer obsMoveTimer;
	
	
	public Obstacle(MainApplication app) {
		obsImage = new GImage("sounds/icons8-bottle-of-water-48.png");
		program = app;
		moveSpeed = 200;
		posX = START_X;
		posY = START_Y;
		program.add(obsImage);
		obsImage.setSize(OBSTACLE_WIDTH,OBSTACLE_HEIGHT);
		obsImage.move(posX, posY);
		obsMoveTimer = new Timer(500, this);
		obsMoveTimer.start();
	}

	
	public void actionPerformed(ActionEvent e) {
	}
	
	public ObstacleType getObstacleType() {
		return obstacleType;
	}
	
	public double getX() {
		return posX;
	}
	
	public double getY() {
		return posY;
	}
	
	
	
	
}
