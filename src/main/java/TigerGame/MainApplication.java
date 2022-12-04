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
	
	private startMenuPane mainMenu;
	private PlayerManualPane manualMenu;
	private SinglePlayerModePane singleMenu;
	private MultiPlayerMode multiMenu;
	private DeathScreenPane dScreen;
	
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//this.requestFocus();
	}
	
	public void run() {		
		mainMenu = new startMenuPane(this);		
		//loads main menu pane | uses startMenuPane.java function  | used in switchToManual line 38
		
		manualMenu = new PlayerManualPane(this);	
		//loads player manual pane | used in switchToManual line 38
		
		setupInteractions();		
		//allows for clicking
		
		switchToMainMenu();			
		//switches to main menu screen | reference functions below

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
		dScreen = new DeathScreenPane(this);
		switchToScreen(dScreen);
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