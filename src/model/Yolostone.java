package model;

import image.ImageLoader;

import java.awt.image.BufferedImage;

public class Yolostone extends EntityImpl {
	
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
	
}
