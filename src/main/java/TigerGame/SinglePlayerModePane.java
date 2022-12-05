package TigerGame;

import acm.graphics.*;


public class SinglePlayerModePane extends GraphicsPane {
	//TODO showContents(), hideContents()
	
	private MainApplication program;
	
	public Level LevelOne;

	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;


	public SinglePlayerModePane(MainApplication app) {
		super();
		program = app;
		LevelOne = new Level(program, false);
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