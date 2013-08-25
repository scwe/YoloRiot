package creeps;

import image.ImageLoader;
import image.SpriteSheet;

import java.awt.image.BufferedImage;

import map.Tile;
import model.Location;
import creepAIs.CreepAI;
import creepAIs.HomingCreepAI;
import creeps.Creep.CreepState;

public class HomingCreep extends SimpleCreep{
	int tickCount;
	public HomingCreep(Location location) {
		super(location);
		this.tickspeed = 10;
	}
	
	protected CreepAI makeAI() {
		return new HomingCreepAI();
	}
	
	public BufferedImage getSprite() {
		tickCount+=4;
		if (walk == null || attackingImage == null){
			walk = new BufferedImage[4];
			spriteSheet = new SpriteSheet(0, 0, Tile.TILE_WIDTH, Tile.TILE_HEIGHT,"64_creep_3.png");
			walk[0] = spriteSheet.getImage(1);
			walk[1] = spriteSheet.getImage(2);
			walk[2] = spriteSheet.getImage(3);
			walk[3] = spriteSheet.getImage(0);
			attackingImage = walk[0];
			
		}
		else if (this.state == CreepState.ATTACKING)
			return attackingImage;
		else{
			
			if(tickCount < 50){
				return walk[0];
			}
			else if (tickCount < 100)
				return walk[1];
			else if (tickCount < 150){
				return walk[2];
			}
			else if (tickCount < 200){
				
				return walk[3];
			}
			if (tickCount > 200){
				tickCount = 0;
				
			}
				
			return walk[0];
		}
		return null;
		

	}
	
	@Override
	public int getYoloTickSpeed() {
		return tickspeed;
	}
	
}
