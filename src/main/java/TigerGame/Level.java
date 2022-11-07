package TigerGame;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import edu.pacific.comp55.starter.GraphicsApplication;
import edu.pacific.comp55.starter.MainApplication;

import java.awt.*;
import java.util.ArrayList;


//
//DO NOT PUSH SETTINGS, ONLY ADDED/MODIFIED
//

public class Level extends GraphicsApplication
{
//	extends GraphicsProgram 
	public static final int PROGRAM_WIDTH = 800;
	public static final int PROGRAM_HEIGHT = 600;
	GImage background = new GImage("robot head.jpg");
	GRect sky;
	
//	Timer levelTimer
	
	int gameSpeed = 100;
	
	ArrayList<GImage> Obstacles = new ArrayList<GImage>();
	ArrayList<GImage> PowerUps = new ArrayList<GImage>();
	ArrayList<GImage> BackgroundItems = new ArrayList<GImage>();
	
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
	}
	
	public void run() {
		addBackground();
	}
	
	void addBackground() {
		sky = new GRect(0, 0 , PROGRAM_WIDTH, PROGRAM_HEIGHT);
		sky.setFilled(true);
		sky.setFillColor(Color.yellow);
		add(sky);
	}
	
	void addElement() {
		
	}
	
	void addObstacle()
	{
	
//		add(background, 290, 1);

	}
	
	void addPowerUp()
	{
//		add(background, 290, 1);
	}
	
	void endGame()//(checkCollided())
	{
//		add(background, 290, 1);
	}
	
	boolean obstacleEncountered() 
	{
		
		if(true)
		{
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		new Level().start();
	}
	
}
