package TigerGame;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class DeathScreenPane extends GraphicsPane {
//TODO clickedAt clicked at multiplayer add. RH
	
    private MainApplication program;
    
    GImage GameOver = new GImage("sounds/start_menu.png");
    GImage But1 = new GImage("sounds/start_menu.png");
    GImage But2 = new GImage("sounds/start_menu.png");
    
    //Try Again = but 1, Main Menu = but2
    public GRect but1 = new GRect(172,136,255,53);
    public GRect but2 = new GRect(172,209,255,53);


    public DeathScreenPane(MainApplication app) {
        super();
        program = app;
        but1.setLineWidth(0);
        but2.setLineWidth(0);
        
    }

    public void clickedAt(GObject objIn) {
        if (objIn == but1) {
            program.switchToSinglePlayer();
        } else if(objIn == but2) {
            program.switchToMainMenu();
        } 
    }

    @Override
    public void showContents() {
        program.add(but1);
        program.add(but2);
    }

    @Override
    public void hideContents() {
        program.remove(but1);
        program.remove(but2);
    }

}
