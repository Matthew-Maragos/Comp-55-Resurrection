package TigerGame;

import acm.graphics.GImage;

public class Player {
	private double moveSpeed;
	private double posX;
	private double posY;
	private double tigerWidth;
	private double tigerHeight;
	private double playerScore;
	GImage tigerRunImage;
	GImage tigerJumpImage;
	GImage tigerLandImage;
	
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
