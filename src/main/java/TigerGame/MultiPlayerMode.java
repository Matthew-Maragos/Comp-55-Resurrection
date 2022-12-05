package TigerGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.GRect;
import acm.graphics.GImage;
import acm.graphics.GObject;
//
//	DO NOT PUSH SETTINGS, ONLY ADDED/MODIFIED
//

import acm.graphics.GObject;


public class MultiPlayerMode extends GraphicsPane implements ActionListener {
	//TODO showContents(), hideContents()
	
	private MainApplication program;
	
	private Timer collisionCheckTimer;
	
	public Level LevelTwo;
	public Level LevelOne;


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
			LevelOne.stopAllTimersOnce();
			LevelTwo.stopAllTimersOnce();
		}
		
	}
}
