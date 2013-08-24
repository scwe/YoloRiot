package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import map.Tile;

public abstract class Projectile extends EntityImpl implements Drawable,
		Hitboxable {

	protected Location vector;
	protected double angle;
	protected double movelength = 10;

	protected Hitbox hitbox;
	protected Model model;

	public Projectile(Location location, Model model) {
		this.location = location;
		this.model = model;
	}

	public Projectile(Location start, Location direction, Model model) {
		this.model = model;
		location = start;
		vector = direction;
		angle = Math.atan2(vector.y - location.y, vector.x - location.x);
	}

	@Override
	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox h) {
		this.hitbox = h;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BufferedImage sprite = getSprite ();
		int imgsize = Math.max(sprite.getHeight() * 2, sprite.getWidth() * 2);
		
	    BufferedImage dimg = new BufferedImage(imgsize, imgsize, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D gimg = dimg.createGraphics();
	    gimg.rotate(angle, imgsize/2, imgsize/2);
	    gimg.drawImage(getSprite(), imgsize/4, imgsize/4, null);
	    gimg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    g2d.drawImage(dimg, null, location.x - imgsize/2, location.y - imgsize/2);
	}

	@Override
	public void interact(Interaction i) {
		// not needed for projectiles, as they only interact with others.
	}
	
	//FIXME hitboxes for projs are small.

	/**
	 * helper function that calculates and applies unit movement ratios so we
	 * don't have to always copy out the fucking trig.
	 */
	protected final void unitMove(int magnitude) {
		double xunit = Math.cos(angle);
		double yunit = Math.sin(angle);

		location.x += xunit * magnitude;
		location.y += yunit * magnitude;
		
		hitbox.translate((int)(xunit*magnitude), (int)(yunit*magnitude));
	}

	/**
	 * another maths helper.
	 */
	protected final void setHitbox(int width, int length) {
		hitbox = new Hitbox(this, location.x, location.y, 10, 10);
	}

	public abstract void update();
}