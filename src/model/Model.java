package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private static final int LANES = 10;
	
	private List<Creep> creeps;
	private List<Structure> structures;
	private List<Projectile> projectiles;
	
	private Player player;
	
	private List<List<Entity>> lanes;
 
	
	public Model () {
		player = new Player();
		creeps = new ArrayList<Creep> ();
		structures = new ArrayList<Structure> ();
		projectiles = new ArrayList<Projectile>();
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
		player.update();
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
		
		player.draw(g);
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void setPlayer(Player p){
		this.player = p;
	}
	
}
