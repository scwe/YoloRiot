package projectiles;

import gui.SoundFactory;
import image.SpriteSheet;
import interactions.SimpleDamage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Set;

import model.Entity;
import model.Location;
import model.Model;

public class PiercingProjectile extends Projectile {

	private static final int MAX_PIERCES = 5;
	int ticker = 15;
	int numPierces = 5;
	private SpriteSheet image;
	
	public PiercingProjectile(Location location, Location direction) {
		super (location, direction);
		attack = new SimpleDamage (5);
		tickspeed = 1;
		SoundFactory.playSound("audio/phasers3.wav");
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
	public BufferedImage getSprite () {
		/*ticker++;
		double extra = Math.abs(Math.sin(ticker));
		int val = (int)(Math.random()*50);
		BufferedImage im = new BufferedImage(65+val, (int)(128*extra)+val, BufferedImage.TYPE_INT_ARGB);
		Graphics g = im.createGraphics();
		g.setColor(Color.MAGENTA);
		val = (int)(Math.random()*10);
		g.fillRect(0,0,16+val+25,(int)(128*extra)+val);
		return im;*/
		return image.getImage();
	}

	@Override
	public void initialiseSpriteSheet() {	
		image = new SpriteSheet(0,0, 40, 40, "FIREPOWER.png");
		
	}

}
