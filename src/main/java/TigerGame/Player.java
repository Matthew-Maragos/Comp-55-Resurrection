package TigerGame;

import acm.graphics.*;


public class Player {
	
	private MainApplication program;
	
	private double moveSpeed;
	private double jumpPower;
	private double posX;
	private double posY;
	private double tigerWidth;
	private double tigerHeight;
	private double playerScore;
	GImage tigerRunImage;
	GImage tigerJumpImage;
	GImage tigerLandImage;
	
	public Player(MainApplication app) {
		tigerRunImage = new GImage("sounds/tiger_orange.png");
		program = app;
		program.add(tigerRunImage);
		tigerRunImage.setSize(90,70);
		tigerRunImage.move(20,300);
		jumpPower = 20;
		posX = 20;
		posY = 300;
	}
	

	
	
	public void jump(GObject playerIn) {
		posY = posY - jumpPower;
		playerIn.move(0, -20);
	}
	
	public void gravity(GObject playerIn) {
		posY = posY + 5;
		playerIn.move(0, 5);

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
	public double getTigerHeight() {
		return tigerHeight;
	}
	public void setTigerHeight(double tigerHeight) {
		this.tigerHeight = tigerHeight;
	}
	public double getTigerWidth() {
		return tigerWidth;
	}
	public void setTigerWidth(double tigerWidth) {
		this.tigerWidth = tigerWidth;
	}
	
}