package ais;

import java.util.Set;

import model.AI;
import model.Creep.CreepState;
import model.Entity;
import model.Model;
import model.Structure;
import creeps.SimpleCreep;

public class SimpleCreepAI implements AI {
	State last;
	
	@Override
	public void next(Entity e) {
		
		Set<Entity> intersected = Model.model.intersects(e.getHitBox());
		boolean attacking = false;
		for (Entity ent : intersected){
			if (ent instanceof Structure){
				SimpleCreep sc = (SimpleCreep)e;
				sc.setState(CreepState.ATTACKING);
				Structure attackedStruct = (Structure)ent;
				attackedStruct.reduceHealth(4);
				attacking = true;
			}
		}
		if(!attacking){
			e.move(-10,0);
		}
	}
}
