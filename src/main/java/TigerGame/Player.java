package TigerGame;

import java.awt.event.ActionListener;

import acm.graphics.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Player implements ActionListener  {

	
	public static final int TIGER_WIDTH = 100;
	public static final int TIGER_HEIGHT = 60;
	public static final int START_X = 20;
	public static final int START_Y = 300;
	public static final int GROUND_Y = 300;
	public static final int GRAVITY = 10;
	
	private MainApplication program;
	
	private int jumpPower;
	private int gravity;
	private double posX;
	private double posY;
	private double playerScore;
	private Timer gravityTimer;
	
	GImage tigerImage;

	public Player(MainApplication app) {
		program = app;
		playerScore = 0;
		jumpPower = 150;
		gravity = 20;
		
		tigerImage = new GImage("sounds/tiger_orange.png");
		tigerImage.setSize(TIGER_WIDTH,TIGER_HEIGHT);
		tigerImage.setLocation(START_X, START_Y);
		program.add(tigerImage);
		gravityTimer = new Timer(100, this);
		gravityTimer.start();
	}
		
	public void actionPerformed(ActionEvent e) {
		land();
	}
	
	public void jump() {
		posY = posY - jumpPower;
		tigerImage.move(0, -jumpPower);
	}
	
	public void land() {
		if (tigerImage.getY() < GROUND_Y) {
			tigerImage.move(0, gravity);
		}
	}
	
	public double getPosX() {
		return tigerImage.getX();
	}

	public double getPosY() {
		return tigerImage.getY();
	}
	
	public void delete() {
		program.remove(tigerImage);
	}
	
	
}