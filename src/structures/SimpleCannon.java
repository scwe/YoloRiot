package structures;

import image.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import projectiles.SimpleProjectile;
import structureais.SimpleCannonAI;
import model.AI;
import model.Location;
import model.Model;
import model.Projectile;
import model.Structure;

public class SimpleCannon extends Structure {

	Location direction;
	
	public SimpleCannon(Location l, Model model) {
		super(l, model);
		direction = new Location(l.x + 10, l.y);
	}

	@Override
	protected AI makeAI() {
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
		Projectile p = new SimpleProjectile(location, direction, model);
		model.addProjectile (p);
	}
}
