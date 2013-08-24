package playerAbilities;

import model.Location;
import model.Model;
import projectiles.Projectile;
import projectiles.SimpleProjectile;

public class SimpleShoot implements Ability {

	@Override
	public void use(int fromX, int fromY, int targetX, int targetY) {
		Projectile p = new SimpleProjectile(new Location(fromX, fromY), new Location(targetX, targetY));
		Model.model.projectiles.add(p);
	}
}