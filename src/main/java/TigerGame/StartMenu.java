package TigerGame;

import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.*;		

public class StartMenu extends GraphicsProgram
{
	private double ImageWidth;
	private double ImageHeight;
	
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;
	
	
// you will use program to get access to all of the GraphicsProgram calls
	private SinglePlayerMode Single; 
	private MultiPlayerMode Multi; 

	
	// each button is going to be a png, click on it to perform action
	GImage background = new GImage("sounds/main_menu.png");
	GImage manualPage = new GImage("sounds/manualPage.png");
	GRect obj = new GRect(184,90,234,70);
	GRect obj2 = new GRect(184,190,234,70);
	GRect obj3 = new GRect(184,290,234,70);
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.requestFocus();

	}
	
	public void run() {
		this.addMouseListeners();
		add(background);
		obj.setLineWidth(0);
		obj2.setLineWidth(0);
		obj3.setLineWidth(0);
		add(obj);
		add(obj2);
		add(obj3);
		System.out.println("Hello, RAMIZZIK!");
		

		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		//GImage obj = StartMenu.getElementAt(e.getX(), e.getY());
		GObject ob = getElementAt(e.getX(), e.getY());
		if (ob == obj) {
			System.out.println("Testing The Single Player Button");
		}else if(ob == obj2){
			System.out.println("Testing The Multi Player Button");
		}else if(ob == obj3) {
			System.out.println("Testing The Manual Button");
			remove(background);
			add(manualPage);
		}
	
	}
	
	
	public static void main(String[] args) {
		new StartMenu().start();
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
