package model;
import java.awt.Graphics;

public abstract class Projectile extends EntityImpl implements Drawable, Hitboxable {
<<<<<<< HEAD
	protected Location l;
	protected Hitbox hitbox;
	
	@Override
	public Hitbox getHitbox() {
		return hitbox;
	}
=======
	Location l;
>>>>>>> 9af96710fac8db4a495ba5ec234d50de6444a40e
}