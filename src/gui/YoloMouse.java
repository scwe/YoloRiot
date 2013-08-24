package gui;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;


public class YoloMouse extends MouseAdapter{
	Model model;
	
    public YoloMouse(Model model){
    	this.model = model;
    }

    public void mouseMoved(MouseEvent m){
    }

    public void mouseClicked(MouseEvent m){

    }

    public void mousePressed(MouseEvent m){
    	int x = m.getX();
    	int y = m.getY();
    	model.shoot(x, y);
    }

    public void mouseReleased(MouseEvent m){

    }
}