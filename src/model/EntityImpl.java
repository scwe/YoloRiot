package model;

import java.awt.Image;

public abstract class EntityImpl implements Entity {	
	protected AI ai;
	protected Hitbox hitbox;
	protected Location location;
	
	protected int tickspeed = 100; // number of ticks to get before update
	protected int ticks = 0;

	public Location getLocation () {
		return location;
	}
	
	public abstract void interact(Interaction i);
	public abstract void update();
	public abstract Image getSprite ();
}
