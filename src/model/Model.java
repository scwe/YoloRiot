package model;

import gui.YoloMouse;
import interactions.Interaction;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import map.Map;
import map.Tile;
import playerAbilities.Ability;
import playerAbilities.SimpleShoot;
import projectiles.Projectile;
import structures.SimpleCannon;
import structures.SimpleWall;
import structures.Structure;
import structures.Yolostone;
import creeps.Creep;
import creeps.RandomCreep;
import creeps.SimpleCreep;

public class Model {
	private static final int FIELD_WIDTH = Map.MAP_WIDTH*Tile.TILE_WIDTH;
	private static final int FIELD_HEIGHT = Map.MAP_HEIGHT*Tile.TILE_HEIGHT;
	
	public static Model model;
	
	public List<Creep> creeps;
	public List<Structure> structures;
	public List<Projectile> projectiles;
	
	public static Ability[] abilities = {new SimpleShoot ()};
	private boolean mousePressed = false;
	
	private Yolostone[] yolostones;
	private int destroyed = 0;
	
	public double yolospeed = 1.0;
	public boolean yolomode = false;
	
	public Player player;
	
	private int waveDifficulty = 3;
	private int waveTick = 200;
	private int tick = 0;
	private int waveTickSpeed = 20;
	
	public List<Pt> pts = new ArrayList<Pt> ();
	
	public Model () {
		model = this;
		player = new Player();
		creeps = new ArrayList<Creep> ();
		structures = new ArrayList<Structure> ();
		projectiles = new ArrayList<Projectile>();
		yolostones = new Yolostone[Map.MAP_HEIGHT];
		for (int i=0; i < Map.MAP_HEIGHT; i++) {
			yolostones[i] = new Yolostone (i);
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
		
		for (Ability a : abilities) 
			a.cooldown();		
		
		if (mousePressed) {
			System.out.println ("(" + YoloMouse.mouseX + ", " + YoloMouse.mouseY + ")");
			playerShoot(YoloMouse.mouseX, YoloMouse.mouseY);
		}
		
		
		if (destroyed == Map.MAP_HEIGHT) {
			// FIXME Lose.
		}
		if (tick > waveTick){
			makeCreeps ();
			tick = 0;
		}
		tick++;
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
		
		for (Pt pt : pts)
			pt.draw(g);
		
		player.draw(g);
	}
	
	private void makeCreeps () {
		double creepNo = Math.abs(Math.sin(tick)*20);

		int end = Map.MAP_WIDTH * Tile.TILE_WIDTH;
		int laneHeight = Tile.TILE_HEIGHT;
		int numLanes = Map.MAP_HEIGHT;

		for (int i = 0 ; i < creepNo; i++){
			int laneLoc = (int)((Math.random())*10);
			creeps.add(new SimpleCreep (new Location(end, laneLoc * laneHeight)));
			creeps.add(new RandomCreep (new Location(end, laneLoc * laneHeight), 8));
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
	
	public Set<Structure> inersectsStructures (Hitbox hitbox) {
		Set<Structure> intersects = new HashSet<Structure> ();
		
		for (Structure s : structures) {
			if (hitbox.intersects(s.getHitbox())) intersects.add(s);
		}

		return intersects;		
	}
	
	public Set<Creep> intersectsCreeps (Hitbox hitbox) {
		Set<Creep> intersects = new HashSet<Creep> ();
		
		for (Creep c : creeps) {
			if (hitbox.intersects(c.getHitbox())) intersects.add(c);
		}

		return intersects;		
	}
	
	public boolean intersectsPlayer (Hitbox hitbox) {
		return player.hitbox.intersects(hitbox);
	}
	

	public Set<Entity> intersectsFriendly(Hitbox hitbox) {
		Set<Entity> intersects = new HashSet<Entity> ();
		
		for (Structure s : structures) {
			if (hitbox.intersects(s.getHitbox())) intersects.add(s);
		}
		
		if (player.getHitbox().intersects(hitbox)) intersects.add(player);
		
		return intersects;	
	}
	
	private void playerShoot (int endX, int endY) {
		int startX = -1;
		int startY = -1;
		
		if (player.curDirection == Direction.NORTH) {
			startX = player.getLocation().x + player.CHARACTER_WIDTH/2;
			startY = player.getLocation().y;
		} else if (player.curDirection == Direction.EAST) {
			startX = player.getLocation().x + player.CHARACTER_WIDTH;
			startY = player.getLocation().y + player.CHARACTER_HEIGHT/2;
		} else if (player.curDirection == Direction.SOUTH) {
			startX = player.getLocation().x + player.CHARACTER_WIDTH/2;
			startY = player.getLocation().y + player.CHARACTER_HEIGHT;			
		} else if (player.curDirection == Direction.WEST) {
			startX = player.getLocation().x;
			startY = player.getLocation().y + player.CHARACTER_HEIGHT/2;
		}
		
		player.curAbility.use(startX, startY, endX, endY);
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
			structures.add(new SimpleCannon(l));
		} else if (buttonnum == 1) {
			structures.add(new SimpleWall(l));
		}
	}

	private boolean outOfBounds (Entity e) {
		Location l = e.getLocation();
		return !(l.x >= 0 && l.y >= 0 && l.x <= FIELD_WIDTH && l.y <= FIELD_HEIGHT);
	}
	
	public void addStructure(Structure s){
		structures.add(s);
	}

	public void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	public void mousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}

	public void FULLYOL0() {
		yolomode  = true;
		yolospeed = 0.5;
		player.speed *= 2;
	}
}
