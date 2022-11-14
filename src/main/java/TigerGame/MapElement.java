package TigerGame;

import java.util.Timer;
import acm.graphics.GImage;

public class MapElement {
		
	public static final int START_X = 320;
	public static final int START_Y = 185;
	
	private MainApplication program;
	private MapElementType mapEleType;
	private double posX;
	private double posY;
	private int moveSpeed;
	GImage elementImage;
	
	public MapElement(MainApplication app) {
	
		elementImage = new GImage("sounds/bush.png");
		program = app;
		moveSpeed = 20;
		posX = START_X;
		posY = START_Y;
		elementImage.scale(0.3);
		elementImage.setLocation(START_X, START_Y);
		program.add(elementImage);
		//elementImage.move(posX, posY);
	
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
