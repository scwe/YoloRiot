package map;

import image.SpriteSheet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Map {
	public static final int MAP_WIDTH = 15;
	public static final int MAP_HEIGHT = 10;

	private Tile[][] tiles;
	
	ArrayList<SpriteSheet> spriteSheets;

	
	BufferedImage[][] buffer;
	
	private Random r;
	private int seed;

	public Map(LevelData level) {
		
		spriteSheets = new ArrayList<SpriteSheet>();
		tiles = new Tile[MAP_HEIGHT][MAP_WIDTH];
		
		spriteSheets.add(new SpriteSheet(0, 0, Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2,level.getInnerTile()));
		spriteSheets.add(new SpriteSheet(0, 0, Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2,level.getOuterTile()));
		spriteSheets.add(new SpriteSheet(0, 0, Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2,level.getCornerTile()));

	}
	
	public Tile[][] getTiles() {
		return tiles;
	}

	public void draw(Graphics g) {
		if (buffer != null) 
		{
			for (int h = 0; h < MAP_HEIGHT; h++) {
				for (int w = 0; w < MAP_WIDTH; w++) {
					g.drawImage(buffer[h][w],w
							* Tile.TILE_WIDTH, h * Tile.TILE_HEIGHT,
							Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);
				}
			}
		}

		else{
			buffer = new BufferedImage[MAP_HEIGHT][MAP_WIDTH];
			ArrayList<BufferedImage> tileSet ;
			
			for (int h = 0; h < MAP_HEIGHT; h++) {
				for (int w = 0; w < MAP_WIDTH; w++) {
					String type = tileType(h,w);
					tileSet = getTileSet(type);
					BufferedImage curImage = null;
					if(type.equals("CORNER")){
						curImage = tileSet.get(0);
					}
					else if(type.equals("MIDDLE")){
						curImage = tileSet.get(0);
					}
					else{
						curImage = tileSet.get(1);
					}
					g.drawImage(curImage,w
							* Tile.TILE_WIDTH, h * Tile.TILE_HEIGHT,
							Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);
					buffer[h][w] = curImage;
				}
			}
		}
	}
	
	public ArrayList<BufferedImage> getTileSet(String type){
		
		ArrayList<BufferedImage> tileSet = new ArrayList<BufferedImage>();
		BufferedImage innerT = spriteSheets.get(0).getRandomImage();
		tileSet.add(innerT);
		BufferedImage edgeT= spriteSheets.get(1).getImage(type);
		tileSet.add(edgeT);
		BufferedImage cornerT = spriteSheets.get(2).getRandomImage();
		tileSet.add(cornerT);
		return tileSet;
		
	}
	
	public String tileType(int h, int w){
		String res = null;
		if(h == 0 && w == 0 || h == 0 && w == MAP_WIDTH-1 || h == MAP_HEIGHT-1 && w == MAP_WIDTH-1){
			res = "CORNER";
		}
		else if (h == 0){
			res = "TOP";
		}
		else if (h == MAP_HEIGHT-1){
			res = "BOTTOM";
		}
		else if (w == 0){
			res = "LEFT";
		}
		else if (w == MAP_WIDTH-1){
			res = "RIGHT";
		}
		else{
			res = "MIDDLE";
		}
		return res;
	}
	
	
	
	public enum TileType{
		INNER_TILE,EDGE_TILE,CORNER_TILE;
		
	}


}
