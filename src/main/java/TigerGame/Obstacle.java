package TigerGame;
import acm.graphics.*;
import acm.program.*;
import acm.program.GraphicsProgram;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Obstacle extends GraphicsProgram {
	private ObstacleType obstacleType;
	private double posX;
	private double posY;
	private double moveSpeed;
	private GImage obstacleImage;
	private double obstacleWidth;
	private double obstacleHeight;
	private Timer t;
	
	
	public Obstacle(ObstacleType type, double posX, double posY, double moveSpeed, GImage obstacleImage) {
		
	}

	
	public void run() {
		addMouseListeners();
	}
	
	
	
	
	
	
}
