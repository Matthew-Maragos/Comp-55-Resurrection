package TigerGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.*;

import acm.graphics.*;	

public class MainApplication extends GraphicsApplication implements ActionListener {
	//TODO is obstacle should be controller from here ? RH
	
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;
	public static final int GRAVITY_TIMER_MS = 200;
	
	public int windowWidth = 600;
	public int windowHeight = 436;
	private startMenuPane mainMenu;
	private PlayerManualPane manualMenu;
	private SinglePlayerModePane singleMenu;
	private MultiPlayerMode multiMenu;
	private DeathScreenPane gameOverMenu;
	private Level level;
	
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
			//jump function from player from level one from singlemenu
		}
		
		//37 = left, 39 = right
		if (e.getKeyCode() == 37) {		
			multiMenu.LevelTwo.player.jump();		
			//jump function from player from level one from singlemenu
		}
		
//		System.out.println(e.getKeyCode());
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