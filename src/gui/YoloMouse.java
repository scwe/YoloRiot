package gui;

import java.awt.IllegalComponentStateException;
import java.awt.event.*;

import map.Map;
import map.Tile;
import model.Location;
import model.Model;
import model.Pt;

public class YoloMouse extends MouseAdapter {
	public static int mouseX = 0;
	public static int mouseY = 0;
	public static int offsetX;
	public static int offsetY;
	private Model model;
	private MapPanel map;

	public YoloMouse(Model model, MapPanel m) {

		this.model = model;
		this.map = m;

	}

	public void mouseMoved(MouseEvent m) {
		try {
			YoloRiot yolo = (YoloRiot) m.getSource();
			offsetX = map.getLocationOnScreen().x - yolo.getLocationOnScreen().x;
			offsetY = map.getLocationOnScreen().y - yolo.getLocationOnScreen().y;

			mouseX = m.getX() - offsetX;
			mouseY = m.getY() - offsetY;
		} catch (IllegalComponentStateException e) {
			
		}
	}
	
	public void mouseDragged (MouseEvent m) {
		mouseMoved(m);	
	}
	
	public void mouseWheelMoved (MouseWheelEvent e) {
		int clicks = e.getWheelRotation();
		Model.model.player.changeAbility(clicks);
	}

	public void mouseClicked(MouseEvent m) {
	}

	// FIXME cursor is effectively in the top-left.
	public void mousePressed(MouseEvent m) {
		YoloRiot yolo = (YoloRiot) m.getSource();
		
		int diffX = map.getLocationOnScreen().x - yolo.getLocationOnScreen().x;
		int diffY = map.getLocationOnScreen().y - yolo.getLocationOnScreen().y;

		mouseX = m.getX() - diffX;
		mouseY = m.getY() - diffY;

		if (ItemPanel.currentButton == null) {
			model.mousePressed(true);
		} else {
			model.mousePressed(false);
			int left = (mouseX / Tile.TILE_WIDTH) * Tile.TILE_WIDTH;
			int top = (mouseY / Tile.TILE_HEIGHT) * Tile.TILE_HEIGHT;
			
			if(left <= 0 || left > Map.MAP_HEIGHT*Tile.TILE_HEIGHT || top < 0 || top > Map.MAP_HEIGHT* Tile.TILE_HEIGHT){
				ItemPanel.currentButton = null;
				return;
			}
			
			if(ItemPanel.currentButton.equals("Button.png")){
				model.addStructure(new Location(left, top), 0);
				ItemPanel.currentButton = null;
			}

		}
	}

	public void mouseReleased(MouseEvent m) {
		model.mousePressed(false);
	}
}
