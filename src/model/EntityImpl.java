package model;

import java.awt.image.BufferedImage;

public abstract class EntityImpl implements Entity {	
	protected AI ai;
	protected Hitbox hitbox;
	protected Location location;
	protected BufferedImage image;
	protected BufferedImage attackingImage;
	
	protected int tickspeed = 100; // number of ticks to get before update
	protected int ticks = 0;

	protected int health;
	
	public Location getLocation () {
		return location;
	}
	
	/**
	 * +ve amount => less health afterwards. 
	 */
	public void reduceHealth (int amount) {
		health -= amount;
	}
	
	public void interact(Interaction i) {
		i.apply(this);
	}
	
	public void move (int x, int y) {
		location.x += x;
		location.y += y;
		hitbox.translate(x, y);
	}
	
	public Hitbox getHitBox(){
		return this.hitbox;
	}
	
	public abstract void update();
	public abstract BufferedImage getSprite ();
}
