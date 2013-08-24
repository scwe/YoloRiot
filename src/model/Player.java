package model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import image.SpriteSheet;

public class Player implements Drawable, Entity, Hitboxable{
	public static final int CHARACTER_WIDTH = 40;
	public static final int CHARACTER_HEIGHT = 64;
	private SpriteSheet sprites;
	public Direction curDirection;
	private Location location;
	private Hitbox hitbox;
	private int speed;


	public Player(){
		speed = 4;
		location = new Location(50,50);

		//sprites = new SpriteSheet(0, 0, CHARACTER_WIDTH, CHARACTER_HEIGHT, "character.png");  TODO, uncomment when we have a playe sprite

		hitbox = new Hitbox(this, location.x, location.y, CHARACTER_WIDTH, CHARACTER_HEIGHT);
	}
    

    
    public void draw(Graphics g){
    	g.setColor(Color.blue);
    	hitbox.draw(g);
    }

	@Override
	public void interact(Interaction i) {
		// TODO Auto-generated method stub
		
	}


	public void move(Direction d){
		if(d == Direction.NORTH){
			location.y -= speed;
			hitbox.moveHitbox(0, -speed);
			curDirection = Direction.NORTH;
		}else if(d == Direction.EAST){
			location.x += speed;
			hitbox.moveHitbox(speed, 0);
			curDirection = Direction.EAST;
		}else if(d == Direction.SOUTH){
			location.y += speed;
			hitbox.moveHitbox(0, speed);
			curDirection = Direction.SOUTH;
		}else if(d == Direction.WEST){
			location.x -= speed;
			hitbox.moveHitbox(-speed, 0);
			curDirection = Direction.WEST;
		}
	}

	@Override
	public void update() {
		
	}


	@Override
	public Hitbox getHitbox() {
		return hitbox;
	}


	@Override
	public void setHitbox(Hitbox h) {
		this.hitbox = h;
		
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
	public Image getSprite() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void reduceHealth(int amount) {
		// TODO Auto-generated method stub
		
	}
}