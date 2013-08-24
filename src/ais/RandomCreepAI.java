package ais;

import model.AI;
import model.Entity;

public class RandomCreepAI implements AI {
	State last;
	private int randomness;
	
	
	public RandomCreepAI(int randomness){
		
		this.randomness = 10 - randomness;
		
	}
	
	
	@Override
	public void next(Entity e) {
		int ran = (int)(Math.random()*10);

		if (ran < randomness){

			double ranDir = Math.random();
			if (ranDir < 0.6){
				e.move(-10, 0);
				return;
			}
			else if (ranDir < 0.7){
				e.move(0, -10);
				return;
			}
			else{
				e.move(0,10);
			}
		}
		else{
			e.move(-10, 0);
		}
	}
}