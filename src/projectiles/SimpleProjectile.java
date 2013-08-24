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

public class SimpleProjectile extends Projectile {

	private BufferedImage image;
	private final Interaction attack = new SimpleDamage (10);
	
	public SimpleProjectile(Location location, Location direction) {
		super (location, direction);
		tickspeed = 1;
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
