package model;

import image.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import map.Tile;

public class Yolostone extends Structure implements Drawable {
	
	public boolean destroyed = false;
	private int num;
	
	public Yolostone (int num, Model model) {
		super(new Location(0, Tile.TILE_HEIGHT*num), model);
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
			image = il.getImage("wip yolo crystal.png");
		
		}
		return image;
	}

	@Override
	protected AI makeAI() {
		return null; // needs no AI.
	}

	@Override
	public void fire() { // does nothing
	}
}
