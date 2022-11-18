package TigerGame;
import acm.graphics.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import acm.util.RandomGenerator;
import javax.swing.*;


public class Level implements ActionListener {
	// Obstacles are created here when NewObstacleTimer raises up
	// The question is if we the Level should control the movement (like with jumping and gravity)
	// or can the movement of obstacle be performed in itself
	// array of obstacles ? move them all ?
	// TODO add general speed value which controls: gravity, jump power, obstacle move speed
	
	
	private MainApplication program;
	public Player player;
	private Timer NewObstacleTimer;
	private Timer collisionCheckTimer;
	private MapElement bush1;
	private MapElement bush2;
	private ArrayList<MapElement> clouds;
	private Obstacle currentObstacle;
	private RandomGenerator rgen;
	
	GImage backgroundImg = new GImage("sounds/blank_background.png");
	
	public Level(MainApplication app) {
		
		rgen = RandomGenerator.getInstance();
		program = app;
		program.add(backgroundImg);
		
		// Add clouds
		clouds = new ArrayList<MapElement>();
		for(int i = 0; i <= 2; i++) {
			clouds.add(new MapElement(program, MapElementType.CLOUD, i * 200));
		}
		
		// Add bushes
		bush1 = new MapElement(program, MapElementType.BUSH, 0);
		bush2 = new MapElement(program, MapElementType.BUSH, 370);
		
		// Add player
		player = new Player(program);
		NewObstacleTimer = new Timer(rgen.nextInt(4000,5000), this);
		NewObstacleTimer.start();
		collisionCheckTimer = new Timer(100, this);
		collisionCheckTimer.start();
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == NewObstacleTimer) {
			currentObstacle = new Obstacle(program);
			NewObstacleTimer.stop();
			NewObstacleTimer = new Timer(rgen.nextInt(4000,5000), this);
			NewObstacleTimer.start();
		}
		else if(currentObstacle != null && player.isCollided(currentObstacle)) {
			NewObstacleTimer.stop();
			collisionCheckTimer.stop();
			bush1.getObsMoveTimer().stop();
			bush2.getObsMoveTimer().stop();
			currentObstacle.getObsMoveTimer().stop();
			player.getGravityTimer().stop();
			for(int i = 0; i <= 2; i ++) {
				clouds.get(i).getObsMoveTimer().stop();
			}
		}
	}
	
	public void jump(GObject playerIn) {
		player.jump();
	}
	
	public void gravity(GObject playerIn) {
		player.land();
	}
	
}