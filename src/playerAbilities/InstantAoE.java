package playerAbilities;

import model.Location;
import model.Model;
import projectiles.AoEProjectile;
import projectiles.Projectile;

public class InstantAoE extends Ability {
	
	public InstantAoE () {
		maxCooldown = 50;
		yoloMaxCooldown = (4 - Model.model.powerupcount) * 3;
	}
	
	@Override
	protected void activate(int fromX, int fromY, int targetX, int targetY) {
		Projectile p = new AoEProjectile(new Location(targetX, targetY), new Location(targetX, targetY));
		Model.model.projectiles.add(p);
	}
}
