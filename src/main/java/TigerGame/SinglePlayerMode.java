package TigerGame;

import java.util.ArrayList;
import acm.graphics.*;
import acm.program.*;

public class SinglePlayerMode extends GraphicsProgram
{
	Player PlayerOne;
	Player PlayerTwo; 

	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;
	
	Level gameLevelOne;
	Level gameLevelTwo; 
//	ArrayList<GImage> Player = new ArrayList<GImage>();
	
//	Player.add("Veasna");
	
	public SinglePlayerMode() {
		this.start();
	}
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.requestFocus();

	}
	public void run() {
		GLabel label = new GLabel("Hi Hi Hi");
		add(label);
		System.out.println("Single Player Start");
		

		
	}
	
	void startGame()
	{
		
	}
	
	void endGame()
	{
		
	}
}
