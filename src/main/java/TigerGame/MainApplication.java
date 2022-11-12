package TigerGame;

import java.awt.event.MouseEvent;
import acm.graphics.*;	

public class MainApplication extends GraphicsApplication
{
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;
	
	
	private startMenuPane mainMenu;
	private PlayerManualPane manualMenu;
	private SinglePlayerModePane singleMenu;
	
	

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//this.requestFocus();
	}
	
	public void run() {
		mainMenu = new startMenuPane(this);
		manualMenu = new PlayerManualPane(this);
		singleMenu = new SinglePlayerModePane(this);
		setupInteractions();
		switchToMainMenu();
	}
	
	public void switchToMainMenu() {
		switchToScreen(mainMenu);
	}

	public void switchToManual() {
		switchToScreen(manualMenu);
	}
	
	public void switchToSinglePlayer() {
		switchToScreen(singleMenu);
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject button = getElementAt(e.getX(), e.getY());
		if (curScreen == mainMenu) { 
			mainMenu.clickedAt(button);
		} else if (curScreen == manualMenu) {
			manualMenu.clickedAt(button);
		}
		
	}
	
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
	
	

}
