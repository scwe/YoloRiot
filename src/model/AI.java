package model;

public interface AI {
	public enum State {MOVE, ATTACK};
	public void next (Entity e);
}
