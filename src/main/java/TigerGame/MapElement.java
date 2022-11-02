package TigerGame;

import java.util.Timer;
import acm.graphics.GImage;

public class MapElement {
	
	private MapElementType mapEleType;
	private double posX, posY;
	private int moveSpeed = 10;
	GImage elementImage;
	
	
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
