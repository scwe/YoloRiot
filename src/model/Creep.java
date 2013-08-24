package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;

public abstract class Creep extends EntityImpl implements Entity, Hitboxable, Drawable {
	private static final int CREEP_SIZE_X = 32;
	private static final int CREEP_SIZE_Y = 32;

	protected Model model;
	
	protected boolean dead = false;
	protected int health;
	
    public Creep(Location l, Model model){
    	this.location = l;
    	this.model = model;
    	this.ai = makeAI ();
    	this.health = 100;
    }
    
    protected abstract AI makeAI ();
	public abstract void interact(Interaction i);
	protected abstract Image getSprite ();
	
	
	public void draw (Graphics g) {
		g.drawImage(getSprite(), location.getX(), location.getLane() * 32, null); // MAKE THIS A CONSTANT
	}
	
	@Override
	public void update() {
		ai.next (this);
	}

	public void makeHitbox() {
		int[] xpoints = { -1 * ENTITY_SIZE_X / 2, ENTITY_SIZE_X / 2,
				-1 * ENTITY_SIZE_X / 2, ENTITY_SIZE_X / 2 };
		int[] ypoints = { ENTITY_SIZE_Y / 2, ENTITY_SIZE_Y / 2,
				-1 * ENTITY_SIZE_Y / 2, -1 * ENTITY_SIZE_Y / 2 };
		Polygon p = new Polygon(xpoints, ypoints, xpoints.length);

		hitbox = new Hitbox(p);
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}

}
