package TigerGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;
import acm.graphics.GImage;
import acm.util.RandomGenerator;
import javax.swing.*;

public class MapElement implements ActionListener {
	/*
	public static final int START_X = 320;
	public static final int START_Y = 182;
	*/
	
	private int bush_startX;
	private int bush_startY;
	
	private MainApplication program;
	private MapElementType mapEleType;
	private double posX;
	private double posY;
	private int moveSpeed;
	GImage elementImage;
	private Timer obsMoveTimer;
	private RandomGenerator rgen;
	
	public MapElement(MainApplication app) {

		program = app;
		moveSpeed = 20;
		bush_startX = 320;
		bush_startY = 182;
		posX = bush_startX;
		posY = bush_startY;
		rgen = RandomGenerator.getInstance();
		
		elementImage = new GImage("sounds/bush_1.png");
		elementImage.scale(0.3);
		elementImage.setLocation(rgen.nextInt(0, bush_startX), bush_startY);
		program.add(elementImage);
		obsMoveTimer = new Timer(100, this);
		obsMoveTimer.start();
	
	}
	
	public void actionPerformed(ActionEvent e) {
		elementImage.move(-moveSpeed, 0);
		// loop the bushes if it goes out of bound
		if(elementImage.getX() + elementImage.getWidth() < 0) {
			randomizeBushImage(elementImage);
			elementImage.setLocation(bush_startX + elementImage.getWidth(), bush_startY);
		}
	}
	
	// create random MapElement images
    
    public void randomizeBushImage(GImage image) {
        int randNum = rgen.nextInt(1,3);
        if(randNum == 1) {
        	image.setImage("sounds/bush_1.png");
        	bush_startX = 320;
    		bush_startY = 182;
        }
        if(randNum == 2) {
        	image.setImage("sounds/bush_2.png");
        	bush_startX = 320;
    		bush_startY = 182;
        }
        else {
        	image.setImage("sounds/tree.png");
        	bush_startX = 400;
    		bush_startY = 120;
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
