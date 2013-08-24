package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import map.Map;
import map.Tile;
import projectiles.SimpleProjectile;
import structures.SimpleCannon;
import structures.SimpleWall;
import creeps.SimpleCreep;

public class Model {
	private static final int FIELD_WIDTH = Map.MAP_WIDTH*Tile.TILE_WIDTH;
	private static final int FIELD_HEIGHT = Map.MAP_HEIGHT*Tile.TILE_HEIGHT;
	
	private List<Creep> creeps;
	private List<Structure> structures;
	private List<Projectile> projectiles;
	private Yolostone[] yolostones;
	private int destroyed = 0;
	
	private Player player;
	
	private int waveDifficulty = 3;
	private int waveTick = 0;
	private int waveTickSpeed = 10;
	boolean flag = false;
	
	public Model () {
		player = new Player();
		creeps = new ArrayList<Creep> ();
		structures = new ArrayList<Structure> ();
		projectiles = new ArrayList<Projectile>();
		yolostones = new Yolostone[Map.MAP_HEIGHT];
		for (int i=0; i < Map.MAP_HEIGHT; i++) {
			yolostones[i] = new Yolostone (i, this);
		}
	}
	
	// update the data 
	public void tick () {
		for (Creep c : creeps) {
			c.update ();		
		}
		
		for (Structure s : structures) {
			s.update ();
		}
		
		Projectile p;
		for (int i=0; i < projectiles.size(); i++) {
			p = projectiles.get(i);
			p.update();
			if (outOfBounds(p)) {
				killEntity(p);
				i--;
			}
		}
		
		for (Yolostone y : yolostones) {
			if (y.health < 10) {
				y.destroyed = true;
				destroyed++;
			}
		}
		
		if (destroyed == Map.MAP_HEIGHT) {
			// FIXME Lose.
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
		
		for (Yolostone y : yolostones) {
			y.draw(g);
		}
		
		player.draw(g);
	}
	
	private void makeCreeps () {
		if (flag) return;
		flag = true;
		waveTick ++;
		//if (waveTick != waveTickSpeed) return;
		waveTick = 0;		
		
		int end = Map.MAP_WIDTH * Tile.TILE_WIDTH;
		int laneHeight = Tile.TILE_HEIGHT;
		int numLanes = Map.MAP_HEIGHT;
		
		creeps.add(new SimpleCreep (new Location(end, 2 * laneHeight), this));
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
		projectiles.add(p);
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void setPlayer(Player p){
		this.player = p;
	}

	public void killEntity(Entity e) {
		if (e instanceof Creep) {
			creeps.remove(e);
		} else if (e instanceof Structure) {
			structures.remove(e);
		} else if (e instanceof Projectile) {
			projectiles.remove(e);
		}
	}	
	
	public void addStructure (Location l, int buttonnum) {
		if (buttonnum == 0) {
			structures.add(new SimpleCannon(l, this));
		} else if (buttonnum == 1) {
			structures.add(new SimpleWall(l, this));
		}
	}

	private boolean outOfBounds (Entity e) {
		Location l = e.getLocation();
		return !(l.x >= 0 && l.y >= 0 && l.x <= FIELD_WIDTH && l.y <= FIELD_HEIGHT);
	}

}
