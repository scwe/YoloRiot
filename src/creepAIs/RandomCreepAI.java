package creepAIs;

import java.util.Set;

import structures.Structure;
import creeps.Creep;
import creeps.SimpleCreep;
import creeps.Creep.CreepState;
import model.Entity;
import model.Model;
import model.Player;

public class RandomCreepAI implements CreepAI {
	State last;
	private int randomness;
	
	
	public RandomCreepAI(int randomness){
		
		this.randomness = 10 - randomness;
		
	}
	
	
	@Override
	public void next(Creep c) {
		Set<Entity> intersected = Model.model.intersectsFriendly(c.getHitbox());
		boolean attacking = false;
		SimpleCreep sc = (SimpleCreep) c;
		for (Entity ent : intersected) {

			if (ent instanceof Structure) {
				sc.setState(CreepState.ATTACKING);
				Structure attackedStruct = (Structure) ent;
				attackedStruct.reduceHealth(1);
				attacking = true;
			} else if (ent instanceof Player) {
				sc.setState(CreepState.ATTACKING);
				Player attackedPlayer = (Player) ent;
				attackedPlayer.reduceHealth(1);
				attacking = true;
			}
			if(attacking) return;
		}
		int ran = (int)(Math.random()*10);

		if (ran < randomness){

			double ranDir = Math.random();
			if (ranDir < 0.6){
				c.move(-c.speed, 0);
				return;
			}
			else if (ranDir < 0.8){
				c.move(0, -c.speed);
				return;
			}
			else{
				c.move(0,c.speed);
			}
		}
		else{
			c.move(-c.speed, 0);
		}
	}
}