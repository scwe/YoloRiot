package creepAIs;

import java.util.Set;

import structures.Structure;
import model.Entity;
import model.Model;
import model.Player;
import creeps.Creep;
import creeps.SimpleCreep;
import creeps.Creep.CreepState;

public class SimpleCreepAI implements CreepAI {
	State last;

	@Override
	public void next(Creep c) {

		Set<Entity> intersected = Model.model.intersectsFriendly(c.getHitbox());
		boolean attacking = false;
		SimpleCreep sc = (SimpleCreep) c;
		for (Entity ent : intersected) {

			if (ent instanceof Structure) {
				sc.setState(CreepState.ATTACKING);
				Structure attackedStruct = (Structure) ent;
				attackedStruct.reduceHealth(8);
				attacking = true;
			} else if (ent instanceof Player) {
				sc.setState(CreepState.ATTACKING);
				Player attackedPlayer = (Player) ent;
				attackedPlayer.reduceHealth(8);
				attacking = true;
			}
		}
		if (!attacking && !Model.model.yolomode) {
			c.move(-10, 0);
			sc.setState(CreepState.MOVING);
		} else if (!attacking) {
			double ranDir = Math.random();
			if (ranDir < 0.6) {
				c.move(-10, 0);
				return;
			} else if (ranDir < 0.7) {
				c.move(0, -10);
				return;
			} else {
				c.move(0, 10);
			}
			sc.setState(CreepState.MOVING);
		}
	}
}
