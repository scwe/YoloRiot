package creeps;

import image.ImageLoader;

import java.awt.image.BufferedImage;

import ais.RandomCreepAI;
import ais.SimpleCreepAI;
import model.AI;
import model.Creep;
import model.Location;
import model.Model;

public class RandomCreep extends SimpleCreep{
	
	private int randomness;
	
	public RandomCreep(Location location, Model model, int randomness) {
		super(location,model);
		this.tickspeed = 10;
		this.randomness= randomness;
	}
	
	protected AI makeAI() {
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
