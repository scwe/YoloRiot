package playerAbilities;

import model.Location;
import model.Model;
import projectiles.Projectile;
import projectiles.PiercingProjectile;

public class PiercingShot extends Ability {

	public PiercingShot () {
		maxCooldown = 50;
		yoloMaxCooldown = (4 - Model.model.powerupcount) * 3;
	}
	
	@Override
	public void activate (int fromX, int fromY, int targetX, int targetY) {
		Projectile p = new PiercingProjectile(new Location(fromX, fromY), new Location(targetX, targetY));
		Model.model.projectiles.add(p);
	}
}