package structures;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import map.Tile;
import model.Location;
import structureAIs.NullAI;
import structureAIs.StructureAI;

public class PowerUp extends Structure {

	public PowerUp(Location location) {
		super(location);
	}

	@Override
	protected StructureAI makeAI() {
		return new NullAI();
	}

	@Override
	public BufferedImage getSprite() {
		BufferedImage bf = new BufferedImage (32, 32, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) bf.createGraphics();
		g2d.fillRect(0, 0, 32, 32);
		return bf;
	}

	@Override
	public void fire() {
	}

}
