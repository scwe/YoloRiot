package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import projectiles.SimpleProjectile;
import map.Map;
import map.Tile;
import creeps.SimpleCreep;

public class Model {
	
	private List<Creep> creeps;
	private List<Structure> structures;
	private List<Projectile> projectiles;
	
	private Player player;
	
	private int waveDifficulty = 3;
	private int waveTick = 0;
	private int waveTickSpeed = 1000;
	
	public Model () {
		player = new Player();
		creeps = new ArrayList<Creep> ();
		structures = new ArrayList<Structure> ();
		projectiles = new ArrayList<Projectile>();
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
		
		makeCreeps ();
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
	
	private void makeCreeps () {
		waveTick ++;
		if (waveTick != waveTickSpeed) return;
		waveTick = 0;		
		
		int end = Map.MAP_WIDTH * Tile.TILE_WIDTH;
		int laneHeight = Tile.TILE_HEIGHT;
		int numLanes = Map.MAP_HEIGHT;
		
		for (int i=0; i < waveDifficulty; i++) {
			int curLane = (i * 2) % numLanes;
			creeps.add(new SimpleCreep (new Location(end, curLane * laneHeight), this));
		}
	}
	
	public Set<Entity> intersects(Hitbox hitbox) {
		Set<Entity> intersects = new HashSet<Entity> ();
		
		for (Creep c : creeps) {
			if (c.getHitbox().intersects(hitbox)) intersects.add(c);
		}
		
		for (Structure s : structures) {
			if (s.getHitbox().intersects(hitbox)) intersects.add(s);
		}
		
		if (player.getHitbox().intersects(hitbox)) intersects.add(player);
		
		return intersects;
	}
	
	public void shoot (int endX, int endY) {
		int startX = player.getLocation().x;
		int startY = player.getLocation().y;

		Projectile p = new SimpleProjectile(new Location(startX, startY), new Location(endX, endY), this);
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void setPlayer(Player p){
		this.player = p;
	}	
}
