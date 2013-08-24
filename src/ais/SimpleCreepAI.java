package ais;

import model.AI;
import model.Action;
import model.Entity;

public class SimpleCreepAI implements AI {

	@Override
	public Action getNext(Entity e) {
		return new Action(Action.State.MOVE);
	}

}
