package TigerGame;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;

public class startMenuPane extends GraphicsPane {
	private MainApplication program;
	
	GImage background = new GImage("sounds/main_menu.png");
	GImage manualPage = new GImage("sounds/manualPage.png");
	GRect obj = new GRect(184,90,234,70);
	GRect obj2 = new GRect(184,190,234,70);
	GRect obj3 = new GRect(184,290,234,70);
	
	public startMenuPane(MainApplication app) {
		super();
		program = app;
		obj.setLineWidth(0);
		obj2.setLineWidth(0);
		obj3.setLineWidth(0);
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(obj);
		program.add(obj2);
		program.add(obj3);
	}
	
	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(obj);
		program.remove(obj2);
		program.remove(obj3);
	}
	
}
