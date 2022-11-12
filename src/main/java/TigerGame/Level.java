package TigerGame;
import acm.graphics.*;


import java.util.ArrayList;


//
//DO NOT PUSH SETTINGS, ONLY ADDED/MODIFIED
//

public class Level
{
	private MainApplication program;
	public Player player;
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;
	GImage backgroundImg = new GImage("sounds/game_background.png");
	
	
//	Timer levelTimer
	
	int gameSpeed = 100;
	
	ArrayList<GImage> Obstacles = new ArrayList<GImage>();
	ArrayList<GImage> PowerUps = new ArrayList<GImage>();
	ArrayList<GImage> BackgroundItems = new ArrayList<GImage>();
	
	
	public Level(MainApplication app, Player playerIn) {
		player = playerIn;
		program = app;
	}
	
	
	public void jump(GObject playerIn) {
		player.jump(playerIn);
		System.out.print("Test jump in Level - Remove tiger\n");
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

	
}
