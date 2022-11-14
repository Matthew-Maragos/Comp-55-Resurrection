package TigerGame;
import acm.graphics.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	private MapElement bush1;
	private MapElement bush2;
	// O do we need bushes, clounds as separate objects at all?
	//      or should we just draw the objects on a background as it was before?
	
	GImage backgroundImg = new GImage("sounds/blank_background.png");
	
	
	public Level(MainApplication app) {
		
		program = app;
		program.add(backgroundImg);
		bush1 = new MapElement(program);
		bush2 = new MapElement(program);
		player = new Player(program);
		NewObstacleTimer = new Timer(5000, this);
		NewObstacleTimer.start();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Obstacle obstacle = new Obstacle(program);
		//obstacle.move(-20);
		//bush.move(-20);
	}
	
	public void jump(GObject playerIn) {
		player.jump();
	}
	
	public void gravity(GObject playerIn) {
		player.land();
	}
	
}