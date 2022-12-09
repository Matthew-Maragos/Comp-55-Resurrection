package TigerGame;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GLabel;

public class DeathScreenPane extends GraphicsPane {
	
    private MainApplication program;
    boolean isTwoPlayer;
    
    private AudioPlayer audio = AudioPlayer.getInstance();
    public static final String MUSIC_FOLDER = "sounds";	
    
    GImage gameOver = new GImage("sounds/game-over.png");
   
    //Try Again = but 1, Main Menu = but2
    public GRect but1 = new GRect(174,92,251,54);
    public GRect but2 = new GRect(174,159,251,54);
    
    public boolean minimizeScreen;


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
        	minimizeScreen = true;
        	audio.stopSound(MUSIC_FOLDER, "GMusic.mp3");
            program.switchToSinglePlayer();
            program.setSize(MainApplication.WINDOW_WIDTH, MainApplication.WINDOW_HEIGHT);
        }
        else if(objIn == but1 && isTwoPlayer == true) {
        	minimizeScreen = false;
        	audio.stopSound(MUSIC_FOLDER, "GMusic.mp3");
        	program.switchToMultiPlayer();
        }
        else if(objIn == but2) {
        	minimizeScreen = true;
        	audio.stopSound(MUSIC_FOLDER, "GMusic.mp3");
        	program.removeAll();
            program.switchToMainMenu();
            program.setSize(MainApplication.WINDOW_WIDTH, MainApplication.WINDOW_HEIGHT);
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
