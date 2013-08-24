package model;
import java.awt.Graphics;

public abstract class Projectile extends EntityImpl implements Drawable, Hitboxable {

	protected Location location;
	protected Location vector;
	protected double angle;
	protected double movelength = 10;
	
	protected Hitbox hitbox;
	protected Model model;
	
	public Projectile (Location location, Model model) {
		this.location = location;
		this.model = model;
	}
	
	public Projectile (Location start, Location direction, Model model) {
		location = start;
		vector = direction;
		angle = Math.atan2(vector.y - location.y, vector.x - location.x);
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
	
	/**
	 * helper function that calculates and applies unit movement ratios
	 * so we don't have to always copy out the fucking trig. 
	 */
	protected final void unitMove (int magnitude) {
		double xunit = Math.cos(angle);
		double yunit = Math.sin(angle);
		
		location.x += xunit * magnitude;
		location.y += yunit * magnitude;
	}
	
	public abstract void update ();
}