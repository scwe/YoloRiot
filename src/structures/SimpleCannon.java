package structures;

import image.ImageLoader;

import java.awt.image.BufferedImage;

import model.Location;
import model.Model;
import projectiles.Projectile;
import projectiles.PiercingProjectile;
import structureAIs.SimpleCannonAI;
import structureAIs.StructureAI;

public class SimpleCannon extends Structure {

	Location direction;
	
	public SimpleCannon(Location location) {
		super(location);
		direction = new Location(location.x + 10, location.y);
	}

	@Override
	protected StructureAI makeAI() {
		return new SimpleCannonAI ();
	}

	@Override
	public BufferedImage getSprite() {
		if (image == null){
			ImageLoader il = new ImageLoader();
			image = il.getImage("Button.png");
		
		}
		return image;
	}

	@Override
	public void fire() {
		Projectile p = new PiercingProjectile(new Location(location.x, location.y), direction);
		Model.model.addProjectile (p);
	}
}
