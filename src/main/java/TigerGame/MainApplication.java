package TigerGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.*;

import acm.graphics.*;	

public class MainApplication extends GraphicsApplication implements ActionListener
{
	//TODO is obstacle should be controller from here ? RH
	
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;
	public static final int GRAVITY_TIMER_MS = 200;
	
	private startMenuPane mainMenu;
	private PlayerManualPane manualMenu;
	private SinglePlayerModePane singleMenu;
	
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//this.requestFocus();
	}
	
	public void run() //function called when MainApplication/Whole program is ran
	{		
		mainMenu = new startMenuPane(this);		//loads main menu pane | uses startMenuPane.java function  | used in switchToManual line 38
		manualMenu = new PlayerManualPane(this);	//loads player manual pane | used in switchToManual line 38
		setupInteractions();		//allows for clicking
		switchToMainMenu();			//switches to main menu screen | reference functions below

	}
	
	public void switchToMainMenu() //Switches to main menu screen, called when player returns from PlayerManual
	{
		switchToScreen(mainMenu);
	}

	public void switchToManual() //Switches to PlayerManual	
	{
		switchToScreen(manualMenu);
	}
	
	public void switchToSinglePlayer()  //Switches to SinglePlayerGameMode
	{
		singleMenu = new SinglePlayerModePane(this);
		switchToScreen(singleMenu);
	}
	
	
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		GObject button = getElementAt(e.getX(), e.getY());		//Where the mouse cursor is when clicked
		if (curScreen == mainMenu) 
		{ 
			mainMenu.clickedAt(button);		//uses clickedAt function in startMenuPane.java line 27
		} 
		else if (curScreen == manualMenu) 
		{
			manualMenu.clickedAt(button);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 38) 	//keyCode 38 == up arrow
		{
			singleMenu.LevelOne.player.jump();		//jump function from player from level one
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 38) //keyCode 38 == up arrow
		{
			//foobar
		}
	}
	
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
	
}