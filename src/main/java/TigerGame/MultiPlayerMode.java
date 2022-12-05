package TigerGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.GLabel;
//
//	DO NOT PUSH SETTINGS, ONLY ADDED/MODIFIED
//



public class MultiPlayerMode extends GraphicsPane implements ActionListener {
	//TODO showContents(), hideContents()
	
	private MainApplication program;
	
	private Timer collisionCheckTimer;
	
	public Level LevelTwo;
	public Level LevelOne;
	GLabel winLabel;
	


	ArrayList<String> Player = new ArrayList<String>();

	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;


	public MultiPlayerMode(MainApplication app) {
		super();
		program = app;
		program.setSize(WINDOW_WIDTH, WINDOW_HEIGHT * 2);
		LevelOne = new Level(program, false);
		LevelTwo = new Level(program, true);
		
		collisionCheckTimer = new Timer(100, this);
		collisionCheckTimer.start();
	}
	
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (LevelOne.player.continueGame == false || LevelTwo.player.continueGame == false) {
			if (LevelOne.player.continueGame == false) {
				winLabel = new GLabel("Player 2 WON!");
			}else if (LevelTwo.player.continueGame == false) {
				winLabel = new GLabel("Player 1 WON!");
			}
			program.add(winLabel);
			winLabel.setFont(new Font("Serif", Font.BOLD, 26));
			winLabel.setLocation(210, 300);
			winLabel.setColor(Color.red);
			LevelOne.stopAllTimersOnce();
			LevelTwo.stopAllTimersOnce();
		}
		
	}
}
