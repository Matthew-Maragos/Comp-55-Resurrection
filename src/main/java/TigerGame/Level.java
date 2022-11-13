package TigerGame;
import acm.graphics.*;


public class Level
{
	private MainApplication program;
	public Player player;
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;
	GImage backgroundImg = new GImage("sounds/game_background.png");
	
	
	public Level(MainApplication app, Player playerIn) {
		player = playerIn;
		program = app;
		program.add(backgroundImg);
		program.add(player.tigerRunImage);
	}
	
	
	public void jump(GObject playerIn) {
		player.jump(playerIn);
	}
	
	public void gravity(GObject playerIn) {
		player.gravity(playerIn);
	}
	
}