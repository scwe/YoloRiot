package structures;

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
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() { // does nothing
	}

	@Override
	protected AI makeAI() { // no AI
		return null;
	}

	@Override
	public BufferedImage getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fire() {// no firing
	}

}
