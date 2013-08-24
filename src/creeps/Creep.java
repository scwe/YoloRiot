package creeps;

import java.awt.Polygon;

import ais.AI;
import model.Entity;
import model.EntityImpl;
import model.Hitbox;
import model.Hitboxable;
import model.Interaction;
import model.Location;

public abstract class Creep extends EntityImpl implements Entity, Hitboxable {
	
	private static final int CREEP_SIZE_X = 32;
	private static final int CREEP_SIZE_Y = 32;
	
    public Creep(Location l){
    	this.location = l;
    	this.ai = makeAI ();
    }
    
    protected abstract AI makeAI ();

	@Override
	public void interact(Interaction i) {
			
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		//
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
