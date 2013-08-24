package map;

import image.SpriteSheet;

import java.awt.Graphics;
import java.util.Random;

import model.Drawable;

public class Map implements Drawable {
	public static final int MAP_OFFSET_X = 20;
	public static final int MAP_OFFSET_Y = 50;
	public static final int MAP_WIDTH = 15;
	public static final int MAP_HEIGHT = 10;

	private Tile[][] tiles;
	private SpriteSheet tileSet;
	
	private Random r;
	private int seed;

	public Map(String filename) {
		tiles = new Tile[MAP_HEIGHT][MAP_WIDTH];
		tileSet = new SpriteSheet(0, 0, Tile.TILE_WIDTH, Tile.TILE_HEIGHT,
				filename);
		seed = (int)Math.random()*32034;
		r = new Random(seed);
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	@Override
	public void draw(Graphics g) {
		r = new Random(seed);
		for (int h = 0; h < MAP_HEIGHT; h++) {
			for (int w = 0; w < MAP_WIDTH; w++) {
				
				tileSet.setX((int)(r.nextDouble()*tileSet.getWidth()));   //change the tile we are using randomly
				
				
				g.drawImage(tileSet.getImage(), MAP_OFFSET_X + w
						* Tile.TILE_WIDTH, MAP_OFFSET_Y + h * Tile.TILE_HEIGHT,
						Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);

			}
		}
	}

}
