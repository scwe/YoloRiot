
package projectiles;

import gui.SoundFactory;
import image.SpriteSheet;
import interactions.SimpleDamage;

import java.awt.image.BufferedImage;

import model.Location;

public class WeakProjectile extends Projectile {

	private SpriteSheet image;
	
	
	public WeakProjectile(Location location, Location direction) {
		super (location, direction);
		attack = new SimpleDamage (2);
		tickspeed = 1;
		
		SoundFactory.playSound("audio/phasers3.wav");

	}

	@Override
	public BufferedImage getSprite () {
		
		return image.getImage();
	}

	@Override
	public void initialiseSpriteSheet() {
		image = new SpriteSheet(0,0, 40,40, "FIREPOWER.png");
		
	}
}
