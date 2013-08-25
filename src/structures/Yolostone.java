package structures;

import image.ImageLoader;
import image.SpriteSheet;

import java.awt.image.BufferedImage;

import model.Location;
import structureAIs.StructureAI;

public class Yolostone extends Structure {
	private static final int YOLOSTONE_INIT_HEALTH = 1000;	
	
	public boolean destroyed = false;
	private SpriteSheet image;
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
		return image.getImage();
	}

	@Override
	protected StructureAI makeAI() {
		return null; // needs no AI.
	}

	@Override
	public void fire() { // does nothing
	}

	@Override
	public void initialiseSpriteSheet() {
		image = new SpriteSheet(0,0,64, 64, "64 yolo crystal.png");
		
	}
}
