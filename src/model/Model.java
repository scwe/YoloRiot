package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private List<Creep> creeps;
	private List<Structure> structures;
	private List<Projectile> projectiles;
	
	
	
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
