package projectiles;

import interactions.SimpleDamage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Set;

import model.Creep;
import model.Entity;
import model.Interaction;
import model.Location;
import model.Model;
import model.Projectile;

public class SimpleProjectile extends Projectile {

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
			
			unitMove(2);
			
			for (Entity e : es) {
				if (e instanceof Creep) {
					e.interact(attack);
				}
			}
			
			//model.remove(this);
		}
	}

	@Override
	public BufferedImage getSprite () {
		BufferedImage im = new BufferedImage (32, 32, BufferedImage.TYPE_INT_ARGB);
		Graphics g = im.getGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 32, 32);
		return im;
	}

}
