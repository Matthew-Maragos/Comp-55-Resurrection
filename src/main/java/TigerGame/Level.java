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
	private RandomGenerator rgen;
	public Player player;
	private Timer NewObstacleTimer;
	private Timer collisionCheckTimer;
	private Timer powerUpTimer;
	
	private ArrayList<MapElement> clouds;
	private ArrayList<MapElement> bushes;
	private ArrayList<Obstacle> obstacles;
	private PowerUp currentPowerUp;
	

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
		bushes = new ArrayList<MapElement>();
		for(int i = 0; i <= 1; i++) {
			bushes.add(new MapElement(program, MapElementType.BUSH, i * 370));
		}

		// Add obstacles
		obstacles = new ArrayList<Obstacle>();

		// Add player
		player = new Player(program);
		
		// Add powerUp
		currentPowerUp = new PowerUp(program);

		// Add timer
		NewObstacleTimer = new Timer(rgen.nextInt(4000,5000), this);
		NewObstacleTimer.start();
		
		collisionCheckTimer = new Timer(100, this);
		collisionCheckTimer.start();
		
		powerUpTimer = new Timer(100, this);
		powerUpTimer.start();
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == NewObstacleTimer) {
			obstacles.add(new Obstacle(program));
			NewObstacleTimer.stop();
			NewObstacleTimer = new Timer(rgen.nextInt(1000,3000), this);
			NewObstacleTimer.start();
			System.out.println("Number of obstacles: " + obstacles.size());
		}

		for(Obstacle obstacle: obstacles) {
			if(obstacle != null) {
				if(player.isCollided(obstacle)) {
					System.out.println("Player has collided with obstacle");
					stopAllTimersOnce();
				}
				if(obstacle.getX() + obstacle.getWidth() < 0) {
					// TODO: look into removing an obstacle from the ArrayList when it goes out of bound
					// ConcurrentModidicationException
					
					obstacles.remove(obstacle);
					System.out.println("Removed. Number of obstacles: " + obstacles.size());
					break;
				}
			}
		}
		
		if(currentPowerUp != null) {
			if(player.isCollided(currentPowerUp)) {
				System.out.println("Player has collided with powerup");
				program.remove(currentPowerUp.getGImage());
				
			}
		}
		
	}

	public void stopAllTimersOnce() {
		for(Obstacle obs: obstacles) {
			obs.getObsMoveTimer().stop();
		}
		for(MapElement cloud: clouds) {
			cloud.getObsMoveTimer().stop();
		}
		for(MapElement bush: bushes) {
			bush.getObsMoveTimer().stop();
		}
		player.getGravityTimer().stop();
		NewObstacleTimer.stop();
		collisionCheckTimer.stop();	
		powerUpTimer.stop();
	}
	
	public void jump(GObject playerIn) {
		player.jump();
	}

	public void gravity(GObject playerIn) {
		player.land();
	}

}