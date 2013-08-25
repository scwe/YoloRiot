package projectiles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import model.Location;

public class YoloBolt extends Projectile {
	
	private Color randColor;
	
	public YoloBolt(Location start, Location direction) {
		super(start, direction);
		tickspeed = 1;
		this.randColor = new Color((int)(255*Math.random()), (int)(255*Math.random()), (int)(255*Math.random()));
	}

	@Override
	public void initialiseSpriteSheet() {
		// TODO Auto-generated method stub
	}

	@Override
	public BufferedImage getSprite() {
		BufferedImage bf = new BufferedImage (32, 64, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) bf.createGraphics();
		g2d.setColor(randColor);
		g2d.fillRect(0, 15, 64, 4);
		return bf;
	}

	@Override
	public void update() {
		ticks++;
		
		if (ticks == tickspeed) {
			ticks = 0;
			unitMove(30);
		}
	}
}
