package TigerGame;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;

public class startMenuPane extends GraphicsPane {
    private MainApplication program;

    GImage background = new GImage("sounds/start_menu.png");
    GImage manualPage = new GImage("sounds/manual_menu.png");
    public GRect obj = new GRect(172,136,255,53);
    public GRect obj2 = new GRect(172,209,255,53);
    public GRect obj3 = new GRect(172,282,255,53);

    public startMenuPane(MainApplication app) {
        super();
        program = app;
        obj.setLineWidth(0);
        obj2.setLineWidth(0);
        obj3.setLineWidth(0);
    }

    public void clickedAt(GObject objIn) {
        if (objIn == obj) {
            // program.SwitchtoSinglePlayer
        } else if(objIn == obj3) {
            program.switchToManual();
        }
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