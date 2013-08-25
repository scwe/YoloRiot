package creeps;

import image.ImageLoader;
import image.SpriteSheet;
import interactions.Interaction;
import interactions.SimpleDamage;

import java.awt.image.BufferedImage;

import map.Tile;
import model.Location;
import model.Model;
import creepAIs.CreepAI;
import creepAIs.SimpleCreepAI;

public class SimpleCreep extends Creep {
	private final Interaction attack = new SimpleDamage (5);
	private int tickCount =0;
	SpriteSheet spriteSheet;
	BufferedImage[] walk;
	
	public SimpleCreep(Location location) {
		super(location);

		tickspeed = 20;


	}

	@Override
	protected CreepAI makeAI() {
		return new SimpleCreepAI ();
	}

	@Override
	public void interact(Interaction i) {
		Model.model.killEntity(this);
	}

	@Override
	public int getYoloTickSpeed() {
		return (int)(tickspeed * 0.2  * Model.model.yolospeed);
	}
	
	@Override
	public BufferedImage getSprite() {
		tickCount+=5;
		if (walk == null || attackingImage == null){
			walk = new BufferedImage[4];
			spriteSheet = new SpriteSheet(0, 0, Tile.TILE_WIDTH, Tile.TILE_HEIGHT,"64_creep_1.png");
			walk[0] = spriteSheet.getImage(1);
			walk[1] = spriteSheet.getImage(2);
			walk[2] = spriteSheet.getImage(3);
			walk[3] = spriteSheet.getImage(0);
			attackingImage = walk[0];
			return walk[0];
		}
		else if (this.state == CreepState.ATTACKING){
			return attackingImage;
		}
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

	}
}
