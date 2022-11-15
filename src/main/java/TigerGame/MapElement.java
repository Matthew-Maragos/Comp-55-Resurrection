package TigerGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import acm.graphics.GImage;
import acm.util.RandomGenerator;
import javax.swing.*;

public class MapElement implements ActionListener {
	
	/*
	public static final int BUSH_START_X = 320;
	public static final int BUSH_START_Y = 182;
	*/
	
	private int BUSH_START_X;
 	private int BUSH_START_Y;

	private MainApplication program;
	private MapElementType mapEleType;
	private double posX;
	private double posY;
	private int moveSpeed;
	GImage elementImage;
	private Timer obsMoveTimer;
	private RandomGenerator rgen;
	
	public MapElement(MainApplication app) {

		rgen = RandomGenerator.getInstance();
		program = app;
		moveSpeed = 20;
		BUSH_START_X = 320;
    	BUSH_START_Y = 182;
		posX = BUSH_START_X;
		posY = BUSH_START_Y;
		
		elementImage = new GImage("sounds/bush_1.png");
		elementImage.scale(0.3);
		elementImage.setLocation(rgen.nextInt(100, BUSH_START_X), BUSH_START_Y);
		program.add(elementImage);
		obsMoveTimer = new Timer(100, this);
		obsMoveTimer.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		elementImage.move(-moveSpeed, 0);
		// loop the bushes if it goes out of bound
		if(elementImage.getX() + elementImage.getWidth() < 0) {
			randomizeBushImage(elementImage);
			elementImage.setLocation(BUSH_START_X + elementImage.getWidth(), BUSH_START_Y);
		}
	}
	
	// create random MapElement images
    
    public void randomizeBushImage(GImage image) {
        int randNum = rgen.nextInt(1,3);
        if(randNum == 1) {
        	image.setImage("sounds/bush_1.png");
        	BUSH_START_X = 320;
        	BUSH_START_Y = 182;
        }
        if(randNum == 2) {
        	image.setImage("sounds/bush_2.png");
        	BUSH_START_X = 320;
        	BUSH_START_Y = 182;
        }
        else {
        	image.setImage("sounds/tree.png");
        	BUSH_START_X = 600;
    		BUSH_START_Y = 120;
        }
    }
    
	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public MapElementType getMapEleType() {
		return mapEleType;
	}

	public void setMapEleType(MapElementType mapEleType) {
		this.mapEleType = mapEleType;
	}
	
	public void move(int distance) {
		elementImage.move(-distance, 0);
	}

}
