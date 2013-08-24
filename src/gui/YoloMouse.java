package gui;

import java.awt.IllegalComponentStateException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import structures.SimpleStructure;

import map.Map;
import map.Tile;
import model.Model;

import model.*;

public class YoloMouse extends MouseAdapter {
	public static int mouseX = 0;
	public static int mouseY = 0;
	private Model model;
	private MapPanel map;

	public YoloMouse(Model model, MapPanel m) {

		this.model = model;
		this.map = m;

	}

	public void mouseMoved(MouseEvent m) {
		try {
			YoloRiot yolo = (YoloRiot) m.getSource();
			int diffX = map.getLocationOnScreen().x - yolo.getLocationOnScreen().x;
			int diffY = map.getLocationOnScreen().y - yolo.getLocationOnScreen().y;

			mouseX = m.getX() - diffX;
			mouseY = m.getY() - diffY;
		} catch (IllegalComponentStateException e) {

		}
	}

	public void mouseClicked(MouseEvent m) {
	}

	public void mousePressed(MouseEvent m) {
		YoloRiot yolo = (YoloRiot) m.getSource();

		int diffX = map.getLocationOnScreen().x - yolo.getLocationOnScreen().x;
		int diffY = map.getLocationOnScreen().y - yolo.getLocationOnScreen().y;
		
		
		mouseX = m.getX() - diffX;
		mouseY = m.getY() - diffY;

		if (ItemPanel.currentButton == null) {
			model.shoot(mouseX, mouseY);
		} else {

			int left = (mouseX / Tile.TILE_WIDTH) * Tile.TILE_WIDTH;
			int top = (mouseY / Tile.TILE_HEIGHT) * Tile.TILE_HEIGHT;
			
			if(left <= 0 || left > Map.MAP_HEIGHT*Tile.TILE_HEIGHT || top < 0 || top > Map.MAP_HEIGHT* Tile.TILE_HEIGHT){
				ItemPanel.currentButton = null;
				return;
			}
			
			if(ItemPanel.currentButton.equals("Button.png")){
				model.addStructure(new Location(left, top), 0);
				System.out.println("Structure added");
				System.out.println("added at left: "+left+" "+top+" mxy "+mouseX+" "+mouseY);
				ItemPanel.currentButton = null;
			}

		}
	}

	public void mouseReleased(MouseEvent m) {

	}
}