package model;

import java.util.ArrayList;
import java.util.List;

import structures.Structure;
import creeps.Creep;

public class Model {
	
	List<Creep> creeps;
	List<Structure> structures;
	
	public Model () {
		creeps = new ArrayList<Creep> ();
		structures = new ArrayList<Structure> ();
	}
	
	public void draw () {
	
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
