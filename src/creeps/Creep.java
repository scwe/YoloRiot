package creeps;

 
import interactions.Interaction;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import creepAIs.CreepAI;
import map.Tile;
import model.EntityImpl;
import model.Hitbox;
import model.Location;
import model.Model;

public abstract class Creep extends EntityImpl {
	protected boolean dead = false;
	protected int health;
	protected CreepState state = CreepState.MOVING;
	protected int lane;
	
	protected CreepAI AI;
	
    public Creep(Location location){
    	super (location);
    	this.AI = makeAI ();
    	this.health = 100;
    	lane = (location.y)/Tile.TILE_HEIGHT;  //this should work for finding the lane based on a y position
    	makeHitbox ();
    }
    
    protected abstract CreepAI makeAI ();
	public abstract void interact(Interaction i);
	public abstract BufferedImage getSprite ();
	public abstract int getYoloTickSpeed ();
	
	@Override
	public void update() {
		ticks ++;
		
		int ticknum = Model.model.yolomode ? getYoloTickSpeed() : tickspeed;
		
		if (ticks >= ticknum) {
			AI.next (this);
			ticks = 0;
		}
	}

	public Hitbox makeHitbox() {
		return new Hitbox(location.x,  location.y, 64, 64);
	}
	
	public void setState(CreepState s){
		this.state = s;
	}
	
	public enum CreepState{
		MOVING,ATTACKING,SLEEPING,FULLYOLO;
	}
}
