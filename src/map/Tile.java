package map;

public class Tile {
	
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 64;
	
	int xLoc;
	int yLoc;
	int width;
	int height;
	
	public Tile(int xLoc, int yLoc, int width, int height) {
		super();
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.width = width;
		this.height = height;
	}
	public int getxLoc() {
		return xLoc;
	}
	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}
	public int getyLoc() {
		return yLoc;
	}
	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	

}
