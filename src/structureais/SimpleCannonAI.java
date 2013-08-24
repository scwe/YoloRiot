package structureais;

import model.AI;
import model.Entity;
import model.Structure;


public class SimpleCannonAI implements AI {

	public void next(Entity e) {
		((Structure)e).fire();
	}
}
