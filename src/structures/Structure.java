package structures;

import interactions.Interaction;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import structureAIs.StructureAI;
import map.Tile;
import model.EntityImpl;
import model.Hitbox;
import model.Location;
import model.Model;

public abstract class Structure extends EntityImpl {
	private StructureAI ai;
	
    public Structure (Location location){
    	super(location);
    	this.ai = makeAI ();
    	this.health = 100;
    }
    
    protected abstract StructureAI makeAI ();
	public abstract BufferedImage getSprite ();
	
	public Hitbox makeHitbox() {
		return new Hitbox(location.x,  location.y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
	}
	
	@Override
	public void update() {
		ticks ++;
		
		if (ticks == (int) (tickspeed * Model.model.yolospeed)) {
			ai.next (this);
			ticks = 0;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(getSprite(), location.x, location.y,  Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2, null);
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
