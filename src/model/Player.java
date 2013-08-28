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
	private BufferedImage[] northWalk;
	private BufferedImage[] eastWalk;
	private BufferedImage[] westWalk;
	private BufferedImage[] southWalk;
	private int baseTick = 10;
	
	
	public static final int MAX_HEALTH = 35;
	
	public Ability curAbility;
	public int curAbilityIndex;
	
	public Player(){
		super (new Location(128, 128));
		health = MAX_HEALTH;
		speed = 8;
		tickspeed = 10;
		curAbility = Model.abilities[0];
		curAbilityIndex = 0;
		//sprites = new SpriteSheet(0, 0, CHARACTER_WIDTH, CHARACTER_HEIGHT, "character.png");  TODO, uncomment when we have a playe sprite
	}
	
	public void reduceHealth (int amount) {
		this.health = health-amount;
		
		if (!Model.model.yolomode) Model.model.FULLYOL0();
		else{
		
		}
	}
	
	public void changeAbility (int change) {
		curAbilityIndex = (curAbilityIndex + change) % Model.abilities.length;
		if (curAbilityIndex < 0) {
			curAbilityIndex += Model.abilities.length;
		}
		curAbility = Model.abilities[curAbilityIndex];
	}
    
    public void draw(Graphics g){
    	g.drawImage(getSprite(), location.x, location.y,  64, 64, null);
    }
    
    @Override
    public BufferedImage getSprite(){

    	tickCount+=4;
    	if (northWalk == null){
    		northWalk = new BufferedImage[4];
    		spriteSheet = new SpriteSheet(0, 0, Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2,"prog_walk_up.png");
    		northWalk[0] = spriteSheet.getImage(0);
    		northWalk[1] = spriteSheet.getImage(1);
    		northWalk[2] = spriteSheet.getImage(2);
    		northWalk[3] = spriteSheet.getImage(3);
    		
    		eastWalk = new BufferedImage[4];
    		spriteSheet = new SpriteSheet(0, 0, Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2,"prog_walk_right.png");
    		eastWalk[0] = spriteSheet.getImage(0);
    		eastWalk[1] = spriteSheet.getImage(1);
    		eastWalk[2] = spriteSheet.getImage(2);
    		eastWalk[3] = spriteSheet.getImage(3);
    		
    		westWalk = new BufferedImage[4];
    		spriteSheet = new SpriteSheet(0, 0, Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2,"prog_walk_left.png");
    		westWalk[0] = spriteSheet.getImage(0);
    		westWalk[1] = spriteSheet.getImage(1);
    		westWalk[2] = spriteSheet.getImage(2);
    		westWalk[3] = spriteSheet.getImage(3);
    		
    		southWalk = new BufferedImage[4];
    		spriteSheet = new SpriteSheet(0, 0, Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2,"prog_walk_down.png");
    		southWalk[0] = spriteSheet.getImage(0);
    		southWalk[1] = spriteSheet.getImage(1);
    		southWalk[2] = spriteSheet.getImage(2);
    		southWalk[3] = spriteSheet.getImage(3);
    		return eastWalk[0];
    	}
    	
    	else{
    		
    		int spriteVal = 0;
        	if (tickCount > baseTick ){
        		spriteVal = 0;
    		}
        	else if (tickCount > 2*baseTick)
        		spriteVal = 1;
        	else if (tickCount > 3*baseTick)
        		spriteVal =2;
        	else{
        		spriteVal = 3;
        	}
	    	
	    	if(curDirection == Direction.NORTH){
	    		return northWalk[spriteVal];
	    	}
	    	else if(curDirection == Direction.EAST){
	    		return eastWalk[spriteVal];
	    	}
	    	else if(curDirection == Direction.WEST){
	    		return westWalk[spriteVal];
	    	}
	    	else {
	    		return southWalk[0];
	    	}
    	}

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

	// FIXME
	@Override
	public void initialiseSpriteSheet() {
		// TODO Auto-generated method stub
		
	}
}