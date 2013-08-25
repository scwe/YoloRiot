package projectiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Set;

import model.Entity;
import model.Location;
import model.Model;

public class YoloBolt extends Projectile {
	
	public YoloBolt(Location start, Location direction) {
		super(start, direction);
		tickspeed = 1;
	}

	@Override
	public void initialiseSpriteSheet() {
		// TODO Auto-generated method stub
	}

	@Override
	public BufferedImage getSprite() {
		BufferedImage bf = new BufferedImage (32, 32, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) bf.createGraphics();
		g2d.fillRect(0, 0, 32, 32);
		return bf;
	}

	@Override
	public void update() {
		ticks++;
		
		if (ticks == tickspeed) {
			ticks = 0;
			unitMove(20);
		}
	}
}
