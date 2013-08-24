package model;
import java.awt.Graphics;

public abstract class Projectile extends EntityImpl implements Drawable, Hitboxable {
	Location l;
	
    public void draw(Graphics g){

    }

	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeHitbox() {
		// TODO Auto-generated method stub
		
	}
}