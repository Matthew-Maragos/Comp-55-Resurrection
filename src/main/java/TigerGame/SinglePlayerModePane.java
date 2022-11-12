package TigerGame;

import java.util.ArrayList;
import acm.graphics.*;
import acm.program.*;

public class SinglePlayerModePane extends GraphicsPane
{
	private MainApplication program;
	
	Player PlayerOne;
	Level LevelOne;

	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;
	GImage backgroundImg = new GImage("sounds/game_background.png");
	


	public SinglePlayerModePane(MainApplication app) {
		super();
		program = app;
		PlayerOne = new Player(program);
		LevelOne = new Level(program, PlayerOne);
		
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(backgroundImg);
		PlayerOne = new Player(program);
		
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.add(backgroundImg);
		
	}
}
