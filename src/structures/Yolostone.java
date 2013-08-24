package structures;

import image.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import structureAIs.StructureAI;
import map.Tile;
import model.Location;

public class Yolostone extends Structure {
	
	public boolean destroyed = false;
	private int num;
	
	public Yolostone (int num) {
		super(new Location(0, Tile.TILE_HEIGHT*num));
		this.num = num;
	}
	
	@Override
	public void update() {
		// no update needed, static.
	}

	@Override
	public BufferedImage getSprite() {
		if (image == null){
			ImageLoader il = new ImageLoader();
			image = il.getImage("wip yolo crystal.png");
		
		}
		return image;
	}

	@Override
	protected StructureAI makeAI() {
		return null; // needs no AI.
	}

	@Override
	public void fire() { // does nothing
	}
}
