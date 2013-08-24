package creepAIs;

import java.util.Set;

import structures.Structure;
import model.Entity;
import model.Model;
import creeps.Creep;
import creeps.SimpleCreep;
import creeps.Creep.CreepState;

public class SimpleCreepAI implements CreepAI {
	State last;
	
	@Override
	public void next(Creep c) {
		
		Set<Entity> intersected = Model.model.intersects(c.getHitbox());
		boolean attacking = false;
		for (Entity ent : intersected){
			if (ent instanceof Structure){
				SimpleCreep sc = (SimpleCreep)c;
				sc.setState(CreepState.ATTACKING);
				Structure attackedStruct = (Structure)ent;
				attackedStruct.reduceHealth(4);
				attacking = true;
			}
		}
		if(!attacking){
			c.move(-10,0);
		}
	}
}
