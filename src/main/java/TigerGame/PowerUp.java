package TigerGame;
import acm.graphics.*;


public class PowerUp {
	private PowerUpType powerType;
	//private GImage PowerImage;
	private double posX;
	private double posY;
	private int moveSpeed;
	//private Timer Timer; //this will keep track of how long it is activated 
	private double powerWidth;
	private double powerHeight;
	
	
	
	
	public PowerUp(PowerUpType type, double posX, double posY, double moveSpeed, GImage PowerImage) {
		powerType = type;
		this.posX = posX;
		this.posY = posY;
		this.setMoveSpeed((int) moveSpeed);
		//this.PowerImage = PowerImage;
		
	}
	
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
	

	public int getMoveSpeed() {
		return moveSpeed;
	}
	

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	
	//need an activate PowerUp class(or function i do not know)
	
	//move() function move to level function this will also get rid of timer probably a boolean(?) 
	// public void move() {
		 //powerMove = new PowerImage();
		//add(powerMove);
		//Timer Timer = new Timer (,this); //i do not know how long this will call to run
		//Timer.start();
	 //}
	
	
	
	//boolean checkCollided() needs posX and posY as parameters  
	

}
