package playerAbilities;

import model.Location;
import model.Model;
import projectiles.Projectile;
import projectiles.WeakProjectile;

public class WeakFastFire extends Ability {
	
	public WeakFastFire () {
		maxCooldown = 20;
		yoloMaxCooldown = (4 - Model.model.powerupcount) * 5;
	}
	
	@Override
	public void activate (int fromX, int fromY, int targetX, int targetY) {
		Projectile p = new WeakProjectile(new Location(fromX, fromY), new Location(targetX, targetY));
		Model.model.projectiles.add(p);
	}
}
