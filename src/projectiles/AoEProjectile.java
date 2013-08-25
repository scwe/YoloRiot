package projectiles;

import interactions.SimpleDamage;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import map.Tile;
import model.Location;

public class AoEProjectile extends Projectile {
	
	public AoEProjectile(Location start, Location direction) {
		super(start, direction);
		moveStep = 0;
		attack = new SimpleDamage (3);
	}

	@Override
	public BufferedImage getSprite() {
		BufferedImage bf = new BufferedImage (Tile.TILE_WIDTH*2, Tile.TILE_HEIGHT*2, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) bf.createGraphics();
		g2d.fillRect(0, 0, Tile.TILE_WIDTH*2, Tile.TILE_HEIGHT*2);
		return bf;
	}

}
