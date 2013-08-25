package structures;

import image.ImageLoader;
import image.SpriteSheet;

import java.awt.image.BufferedImage;

import model.Location;
import model.Model;
import projectiles.PiercingProjectile;
import projectiles.Projectile;
import structureAIs.SimpleCannonAI;
import structureAIs.StructureAI;

public class SimpleCannon extends Structure {

	Location direction;
	
	private SpriteSheet image;
	
	public SimpleCannon(Location location) {
		super(location);
		health = 100;
		direction = new Location(location.x + 10, location.y);
	}

	@Override
	protected StructureAI makeAI() {
		return new SimpleCannonAI ();
		
	}

	@Override
	public BufferedImage getSprite() {
		return image.getImage();
	}

	@Override
	public void fire() {
		Projectile p = new PiercingProjectile(new Location(location.x, location.y), direction);
		Model.model.addProjectile (p);
	}

	@Override
	public void initialiseSpriteSheet() {
		image = new SpriteSheet(0,0,64,64, "64_turret.png");
		
	}
}
