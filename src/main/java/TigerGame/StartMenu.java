package TigerGame;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import edu.pacific.comp55.starter.GraphicsApplication;
import edu.pacific.comp55.starter.MainApplication;
import edu.pacific.comp55.starter.MenuPane;
import edu.pacific.comp55.starter.SomePane;
import acm.graphics.*;
import acm.program.GraphicsProgram;		

public class StartMenu extends GraphicsProgram
{
	private double ImageWidth;
	private double ImageHeight;
	
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 400;
	
	private int count;
	
//	private SinglePlayerMode program; 
	
	
// you will use program to get access to all of the GraphicsProgram calls
	private SinglePlayerMode Single; 
	private MultiPlayerMode Multi; 

	
	
	// each button is going to be a png, click on it to perform action
	GImage background = new GImage("sounds/main_menu.png");
	//GImage singleButton = new GImage("robot.png");
	//AGImage multiButton = new GImage("robot.png");
	//GImage titleImage = new GImage("robot.png");
	
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	}
	
	public void run() {
		add(background);
		background.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		System.out.println("Hello, RAAAamis!");
		//somePane = new SomePane(this);
		//menu = new MenuPane(this);
	}
	
	
	double getImageWidth()
	{
		return ImageWidth;	
	}
	
	double getImageHeight()
	{
		return ImageHeight;	
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
	public void mousePressed(MouseEvent e) {
		
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
	}
}
