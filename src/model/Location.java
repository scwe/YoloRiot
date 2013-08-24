package model;

public class Location {
	public int x;
	public int y;
	
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void moveLeft(int amount) {
		x -= amount;
	}
	
	public void moveRight (int amount) {
		x += amount;
	}
}
