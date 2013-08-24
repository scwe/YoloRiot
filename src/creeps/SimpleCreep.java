package creeps;

import java.awt.Graphics;

import model.AI;
import model.Creep;
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
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
