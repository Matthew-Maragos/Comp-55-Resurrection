package TigerGame;

import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.*;		

public class MainApplication extends GraphicsApplication
{
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;
	
	
	private startMenuPane mainMenu;
	private int count;
	

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//this.requestFocus();
	}
	
	public void run() {
		System.out.println("StartMenu.java run() !");
		mainMenu = new startMenuPane(this);
		setupInteractions();
		switchToMainMenu();
	}
	
	public void switchToMainMenu() {
		count++;
		switchToScreen(mainMenu);
	}

	public void switchToSome() {
	}
	
	
	/*@Override
	public void mousePressed(MouseEvent e) {
		//GImage obj = StartMenu.getElementAt(e.getX(), e.getY());
		GObject ob = getElementAt(e.getX(), e.getY());
		if (ob == obj) {
			System.out.println("Testing The Single Player Button");
			Single = new SinglePlayerMode();
		}else if(ob == obj2){
			System.out.println("Testing The Multi Player Button");
		}else if(ob == obj3) {
			System.out.println("Testing The Manual Button");
			remove(background);
			add(manualPage);
		}
	
	}*/
	
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////				Under Construction			////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Might use functions or use functions through mousepressed
//	void startSingleMode()
//	{
//		
//	}
//	
//	void startMultiMode()
//	{
//		
//	}
//	void startManual()
//	{
//		
//	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////

//	@Override
//	public void mousePressed(MouseEvent e) {
		
//		GObject obj = StartMenu.getElementAt(e.getX(), e.getY());
//		if (obj == singleButton) 
//		{
//			Single.startGame();
//		}
//			
//			if (obj == multiButton) 
//			{
//				Multi.startGame();
//			}
//				
//				if (obj == manButton) 
//				{
//						//move panes to manual
//				}
//	}
}
