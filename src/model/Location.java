package model;

public class Location {
	private int lane;
	private int x; // x is zero on the left
	
	public Location (int lane, int x) {
		this.lane = lane;
		this.x = x;
	}
	
	public int getLane() {
		return lane;
	}
	public void setLane(int lane) {
		this.lane = lane;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
}
