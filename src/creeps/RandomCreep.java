package creeps;

import image.ImageLoader;
import image.SpriteSheet;

import java.awt.image.BufferedImage;

import map.Tile;
import model.Location;
import creepAIs.CreepAI;
import creepAIs.RandomCreepAI;
import creeps.Creep.CreepState;

public class RandomCreep extends SimpleCreep{
	SpriteSheet sp;
	BufferedImage walking[];
	private int randomness;
	private double tickCount = 0;
	public RandomCreep(Location location, int randomness,int health, int speed) {
		super(location,health,speed);
		this.tickspeed = 10;
		this.randomness= randomness;
	}
	
	protected CreepAI makeAI() {
		return new RandomCreepAI(randomness);
	}
	
	@Override
	public BufferedImage getSprite() {
		
		if (walking == null ){
			walking = new BufferedImage[4];
			sp = new SpriteSheet(0, 0, Tile.TILE_WIDTH, Tile.TILE_HEIGHT,"1creepattackgreen2.png");
			walking[0] = sp.getImage(1);
			walking[1] = sp.getImage(2);
			walking[2] = sp.getImage(3);
			walking[3] = sp.getImage(0);
			return walking[0];
		}
		

		tickCount+=5;
		if(tickCount < 50){
			return walking[0];
		}
		else if (tickCount < 100)
			return walking[1];
		else if (tickCount < 150){
			return walking[2];
		}
		else if (tickCount < 200){
			return walking[3];
		}
		if (tickCount > 200){
			tickCount = 0;
		}
		return walking[0];

	}
	
}
