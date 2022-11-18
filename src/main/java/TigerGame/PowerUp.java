package TigerGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import acm.graphics.*;
import acm.util.RandomGenerator;


public class PowerUp implements ActionListener {

	
	
	private MainApplication program;
	
	private PowerUpType powerType;
	private GImage powerImage;
	private double posX;
	private double posY;
	private int moveSpeed;
	private int Pwr_Start_X;
	private int Pwr_Start_Y;
	private Timer pwrTimer;
	public RandomGenerator rgen;

	
	//default constructor
	public PowerUp(PowerUpType type, double posX, double posY, double moveSpeed, GImage PowerImage) {
		powerType = type;
		this.posX = posX;
		this.posY = posY;
		this.setMoveSpeed((int) moveSpeed);
		this.powerImage = PowerImage;
		
	}
	
	public PowerUpType getPowerType (PowerUpType powerType) {
		return this.powerType;
	}
	
	
	public PowerUp(MainApplication app, PowerUpType type, int startX) {
		program = app;
		moveSpeed = 5;
		pwrTimer = new Timer (15,this);
		pwrTimer.start();
		
		//four whole if statements b/c of the 4 Power Up Types
		if (type == PowerUpType.ONEUP) {
			Pwr_Start_X= startX;
			//Pwr_Start_Y =
			//not sure what value would belong here
			posX=Pwr_Start_X;
			posY=Pwr_Start_Y;
			powerType = type;
			
			powerImage = new GImage("sounds/oneupe.png");
			powerImage.scale(0.2); // will have .2 as a placeholder I don't want too much bigger then the obstacles
			powerImage.setLocation(startX, Pwr_Start_Y);
			program.add(powerImage);
		}
		if (type == PowerUpType.DOUBLEJUMP) {
			Pwr_Start_X= startX;
			//Pwr_Start_Y =
			posX=Pwr_Start_X;
			posY=Pwr_Start_Y;
			powerType = type;
			
			powerImage = new GImage("sounds/doublejump.png");
			powerImage.scale(0.2); 
			powerImage.setLocation(startX, Pwr_Start_Y);
			program.add(powerImage);
		}
		if (type == PowerUpType.INVINCIBILITY) {
			Pwr_Start_X= startX;
			//Pwr_Start_Y =
			posX=Pwr_Start_X;
			posY=Pwr_Start_Y;
			powerType = type;
			
			powerImage = new GImage("sounds/invincibility.png");
			powerImage.scale(0.2); 
			powerImage.setLocation(startX, Pwr_Start_Y);
			program.add(powerImage);
		}
		if (type == PowerUpType.JEOPARDY) {
			Pwr_Start_X= startX;
			//Pwr_Start_Y =
			posX=Pwr_Start_X;
			posY=Pwr_Start_Y;
			powerType = type;
			
			powerImage = new GImage("sounds/jeopardy.png");
			powerImage.scale(0.2); 
			powerImage.setLocation(startX, Pwr_Start_Y);
			program.add(powerImage);
		}
		
		
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

	public int getMoveSpeed() {
		return moveSpeed;
	}
	

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	//none getters and setters
	
	public void move( int distance) {
		powerImage.move(-distance, 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		powerImage.move(-moveSpeed, 0);	
	}

	public GImage randomizeObstacleImage() {
		int randNum = rgen.nextInt(1,4);
		if(randNum == 1) {
			return new GImage("sounds/invincibilty.png");
		}
		if(randNum == 2) {
			return new GImage("sounds/jeopardy.png");
		}
		if(randNum == 3) {
			return new GImage("sounds/doublejump.png");
		}
		else {
			return new GImage("sounds/oneup.png");
		}
	}
	
	
	//need an activate PowerUp class(or function i do not know)
	//need a function that will pick a random image 
	
	 
			

}
