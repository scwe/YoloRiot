package structures;

import image.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.AI;
import model.Location;
import model.Model;
import model.Structure;

public class SimpleWall extends Structure {
	
	public SimpleWall(Location l, Model model) {
		super(l, model);
		this.health = 1000;
	}

	@Override
	protected AI makeAI() { // no AI
		return null;
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
	public void fire() {// no firing
	}

}
