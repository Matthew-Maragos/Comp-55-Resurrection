package TigerGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import acm.graphics.GImage;
import acm.util.RandomGenerator;
import javax.swing.*;

public class MapElement implements ActionListener {
	
	private int BUSH_START_X;
 	private int BUSH_START_Y;
 	private int CLOUD_START_X;
 	private int CLOUD_START_Y;

	private MainApplication program;
	private MapElementType mapEleType;
	private double posX;
	private double posY;
	private int moveSpeed;
	GImage elementImage;
	private Timer obsMoveTimer;
	private RandomGenerator rgen;
	private int scaleY;
	
	public MapElement(MainApplication app, MapElementType type, int startX, int scaleY) {

		rgen = RandomGenerator.getInstance();
		program = app;
		moveSpeed = 5;
		this.scaleY = scaleY;
		
		obsMoveTimer = new Timer(15, this);
		obsMoveTimer.start();
		
 		if(type == MapElementType.BUSH) {
			BUSH_START_X = startX;
	    	BUSH_START_Y = 182 + scaleY;
			posX = BUSH_START_X;
			posY = BUSH_START_Y;
			mapEleType = type;
			
			elementImage = new GImage("sounds/bush_2.png");
			elementImage.scale(0.3);
			elementImage.setLocation(startX, BUSH_START_Y);
			program.add(elementImage);
		}
		
		if(type == MapElementType.CLOUD) {
			CLOUD_START_X = startX;
	    	CLOUD_START_Y = rgen.nextInt(0, 100) + scaleY;
			posX = CLOUD_START_X;
			posY = CLOUD_START_Y;
			mapEleType = type;
			
			elementImage = new GImage("sounds/cloud.png");
			elementImage.scale(0.2);
			elementImage.setLocation(startX, CLOUD_START_Y);
			program.add(elementImage);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		elementImage.move(-moveSpeed, 0);
		// loop the bushes if it goes out of bound
		if(elementImage.getX() + elementImage.getWidth() < 0) {
			// if type is BUSH
			if(mapEleType == MapElementType.BUSH) {
				randomizeBushImage(elementImage, BUSH_START_X, scaleY);
				elementImage.setLocation(600, BUSH_START_Y);
			}
			// if type is CLOUD
			if(mapEleType == MapElementType.CLOUD) {
				elementImage.setLocation(600, rgen.nextInt(0, 100));
			}
		}
	}
	
	// create random MapElement images
    
    public void randomizeBushImage(GImage image, int startX, int scaleY) {
        int randNum = rgen.nextInt(1,3);
        if(randNum == 1) {
        	image.setImage("sounds/bush_1.png");
        	BUSH_START_Y = 182 + scaleY;
        }
        if(randNum == 2) {
        	image.setImage("sounds/bush_2.png");
        	BUSH_START_Y = 182 + scaleY;
        }
        else {
        	image.setImage("sounds/bush_3.png");
    		BUSH_START_Y = 120 + scaleY;
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
	
	public Timer getObsMoveTimer() {
		return obsMoveTimer;
	}
	
}
