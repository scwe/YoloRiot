package structures;

import image.ImageLoader;
import image.SpriteSheet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.Location;
import structureAIs.StructureAI;

public class Yolostone extends Structure {
	private static final int YOLOSTONE_INIT_HEALTH = 1000;	
	
	public boolean destroyed = false;
	private BufferedImage image;
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
	public void draw(Graphics g) {
		g.drawImage(getSprite(), location.x, location.y,  image.getWidth(), image.getHeight()+260, null);
	}
	
	@Override
	public BufferedImage getSprite() {
		return image;
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
		ImageLoader il = new ImageLoader();
		image = il.getImage("crystals.png");
		
	}
}
