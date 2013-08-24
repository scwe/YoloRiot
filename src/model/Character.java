package model;
import java.awt.Graphics;
import image.SpriteSheet;

public class Character implements Drawable, Entity, Hitboxable{
	public static final int CHARACTER_WIDTH = 40;
	public static final int CHARACTER_HEIGHT = 64;
	private SpriteSheet sprites;
	private Location location;
	private Hitbox hitbox;
	
	public Character(){
		location = new Location(50,50);
		sprites = new SpriteSheet(0, 0, CHARACTER_WIDTH, CHARACTER_HEIGHT, "character.png");
		hitbox = new Hitbox(location.x, location.y, CHARACTER_WIDTH, CHARACTER_HEIGHT);
	}
    

    
    public void draw(Graphics g){
    	
    }

	@Override
	public void interact(Interaction i) {
		// TODO Auto-generated method stub
		
	}


	public void move(int x, int y){
	}

	@Override
	public void update() {
		
	}



	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setHitbox(Hitbox h) {
		// TODO Auto-generated method stub
		
	}
}