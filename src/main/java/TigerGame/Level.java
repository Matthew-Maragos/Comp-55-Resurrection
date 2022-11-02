package TigerGame;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.util.ArrayList;


//
//DO NOT PUSH SETTINGS, ONLY ADDED/MODIFIED
//

public class Level 
{
//	extends GraphicsProgram 
	GImage background = new GImage("robot.png");
	
//	Timer levelTimer
	
	int gameSpeed = 100;
	
	ArrayList<String> Obstacles = new ArrayList<String>();
	ArrayList<String> PowerUps = new ArrayList<String>();
	ArrayList<String> BackgroundItems = new ArrayList<String>();
	
	
	void addElement()
	{
//		add(background, 290, 1);	
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
}
