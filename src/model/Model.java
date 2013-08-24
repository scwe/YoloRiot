package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private List<Creep> creeps;
	private List<Structure> structures;
	
	
	public Model () {
		creeps = new ArrayList<Creep> ();
		structures = new ArrayList<Structure> ();
	}
	
	// update the data 
	public void tick () {
		for (Creep c : creeps) {
			c.update ();		
		}
		
		for (Structure s : structures) {
			s.update ();
		}
	}
	
	
}
