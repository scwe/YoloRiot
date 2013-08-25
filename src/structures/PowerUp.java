package structures;

import image.ImageLoader;
import image.SpriteSheet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import model.Location;
import structureAIs.NullAI;
import structureAIs.StructureAI;

public class PowerUp extends Structure {
	
	private SpriteSheet image;

	public PowerUp(Location location) {
		super(location);
	}

	@Override
	protected StructureAI makeAI() {
		return new NullAI();
	}

	@Override
	public BufferedImage getSprite() {
		ImageLoader img = new ImageLoader ();
		return img.getImage("crystal.png", 0);
	}

	@Override
	public void fire() {
	}

	@Override
	public void initialiseSpriteSheet() {
		//TODO, do something when there is a sprite of sprite sheet for this class
	}

}
