package model;

import gui.SoundFactory;
import gui.YoloMouse;
import gui.YoloRiot;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import map.Map;
import map.Tile;
import playerAbilities.Ability;
import playerAbilities.InstantAoE;
import playerAbilities.PiercingShot;
import playerAbilities.WeakFastFire;
import projectiles.Projectile;
import projectiles.YoloBolt;
import structures.PowerUp;
import structures.SimpleCannon;
import structures.SimpleWall;
import structures.Structure;
import structures.Yolostone;
import creeps.Creep;
import creeps.HomingCreep;
import creeps.RandomCreep;
import creeps.SimpleCreep;

public class Model {
	private static final int FIELD_WIDTH = Map.MAP_WIDTH*Tile.TILE_WIDTH;
	private static final int FIELD_HEIGHT = Map.MAP_HEIGHT*Tile.TILE_HEIGHT;
	private static final int YOLO_TOTAL_SIZE = 300;
	private static final int YOLO_TICKWAVE_SIZE = 10;
	private static final int MONEY_INC = 10;
	private static final int DROP_AT_THIS = 100;
	
	private static final int CANNON_COST = 300;
	private static final int CANNON_TRI_COST = 500;
	private static final int WALL_COST = 100;
	private static final int WALL_SPIKE_COST = 200;
	
	private int dropcount = 0;
	private int nextDrop;
	public static int powerupcount = 0;
	
	public static Model model;
	
	public List<Creep> creeps;
	public List<Structure> structures;
	public List<Projectile> projectiles;
	public PowerUp curPowerUp;
	
	public static Ability[] abilities = {new PiercingShot (), new InstantAoE (), new WeakFastFire()};
	private boolean mousePressed = false;
	
	public int money = 200;
	
	private Yolostone yolostone;
	
	public double yolospeed = 1.0;
	public boolean yolomode = false;
	public int yoloWaveLeft = YOLO_TOTAL_SIZE;
	
	public Player player;
	private int homingTick = 0;
	private int waveDifficulty = 3;
	private int waveTick = 200;
	private int tick = 0;
	private int waveTickSpeed = 20;
	
	private YoloRiot riot;
	public List<Pt> pts = new ArrayList<Pt> ();
	
	public Model (YoloRiot parent) {
		this.riot = parent;
		model = this;
		player = new Player();
		creeps = new ArrayList<Creep> ();
		structures = new ArrayList<Structure> ();
		projectiles = new ArrayList<Projectile>();
		yolostone = new Yolostone ();
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
		
		for (Ability a : abilities) 
			a.cooldown();		
		
		if (mousePressed) {
			playerShoot(YoloMouse.mouseX, YoloMouse.mouseY);
		}
		
		
		if (yolostone.health == 0 || player.health == 0) {
			riot.lost = true;
		}
		
		if (yoloWaveLeft <= 0 && creeps.size() == 0) {
			riot.won = true;
		}
		
		if (tick > waveTick){
			if (yolomode) yoloCreeps (); 
			else makeCreeps ();
			tick = 0;
		}
		
		tick++;
		
		if (curPowerUp != null && player.getHitbox().intersects(curPowerUp.hitbox)) {
			curPowerUp = null;
			powerupcount++;
		}
		
		if (yolomode && Math.random() >= 0.1) {
			int laneLoc = (int)((Math.random())*10);
			Location l = new Location (0, laneLoc * Tile.TILE_HEIGHT);
			Location l2 = new Location (10, laneLoc * Tile.TILE_HEIGHT);
			projectiles.add(new YoloBolt(l, l2));
			
			laneLoc = (int)((Math.random())*10);
			l = new Location (0, laneLoc * Tile.TILE_HEIGHT);
			l2 = new Location (10, laneLoc * Tile.TILE_HEIGHT);
			projectiles.add(new YoloBolt(l, l2));
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
		
		yolostone.draw(g);
		
		for (Pt pt : pts)
			pt.draw(g);
		
		if (curPowerUp != null) curPowerUp.draw(g);
		
		player.draw(g);
	}
	
	private void makeCreeps () {
		double creepNo = Math.abs(Math.sin(tick)*20);
		
		int end = Map.MAP_WIDTH * Tile.TILE_WIDTH;
		int laneHeight = Tile.TILE_HEIGHT;
		homingTick++;
		for (int i = 0 ; i < creepNo; i++){
			int laneLoc = (int)((Math.random())*10);
			creeps.add(new SimpleCreep (new Location(end, laneLoc * laneHeight)));
			laneLoc = (int)((Math.random())*10);
			laneLoc = (int)((Math.random())*10);
			if(homingTick > 1){
				creeps.add(new HomingCreep (new Location(end, laneLoc * laneHeight)));
				homingTick = 0;
			}
		}
	}
	
	private void yoloCreeps () {		
		int end = Map.MAP_WIDTH * Tile.TILE_WIDTH;
		int laneHeight = Tile.TILE_HEIGHT;
		if (yoloWaveLeft < 0) return;
		homingTick++;
		for (int i = 0 ; i < YOLO_TICKWAVE_SIZE; i++){
			int laneLoc = (int)((Math.random())*10);
			creeps.add(new SimpleCreep (new Location(end, laneLoc * laneHeight)));
			laneLoc = (int)((Math.random())*10);
			creeps.add(new RandomCreep (new Location(end, laneLoc+1 * laneHeight), 8));
			if(homingTick > 1){
				laneLoc = (int)((Math.random())*10);
				creeps.add(new HomingCreep (new Location(end, laneLoc * laneHeight)));
				homingTick = 0;
			}
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

		if (hitbox.intersects(yolostone.getHitbox())) intersects.add(yolostone);
		
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
		
		if (hitbox.intersects(yolostone.getHitbox())) intersects.add(yolostone);
		
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
			if (yolomode) yoloWaveLeft--;
			else { // random chance of getting a yolo power
				if (dropcount >= nextDrop && powerupcount <= 3) {
					curPowerUp = new PowerUp (new Location(e.getLocation().x, e.getLocation().y));
					dropcount = 0;
					nextDrop = DROP_AT_THIS + (int)(Math.random()*DROP_AT_THIS/4);
				}
			}
			money += MONEY_INC;
		} else if (e instanceof Structure) {
			structures.remove(e);
		} else if (e instanceof Projectile) {
			projectiles.remove(e);
		}
	}	
	
	public void addStructure (Location l, int buttonnum) {
		SoundFactory.playSound("audio/coin2.wav");
		if (buttonnum == 0 && money > CANNON_COST) {
			structures.add(new SimpleCannon(l));
			money -= CANNON_COST;
		} else if (buttonnum == 1 && money > WALL_COST) {
			structures.add(new SimpleWall(l));
			money -= WALL_COST;
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
		waveTick = 50;
	}
}
