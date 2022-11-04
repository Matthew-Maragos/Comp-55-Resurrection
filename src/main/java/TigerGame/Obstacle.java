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
	//private Timer t;
	
	
	public Obstacle(ObstacleType type, double posX, double posY, double moveSpeed, GImage obstacleImage) {
		obstacleType = type;
		this.posX = posX;
		this.posY = posY;
		this.moveSpeed = moveSpeed;
		this.obstacleImage = obstacleImage;
		
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
	
	public double getWidth() {
		return obstacleWidth;
	}
	
	public double getHeight() {
		return obstacleHeight;
	}
	
	public void move() {
		
	}
	
	public void run() {
		
	}
	
	
}
