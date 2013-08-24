package creeps;

import model.Location;
import ais.AI;
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

}
