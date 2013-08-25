package structures;

import image.ImageLoader;
import image.SpriteSheet;

import java.awt.image.BufferedImage;

import model.Location;
import structureAIs.NullAI;
import structureAIs.StructureAI;

public class SimpleWall extends Structure {
	
	private SpriteSheet image;
	
	public SimpleWall(Location l) {
		super(l);
		this.health = 1000;
	}

	@Override
	protected StructureAI makeAI() { // no AI
		return new NullAI ();
	}

	@Override
	public BufferedImage getSprite() {
		return image.getImage();
	}

	@Override
	public void fire() {
	}

	@Override
	public void initialiseSpriteSheet() {
		image = new SpriteSheet(0,0,64, 128, "64_wall.png");
		
	}
}
