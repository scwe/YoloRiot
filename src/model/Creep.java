package model;

 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;

import map.Tile;
import map.Map;

public abstract class Creep extends EntityImpl implements Entity, Hitboxable, Drawable {
	private static final int CREEP_HEIGHT = 32;
	private static final int CREEP_WIDTH = 32;

	protected Model model;
	
	protected boolean dead = false;
	protected int health;
	
	protected int lane;
	
    public Creep(Location l, Model model){
    	this.location = l;
    	this.model = model;
    	this.ai = makeAI ();
    	this.health = 100;
    	lane = (l.y)/Tile.TILE_HEIGHT;  //this should work for finding the lane based on a y position
    }
    
    protected abstract AI makeAI ();
	public abstract void interact(Interaction i);
	protected abstract Image getSprite ();
	
	
	public void draw (Graphics g) {
		g.drawImage(getSprite(), location.x, location.y,  CREEP_WIDTH, CREEP_HEIGHT, null);
	}
	
	@Override
	public void update() {
		//ai.next (this);
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
	
	public void setHitbox(Hitbox h){
		this.hitbox = h;
	}

}
