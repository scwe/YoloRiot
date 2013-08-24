package model;

import image.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import map.Tile;

public class Yolostone extends EntityImpl implements Drawable {
	
	public boolean destroyed = false;
	private int num;
	
	public Yolostone (int num) {
		this.num = num;
	}
	
	@Override
	public void update() {
		// no update needed, static.
	}

	@Override
	public BufferedImage getSprite() {
		if (image == null){
			ImageLoader il = new ImageLoader();
			image = il.getImage("CREEP1.png");
		
		}
		return image;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(getSprite(), 0, Tile.TILE_HEIGHT*num,  Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);
	}
	
}
