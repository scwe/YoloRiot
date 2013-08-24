package model;
import java.awt.Graphics;

public abstract class Projectile extends EntityImpl implements Drawable, Hitboxable {

	protected Location l;
	protected Hitbox hitbox;
	
	@Override
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public void setHitbox(Hitbox h){
		this.hitbox = h;
	}
}