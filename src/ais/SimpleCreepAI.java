package ais;

import model.AI;
import model.Entity;

public class SimpleCreepAI implements AI {
	State last;
	
	@Override
	public void next(Entity e) {
		e.move(-10,0);
	}
}
