package model;

 
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import map.Tile;

public abstract class Creep extends EntityImpl implements Entity, Hitboxable, Drawable {
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
    	makeHitbox ();
    }
    
    protected abstract AI makeAI ();
	public abstract void interact(Interaction i);
	public abstract BufferedImage getSprite ();
	
	
	public void draw (Graphics g) {
		g.fillRect(location.x, location.y,  Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		g.drawImage(getSprite(), location.x, location.y,  Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);
	}
	
	@Override
	public void update() {
		ticks ++;
		
		if (ticks == tickspeed) {
			ai.next (this);
			ticks = 0;
		}
	}

	public void makeHitbox() {
		hitbox = new Hitbox(this, new Rectangle (location.x,  location.y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT));
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public void setHitbox(Hitbox h){
		this.hitbox = h;
	}

}
