package projectiles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import model.Location;

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
		g2d.setColor(new Color((int)(255*Math.random()), (int)(255*Math.random()), (int)(255*Math.random())));
		g2d.fillRect(0, 15, 32, 3);
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
