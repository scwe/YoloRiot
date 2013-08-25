package projectiles;

import image.ImageLoader;
import interactions.Interaction;
import interactions.SimpleDamage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Set;

import creeps.Creep;
import model.Entity;
import model.Location;
import model.Model;

public class PiercingProjectile extends Projectile {

	private static final int MAX_PIERCES = 5;
	
	private BufferedImage image;
	int numPierces = 0;
	
	public PiercingProjectile(Location location, Location direction) {
		super (location, direction);
		attack = new SimpleDamage (10);
		tickspeed = 1;
	}
	
	@Override
	public void update() {
		ticks++;
		
		if (ticks == tickspeed) {
			ticks = 0;
			
			Set<? extends Entity> es;
			if (friendly) es = Model.model.intersectsCreeps(hitbox);
			else es = Model.model.intersectsFriendly(hitbox);
			
			unitMove(moveStep);
			
			for (Entity e : es) {
				e.interact(attack);
				numPierces ++;
				if (numPierces == MAX_PIERCES) {
					Model.model.killEntity(this);
					break;
				}
			}
		}
	}

	@Override
	public BufferedImage getSprite () {
		if(image==null){
			ImageLoader imload = new ImageLoader();
			image = imload.getImage("FIREPOWER.png");
		}
		
		return image;
	}
}
