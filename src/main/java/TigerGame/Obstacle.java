package TigerGame;
import acm.graphics.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




public class Obstacle implements ActionListener  {
	// TODO add obstacle movement. add limits of a screen
	// TODO random obstacletype when created in constructor
	
	public static final int OBSTACLE_WIDTH = 50;
	public static final int OBSTACLE_HEIGHT = 100;
	public static final int START_X = 500;
	public static final int START_Y = 300;
	//public static final int BORDER_X;
	
	private MainApplication program;
	
	private ObstacleType obstacleType;
	private double posX;
	private double posY;
	private double moveSpeed;
	private GImage obsImage;
	private Timer obsMoveTimer;
	public SinglePlayerModePane gameWindow;
	
	
	public Obstacle(MainApplication app) {
		obsImage = new GImage("sounds/icons8-bottle-of-water-48.png");
		program = app;
		moveSpeed = 3;
		posX = START_X;
		posY = START_Y;
		obsImage.move(posX, posY);
		program.add(obsImage);
		obsImage.setSize(OBSTACLE_WIDTH,OBSTACLE_HEIGHT);
		obsMoveTimer = new Timer(100, this);
		obsMoveTimer.start();
	}

	
	public void actionPerformed(ActionEvent e) {
		obsImage.move(-moveSpeed, 0);
		//System.out.print("test print");
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
	
	public void move(int distance) {
		obsImage.move(-distance, 0);
	}


	
	
}
