package creeps;

import gui.SoundFactory;
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
	SpriteSheet spriteSheetAttack;
	BufferedImage[] walk;
	BufferedImage[] attacking;
	
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
		i.apply(this);
		if (health <= 0) {
			Model.model.killEntity(this);
			SoundFactory.playSound("audio/die.wav");
		}
	}

	@Override
	public int getYoloTickSpeed() {
		return (int)(tickspeed * 0.2  * Model.model.yolospeed);
	}
	
	@Override
	public BufferedImage getSprite() {
		
		if (this.state.equals(CreepState.MOVING) && (walk== null )){
			walk = new BufferedImage[4];
			spriteSheet = new SpriteSheet(0, 0, Tile.TILE_WIDTH, Tile.TILE_HEIGHT,"64_creep_1.png");
			walk[0] = spriteSheet.getImage(1);
			walk[1] = spriteSheet.getImage(2);
			walk[2] = spriteSheet.getImage(3);
			walk[3] = spriteSheet.getImage(0);
			
			attacking = new BufferedImage[5];
			spriteSheetAttack = new SpriteSheet(0, 0, Tile.TILE_WIDTH, Tile.TILE_HEIGHT,"1creepattackblue2.png");
			attacking[0] = spriteSheetAttack.getImage(0);
			attacking[1] = spriteSheetAttack.getImage(1);
			attacking[2] = spriteSheetAttack.getImage(2);
			attacking[3] = spriteSheetAttack.getImage(3);
			//attacking[4] = spriteSheetAttack.getImage(4);
			
			return walk[0];
		}
		else if (this.state.equals(CreepState.ATTACKING)){
			tickCount+=1;
			if(tickCount < 5){
				return attacking[0];
			}
			else if (tickCount < 10)
				return attacking[1];
			else if (tickCount < 20){
				return attacking[2];
			}
			else if (tickCount < 30){
				return attacking[3];
			}
			if (tickCount > 20){
				tickCount = 0;
			}
			return attacking[0];
		
		}
	
			tickCount+=5;
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

	@Override
	public void initialiseSpriteSheet() {
		spriteSheet = new SpriteSheet(0, 0, Tile.TILE_WIDTH, Tile.TILE_HEIGHT,"64_creep_1.png");
	}
	
	
}
