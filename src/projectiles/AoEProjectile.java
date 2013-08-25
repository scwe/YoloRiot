package projectiles;

import gui.SoundFactory;
import image.SpriteSheet;
import interactions.SimpleDamage;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Set;

import map.Tile;
import model.Entity;
import model.Location;
import model.Model;

public class AoEProjectile extends Projectile {
	private static final int UPDATES_TO_DEAD = 10;
	private int deadCounter = 0;
	private SpriteSheet image;
		
	public AoEProjectile(Location start, Location direction) {
		super(start, direction);
		moveStep = 0;
		
		attack = new SimpleDamage (3);
		tickspeed = 30;
		SoundFactory.playSound("audio/lightning.wav");
	}

	@Override
	public void update() {
		ticks++;
		
		if (ticks == tickspeed) {
			ticks = 0;
			
			Set<? extends Entity> es;
			if (friendly) es = Model.model.intersectsCreeps(hitbox);
			else es = Model.model.intersectsFriendly(hitbox);
			
			unitMove(moveStep);
			
			for (Entity e : es) {
				e.interact(attack);
			}
			
			deadCounter ++;
			if (deadCounter == UPDATES_TO_DEAD) {
				Model.model.killEntity(this);
			}
		}
	}
	
	@Override
	public BufferedImage getSprite() {
		BufferedImage bf = new BufferedImage (Tile.TILE_WIDTH*2, Tile.TILE_HEIGHT*2, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) bf.createGraphics();
		g2d.fillRect(0, 0, Tile.TILE_WIDTH*2, Tile.TILE_HEIGHT*2);
		return image.getImage(0, 0, 128, 128);
	}

	@Override
	public void initialiseSpriteSheet() {
		image = new SpriteSheet(0,0,128,128, "storm_aoe.png");
		
	}
}
