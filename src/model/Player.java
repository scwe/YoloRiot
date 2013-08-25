package model;
import image.SpriteSheet;
import interactions.Interaction;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import map.Tile;
import creeps.Creep.CreepState;

import playerAbilities.Ability;
import playerAbilities.PiercingShot;

public class Player extends EntityImpl {
	public static final int CHARACTER_WIDTH = 40;
	public static final int CHARACTER_HEIGHT = 64;
	private SpriteSheet sprites;
	public Direction curDirection;
	public int speed;
	public SpriteSheet spriteSheet;
	public int tickCount;
	private BufferedImage[] walk;
	
	public Ability curAbility;
	public int curAbilityIndex;
	
	public Player(){
		super (new Location(50, 50));
		speed = 6;
		curAbility = Model.abilities[0];
		curAbilityIndex = 0;
		//sprites = new SpriteSheet(0, 0, CHARACTER_WIDTH, CHARACTER_HEIGHT, "character.png");  TODO, uncomment when we have a playe sprite
	}
	
	public void changeAbility (int change) {
		curAbilityIndex = (curAbilityIndex + change) % Model.abilities.length;
		if (curAbilityIndex < 0) {
			curAbilityIndex += Model.abilities.length;
		}
		curAbility = Model.abilities[curAbilityIndex];
	}
    
    public void draw(Graphics g){
    	g.drawImage(getSprite(), location.x, location.y,  64, getSprite().getHeight(), null);
    }
    
    @Override
    public BufferedImage getSprite(){

    	tickCount+=4;
    	if (walk == null || attackingImage == null){
    		walk = new BufferedImage[4];
    		spriteSheet = new SpriteSheet(0, 0, Tile.TILE_WIDTH, Tile.TILE_HEIGHT,"MAIN_character2.png");
    		walk[0] = spriteSheet.getImage(0);
    		walk[1] = spriteSheet.getImage(1);
    		walk[2] = spriteSheet.getImage(2);
    		walk[3] = spriteSheet.getImage(3);
    		attackingImage = walk[0];
    	}
    	else{
	    	
	    	if(curDirection == Direction.NORTH){
	    		return walk[2];
	    	}
	    	if(curDirection == Direction.EAST){
	    		return walk[1];
	    	}
	    	if(curDirection == Direction.WEST){
	    		return walk[3];
	    	}
	    	return walk[0];
    	}
    	return walk[0];
    	
    }

	@Override
	public void interact(Interaction i) {
		i.apply(this);
	}

	public void move(Direction d){
		if(d == Direction.NORTH){
			move(0, -speed);
			curDirection = Direction.NORTH;
		}else if(d == Direction.EAST){
			move(speed, 0);
			curDirection = Direction.EAST;
		}else if(d == Direction.SOUTH){
			move(0, speed);
			curDirection = Direction.SOUTH;
		}else if(d == Direction.WEST){
			move(-speed, 0);
			curDirection = Direction.WEST;
		}
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void update() {} // not needed, player controlled.
	


	@Override
	protected Hitbox makeHitbox() {
		return new Hitbox(location.x, location.y, CHARACTER_WIDTH, CHARACTER_HEIGHT);
	}
}