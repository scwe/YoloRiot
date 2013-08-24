package gui;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import structures.SimpleStructure;

import map.Tile;
import model.Model;

import model.*;

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
    	
    	if(ItemPanel.currentButton == null){
    		model.shoot(x, y);
    	}else{
    		System.out.println(x/Tile.TILE_WIDTH+" "+y/Tile.TILE_HEIGHT);
        	
        	int left = (x/Tile.TILE_WIDTH)*Tile.TILE_WIDTH;
        	int top = (y/Tile.TILE_HEIGHT)*Tile.TILE_HEIGHT;
        	
    	}
    }

    public void mouseReleased(MouseEvent m){

    }
}