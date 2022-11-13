package TigerGame;

import acm.graphics.*;


public class SinglePlayerModePane extends GraphicsPane {
	private MainApplication program;
	
	public Player PlayerOne;
	public Level LevelOne;


	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;


	public SinglePlayerModePane(MainApplication app) {
		super();
		program = app;
		PlayerOne = new Player(program);
		LevelOne = new Level(program, PlayerOne);
	}
	
	public void jump(GObject playerIn) {
		LevelOne.jump(playerIn);
	}
	
	public void gravity(GObject playerIn) {
		LevelOne.gravity(playerIn);
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		
	}
}