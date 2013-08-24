package creepAIs;

import creeps.Creep;
import model.Entity;

public class RandomCreepAI implements CreepAI {
	State last;
	private int randomness;
	
	
	public RandomCreepAI(int randomness){
		
		this.randomness = 10 - randomness;
		
	}
	
	
	@Override
	public void next(Creep c) {
		int ran = (int)(Math.random()*10);

		if (ran < randomness){

			double ranDir = Math.random();
			if (ranDir < 0.6){
				c.move(-10, 0);
				return;
			}
			else if (ranDir < 0.7){
				c.move(0, -10);
				return;
			}
			else{
				c.move(0,10);
			}
		}
		else{
			c.move(-10, 0);
		}
	}
}