package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private static final int LANES = 10;
	
	private List<Creep> creeps;
	private List<Structure> structures;
	private List<Projectile> projectiles;
	
	private List<List<Entity>> lanes;
	
	public Model () {
		creeps = new ArrayList<Creep> ();
		structures = new ArrayList<Structure> ();
		lanes = new ArrayList<List<Entity>> ();
		for (int i=0; i < LANES; i++) {
			lanes.add(new ArrayList<Entity> ());
		}
	}

	public List<Entity> getLane (int i) {
		return lanes.get(i);
	}
	
	// update the data 
	public void tick () {
		for (Creep c : creeps) {
			c.update ();		
		}
		
		for (Structure s : structures) {
			s.update ();
		}
		
		for (Projectile p : projectiles) {
			p.update();
		}
	}
	
	public void draw (Graphics g) {
		for (Creep c : creeps) {
			c.draw (g);	
		}
		
		for (Structure s : structures) {
			s.draw (g);
		}
		
		for (Projectile p : projectiles) {
			p.draw (g);
		}		
	}
	
	
}
