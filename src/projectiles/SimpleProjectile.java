package projectiles;

import image.ImageLoader;
import interactions.SimpleDamage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Set;

import model.Creep;
import model.Entity;
import model.Interaction;
import model.Location;
import model.Model;
import model.Projectile;

public class SimpleProjectile extends Projectile {

	private BufferedImage image;
	private final Interaction attack = new SimpleDamage (10);
	
	public SimpleProjectile(Location location, Location direction, Model model) {
		super (location, direction, model);
		setHitbox(0,0);
		tickspeed = 1;
	}
	
	@Override
	public void update() {
		ticks++;
		
		if (ticks == tickspeed) {
			ticks = 0;
			Set<Entity> es = model.intersects(hitbox);
			unitMove(30);
			
			for (Entity e : es) {
				if (e instanceof Creep) {
					e.interact(attack);
					model.killEntity(this);
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
