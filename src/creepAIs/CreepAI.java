package creepAIs;

import creeps.Creep;

public interface CreepAI {
	public enum State {MOVE, ATTACK};
	public void next (Creep c);
}
