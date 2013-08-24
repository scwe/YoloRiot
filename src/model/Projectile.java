package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

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
		g.setColor(Color.GREEN);

		AffineTransform tx = AffineTransform.getRotateInstance(angle, location.x + 15, location.y+ 15);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		g2d.drawImage(op.filter(getSprite(), null), location.x, location.y,	null);

		//g.fillRect(location.x, location.y, 30, 30);
		//g.drawImage(getSprite(), location.x, location.y, null);
	}

	@Override
	public void interact(Interaction i) {
		// not needed for projectiles, as they only interact with others.
	}

	/**
	 * helper function that calculates and applies unit movement ratios so we
	 * don't have to always copy out the fucking trig.
	 */
	protected final void unitMove(int magnitude) {
		double xunit = Math.cos(angle);
		double yunit = Math.sin(angle);

		location.x += xunit * magnitude;
		location.y += yunit * magnitude;
	}

	/**
	 * another maths helper.
	 */
	protected final void setHitbox(int width, int length) {
		hitbox = new Hitbox(-1, -1, 1, 1);
	}

	public abstract void update();
}