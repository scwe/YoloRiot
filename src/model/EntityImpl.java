package model;

import interactions.Interaction;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import map.Tile;

public abstract class EntityImpl implements Entity {	
	protected Hitbox hitbox;
	protected Location location;
	
	protected BufferedImage image;
	protected BufferedImage attackingImage;
	
	protected int tickspeed = 100; // number of ticks to get before update
	protected int ticks = 0;

	protected int health;
	
	public abstract void update();
	protected abstract Hitbox makeHitbox();
	public abstract BufferedImage getSprite ();
	
	public EntityImpl (Location location) {
		this.location = location;
		hitbox = makeHitbox();
	}
	
	/**
	 * +ve amount => less health afterwards. 
	 */
	public void reduceHealth (int amount) {
		health -= amount;
	}
	
	public void draw (Graphics g) {
		g.drawImage(getSprite(), location.x, location.y,  64, getSprite().getHeight(), null);
	}
	
	public void interact(Interaction i) {
		i.apply(this);
	}
	
	public void move (int x, int y) {
		location.x += x;
		location.y += y;
		hitbox.move(x, y);
	}
	
	public Location getLocation () {
		return location;
	}
	
	public Hitbox getHitbox(){
		return this.hitbox;
	}
	
}
