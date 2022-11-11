package TigerGame;


import java.awt.event.MouseEvent;
import acm.graphics.GImage;
 
public class PlayerManualPane extends GraphicsPane {

	private MainApplication program;
	GImage manualPage = new GImage("sounds/manualPage.png");
	
	
	public PlayerManualPane(MainApplication app) {
		super();
		program = app;
		
	}
	
	@Override
	public void showContents() {
		program.add(manualPage);

	}
	
	@Override
	public void hideContents() {
		program.remove(manualPage);
	}
	
	
	
	
/*	// Adding from the Diagram, but needs more work
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	double getArrowWidth() {
		return 0;
	}
	
	double getArrowHeight() {
		return 0;
	}
*/
}
