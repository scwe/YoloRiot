package projectiles;

import java.awt.Image;

import model.Interaction;
import model.Location;
import model.Projectile;

public class SimpleProjectile extends Projectile {

	public SimpleProjectile(Location location) {
		super(location);
	}

	@Override
	public void interact(Interaction i) {
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public Image getSprite () {
		return null;
	}

}
