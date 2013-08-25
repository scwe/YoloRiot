package creepAIs;

import model.Location;
import model.Model;
import model.Player;
import creeps.Creep;

public class HomingCreepAI implements CreepAI {
	State last;
	public double MOVEMENT = 3;
	
	@Override
	public void next(Creep c) {
		
		Player p = Model.model.player;
		Location foundLoc = new Location(c.getLocation().x - 10, c.getLocation().y);
		int dir = 0;
		double minDistance = distance(p.getLocation(),foundLoc);
		Location rightLoc = new Location(c.getLocation().x + 10, c.getLocation().y);
		double distance = distance(p.getLocation(),rightLoc);
		if (distance < minDistance){
			minDistance = distance;
			dir = 1;
		}
		Location topLoc = new Location(c.getLocation().x, c.getLocation().y-10);
		distance = distance(p.getLocation(),topLoc);
		if (distance < minDistance){
			minDistance = distance;
			dir = 2;
		}
		Location botLoc = new Location(c.getLocation().x - 10, c.getLocation().y+10);
		distance = distance(p.getLocation(),botLoc);
		if (distance < minDistance){
			minDistance = distance;
			dir = 3;
		}
		switch (dir){
			
			case 0:
				c.move((int)(MOVEMENT*-10),0);
				return;
			case 1:
				c.move((int)(MOVEMENT*10),0);
				return;
			case 2:
				c.move(0,(int)(MOVEMENT*-10));
				return;
			case 3:
				c.move(0,(int)(MOVEMENT*10));
				return;
		}
	}
	
	
	public double distance(Location p1, Location p2){
		
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
		
	}
}