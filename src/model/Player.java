package model;
import image.SpriteSheet;
import interactions.Interaction;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import playerAbilities.Ability;
import playerAbilities.SimpleShoot;

public class Player extends EntityImpl {
	public static final int CHARACTER_WIDTH = 40;
	public static final int CHARACTER_HEIGHT = 64;
	private SpriteSheet sprites;
	public Direction curDirection;
	private int speed;
	
	public Ability curAbility;
	public static Ability[] abilities = {new SimpleShoot ()};
	
	public Player(){
		super (new Location(50, 50));
		speed = 4;
		curAbility = abilities[0];
		//sprites = new SpriteSheet(0, 0, CHARACTER_WIDTH, CHARACTER_HEIGHT, "character.png");  TODO, uncomment when we have a playe sprite
	}
    
    public void draw(Graphics g){
    	g.setColor(Color.blue);
    	hitbox.draw(g);
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
	public BufferedImage getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Hitbox makeHitbox() {
		return new Hitbox(location.x, location.y, CHARACTER_WIDTH, CHARACTER_HEIGHT);
	}
}