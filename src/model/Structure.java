package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import map.Tile;

public abstract class Structure extends EntityImpl implements Entity, Hitboxable, Drawable {
	public abstract void update();
	public Model model;
	
    public Structure (Location l, Model model){
    	this.location = l;
    	this.model = model;
    	this.ai = makeAI ();
    	this.health = 100;
    	makeHitbox ();
    }
    
    protected abstract AI makeAI ();
	public abstract BufferedImage getSprite ();
	
	public void makeHitbox() {
		hitbox = new Hitbox(this, new Rectangle (location.x,  location.y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT));
	}
	
	@Override
	public void setHitbox (Hitbox h) {
		hitbox = h;
	}
	
	@Override
	public Hitbox getHitbox () {
		return hitbox;
	}
	
	@Override
	public void interact(Interaction i) {
		i.apply(this);
	}

	public abstract void fire ();
}
