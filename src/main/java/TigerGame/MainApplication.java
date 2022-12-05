package TigerGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.*;

import acm.graphics.*;

public class MainApplication extends GraphicsApplication implements ActionListener {
	// TODO fix the sound problem. Add other sounds to the game
	
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;
	public static final int GRAVITY_TIMER_MS = 200;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3", "jump.mp3" };

	
	public int windowWidth = 600;
	public int windowHeight = 436;
	private startMenuPane mainMenu;
	private PlayerManualPane manualMenu;
	private SinglePlayerModePane singleMenu;
	private MultiPlayerMode multiMenu;
	private DeathScreenPane gameOverMenu;
	private Level level;
	private AudioPlayer audio = AudioPlayer.getInstance();
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//this.requestFocus();
	}
	
	public void run() {
		//loads main menu pane
		mainMenu = new startMenuPane(this);		
		
		//loads player manual pane
		manualMenu = new PlayerManualPane(this);
		
		//loads game over menu
		gameOverMenu = new DeathScreenPane(this);
		
		
		setupInteractions();		
		
		// initially loads to main menu
		switchToMainMenu();			
	}
	
	public void switchToMainMenu() {
		switchToScreen(mainMenu);
	}

	public void switchToManual() {
		switchToScreen(manualMenu);
	}
	
	public void switchToSinglePlayer() {
		singleMenu = new SinglePlayerModePane(this);
		switchToScreen(singleMenu);
	}
	
	public void switchToMultiPlayer() {
		multiMenu = new MultiPlayerMode(this);
		switchToScreen(multiMenu);
	}
	
	public void switchToDeathScreenPane() {
		gameOverMenu = new DeathScreenPane(this);
		switchToScreen(gameOverMenu);
	}
	
	private void playRandomSound() {
		
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[2]);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject button = getElementAt(e.getX(), e.getY());		
		//Where the mouse cursor is when clicked
		
		if (curScreen == mainMenu) { 
			mainMenu.clickedAt(button);		
			//uses clickedAt function in startMenuPane.java line 27
		} 
		
		else if (curScreen == manualMenu) {
			manualMenu.clickedAt(button);
		}
		
		if (curScreen == gameOverMenu) { 
			gameOverMenu.clickedAt(button);	
			//uses clickedAt function in startMenuPane.java line 27
		} 
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 38) {		
			singleMenu.LevelOne.player.jump();
			playRandomSound();
			//jump function from player from level one from singlemenu
		}
		
		//keycode 87: W
		if (e.getKeyCode() == 87) {		
			multiMenu.LevelTwo.player.jump();
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//keyCode 38 == up arrow
		if (e.getKeyCode() == 38) { 
		
		}
	}
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
	
}