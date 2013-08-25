package structures;

import image.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import structureAIs.StructureAI;
import map.Tile;
import model.Location;

public class Yolostone extends Structure {
	private static final int YOLOSTONE_INIT_HEALTH = 1000;	
	
	public boolean destroyed = false;
	private int num;
	
	public Yolostone () {
		super(new Location(0, 0));
		health = YOLOSTONE_INIT_HEALTH;
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
			double redshift = (YOLOSTONE_INIT_HEALTH * 1.0) / health;
			// TODO
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
