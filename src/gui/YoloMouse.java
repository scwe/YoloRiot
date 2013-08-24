package gui;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;


public class YoloMouse extends MouseAdapter{
	private Model model;
	private MapPanel map;
	
    public YoloMouse(Model model, MapPanel m){
    	this.model = model;
    	this.map = m;
    	
    }

    public void mouseMoved(MouseEvent m){
    }

    public void mouseClicked(MouseEvent m){

    }

    public void mousePressed(MouseEvent m){
    	YoloRiot yolo = (YoloRiot)m.getSource();
    	
    	int diffX = map.getLocationOnScreen().x - yolo.getLocationOnScreen().x;
    	int diffY = map.getLocationOnScreen().y - yolo.getLocationOnScreen().y;
    	
    	int x = m.getX() - diffX;
    	int y = m.getY() - diffY;
    	model.shoot(x, y);
    	model.addTest(x, y);
    }

    public void mouseReleased(MouseEvent m){

    }
}