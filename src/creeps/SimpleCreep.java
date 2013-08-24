package creeps;

import java.awt.Graphics;
import java.awt.Image;

import model.AI;
import model.Creep;
import model.Interaction;
import model.Location;
import ais.SimpleCreepAI;

public class SimpleCreep extends Creep {

	public SimpleCreep(Location l) {
		super(l);
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return null;
	}

}
