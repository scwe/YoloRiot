package model;

import java.awt.Polygon;

public abstract class EntityImpl implements Entity {
	protected static final int ENTITY_SIZE_X = 32;
	protected static final int ENTITY_SIZE_Y = 32;
	
	AI ai;
	Hitbox hitbox;
	Location l;

	public abstract void interact(Interaction i);
	public abstract void update();
}
