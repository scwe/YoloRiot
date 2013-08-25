package projectiles;

import image.ImageLoader;
import image.SpriteSheet;
import interactions.SimpleDamage;

import java.awt.image.BufferedImage;
import java.util.Set;

import model.Entity;
import model.Location;
import model.Model;

public class PiercingProjectile extends Projectile {

	private static final int MAX_PIERCES = 5;
	
	int numPierces = 0;
	private SpriteSheet image;
	
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
		
		return image.getImage();
	}

	@Override
	public void initialiseSpriteSheet() {
		image = new SpriteSheet(0,0, 40, 40, "FIREPOWER.png");
		
	}

}
