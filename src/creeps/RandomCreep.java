package creeps;

import image.ImageLoader;

import java.awt.image.BufferedImage;

import model.Location;
import creepAIs.CreepAI;
import creepAIs.RandomCreepAI;

public class RandomCreep extends SimpleCreep{
	
	private int randomness;
	
	public RandomCreep(Location location, int randomness) {
		super(location);
		this.tickspeed = 10;
		this.randomness= randomness;
	}
	
	protected CreepAI makeAI() {
		return new RandomCreepAI(randomness);
	}
	
	public BufferedImage getSprite() {
		if (image == null){
			ImageLoader il = new ImageLoader();
			image = il.getImage("test.png");
		
		}
		return image;
	}
	
}
