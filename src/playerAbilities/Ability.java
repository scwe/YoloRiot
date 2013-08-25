package playerAbilities;

import model.Model;

public abstract class Ability {	
	protected int maxCooldown = 50;
	protected int yoloMaxCooldown = 5;
	
	protected int cooldown = maxCooldown;
	
	public void use (int fromX, int fromY, int targetX, int targetY) {
		if (cooldown == 0) {
			cooldown = Model.model.yolomode ? yoloMaxCooldown : maxCooldown;
			activate (fromX, fromY, targetX, targetY);
		}
	}
	
	protected abstract void activate (int fromX, int fromY, int targetX, int targetY);
	
	public void cooldown () {
		if (cooldown == 0) return;
		cooldown--; 
	}
}
