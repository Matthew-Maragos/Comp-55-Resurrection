package TigerGame;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class DeathScreenPane extends GraphicsPane {
	
    private MainApplication program;
    boolean isTwoPlayer;
    
    GImage gameOver = new GImage("sounds/game-over.png");
   
    //Try Again = but 1, Main Menu = but2
    public GRect but1 = new GRect(174,92,251,54);
    public GRect but2 = new GRect(174,159,251,54);


    public DeathScreenPane(MainApplication app, boolean isTwoPlayers) {
        super();
        program = app;
        program.add(gameOver);
        but1.setLineWidth(0);
        but2.setLineWidth(0);
        isTwoPlayer = isTwoPlayers;
    }

    public void clickedAt(GObject objIn) {
        if (objIn == but1 && isTwoPlayer == false) {
            program.switchToSinglePlayer();
        }else if(objIn == but1 && isTwoPlayer == true) {
        	program.switchToMultiPlayer();
        }
        else if(objIn == but2) {
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
