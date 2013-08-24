package projectiles;

import interactions.SimpleDamage;

import java.awt.Image;
import java.util.Set;

import model.Creep;
import model.Entity;
import model.Interaction;
import model.Location;
import model.Model;
import model.Projectile;

public class SimpleProjectile extends Projectile {

	private final Interaction attack = new SimpleDamage (10);
	
	public SimpleProjectile(Location location, Model model) {
		super(location, model);
	}

	@Override
	public void update() {
		ticks++;
		
		if (ticks == tickspeed) {
			ticks = 0;
			Set<Entity> es = model.intersects(hitbox);
			
			for (Entity e : es) {
				if (e instanceof Creep) {
					e.interact(attack);
				}
			}
			
			//model.remove(this);
		}
	}

	@Override
	public Image getSprite () {
		return null;
	}

}
