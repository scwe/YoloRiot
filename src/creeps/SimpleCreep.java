package creeps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import model.AI;
import model.Creep;
import model.Interaction;
import model.Location;
import ais.SimpleCreepAI;

public class SimpleCreep extends Creep {

	public SimpleCreep(Location location) {
		super(location);
	}

	@Override
	protected AI makeAI() {
		return new SimpleCreepAI ();
	}

	@Override
	public void interact(Interaction i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Image getSprite() {
		Image i = new BufferedImage (32, 32, BufferedImage.TYPE_INT_ARGB);
		Graphics g = i.getGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 32, 32);
		return i;
	}
}
