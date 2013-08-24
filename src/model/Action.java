package model;

import model.Action.State;

public class Action {
	public enum State {MOVE, ATTACK}

	public final State state;
	public final Entity interacting;

	public Action (State state) {
		this.state = state;
		interacting = null;
	}
	
	public Action (State state, Entity interacting) {
		this.state = state;
		this.interacting = interacting;
	}
}
