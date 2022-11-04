package TigerGame;
import java.util.Timer;
import acm.graphics.*;


public class PowerUp {
	PowerUpType powerType;
	GImage PowerImage;
	double posX;
	double posY;
	int moveSpeed;
	Timer Timer; //this will keep track of how long it is activated 
	double powerWidth;
	double powerHeight;
	
	
	
	
	public PowerUpType getPowerType (PowerUpType powerType) {
		return this.powerType;
	}

	//getters and setters for posX/Y and powerHeight/Width
	
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

	public double getPowerWidth() {
		return powerWidth;
	}

	public void setPowerWidth(double powerWidth) {
		this.powerWidth = powerWidth;
	}
	
	public double getPowerHeight() {
		return powerHeight;
	}

	public void setPowerHeight(double powerHeight) {
		this.powerHeight = powerHeight;
	}
	
	
	//need an activate PowerUp class
	
	//move() function move to level function this will also get rid of timer probably a boolean(?)
	
	
	
	
	//boolean checkCollided() needs posX and posY as parameters  
	

}
