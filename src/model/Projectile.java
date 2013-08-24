package model;
import java.awt.Graphics;

public abstract class Projectile extends EntityImpl implements Drawable, Hitboxable {

	protected Location location;
	protected Hitbox hitbox;
	protected Model model;
	
	
	
	public Projectile (Location location, Model model) {
		this.location = location;
		this.model = model;
	}
		
	@Override
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public void setHitbox(Hitbox h){
		this.hitbox = h;
	}

	public void draw(Graphics g) {
		g.drawImage(getSprite(), location.x, location.y, null);
	}

	@Override
	public void interact(Interaction i) {
		// not needed for projectiles, as they only interact with others.
	}
	
	public abstract void update ();
}