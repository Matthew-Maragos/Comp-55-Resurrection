package TigerGame;
import acm.graphics.*;


public class startMenuPane extends GraphicsPane
{
	//TODO clickedAt clicked at multiplayer add. RH
	
    private MainApplication program;

    GImage background = new GImage("sounds/start_menu.png");
    GImage manualPage = new GImage("sounds/manual_menu.png");
    public GRect but1 = new GRect(172,136,255,53);
    public GRect but2 = new GRect(172,209,255,53);
    public GRect but3 = new GRect(172,282,255,53);


    public startMenuPane(MainApplication app) {
        super();
        program = app;
        but1.setLineWidth(0);
        but2.setLineWidth(0);
        but3.setLineWidth(0);
        
    }

    public void clickedAt(GObject objIn) {
        if (objIn == but1) {
            program.switchToSinglePlayer();
        } else if(objIn == but3) {
            program.switchToManual();
        } else if (objIn == but2) {
        	// program.switchToMultiPlayer();
        }
    }

    @Override
    public void showContents() {
        program.add(background);
        program.add(but1);
        program.add(but2);
        program.add(but3);
    }

    @Override
    public void hideContents() {
        program.remove(background);
        program.remove(but1);
        program.remove(but2);
        program.remove(but3);
    }

}