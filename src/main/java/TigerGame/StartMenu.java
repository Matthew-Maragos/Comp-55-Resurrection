package TigerGame;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import edu.pacific.comp55.starter.MainApplication;

public class StartMenu 
{
	private double ImageWidth;
	private double ImageHeight;
	
//	private SinglePlayerMode program; 
	
	
// you will use program to get access to all of the GraphicsProgram calls
	private SinglePlayerMode Single; 
	private MultiPlayerMode Multi; 

	
	
	// each button is going to be a png, click on it to perform action
	GImage background = new GImage("robot.png");
	GImage singleButton = new GImage("robot.png");
	GImage multiButton = new GImage("robot.png");
	GImage titleImage = new GImage("robot.png");
	
	
	double getImageWidth()
	{
		return ImageWidth;	
	}
	
	double getImageHeight()
	{
		return ImageHeight;	
	}
	
	void startSingleMode()
	{
		//if mouse is clicked, start single player
		
	}
	
	void startMultiMode()
	{
		
	}
	void startManual()
	{
		
	}
	
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
