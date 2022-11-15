package TigerGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;
import acm.graphics.GImage;
import acm.util.RandomGenerator;

import javax.swing.*;

public class MapElement implements ActionListener {
		
	public static final int START_X = 320;
	public static final int START_Y = 185;
	
	private MainApplication program;
	private MapElementType mapEleType;
	private double posX;
	private double posY;
	private int moveSpeed;
	GImage elementImage;
	private Timer obsMoveTimer;
	private RandomGenerator rgen;
	
	public MapElement(MainApplication app) {

		elementImage = new GImage("sounds/bush.png");
		program = app;
		moveSpeed = 20;
		posX = START_X;
		posY = START_Y;
		rgen = RandomGenerator.getInstance();
		
		elementImage.scale(0.3);
		elementImage.setLocation(rgen.nextInt(0, START_X), START_Y);
		program.add(elementImage);
		obsMoveTimer = new Timer(100, this);
		obsMoveTimer.start();
		//elementImage.move(posX, posY);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		elementImage.move(-moveSpeed, 0);
		// loop the bushes if it goes out of bound
		if(elementImage.getX() + elementImage.getWidth() < 0) {
			elementImage.setLocation(START_X + elementImage.getWidth(), START_Y);
		}
	}
	
	// create random MapElement images
    
    public GImage randomElementImage() {
        int randNum = rgen.nextInt(1,3);

        if(randNum == 1) {
            elementImage = new GImage("sounds/bush.png");
        }
        if(randNum == 2) {
            elementImage = new GImage("sounds/bush_2.png");
        }
        else {
            elementImage = new GImage("sounds/tree.png");
        }

        return elementImage;
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
