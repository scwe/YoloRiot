package playerAbilities;

public abstract class Ability {
	private static final int MAX_COOLDOWN = 50;
	protected int cooldown = MAX_COOLDOWN;
	
	public void use (int fromX, int fromY, int targetX, int targetY) {
		if (cooldown == 0) {
			cooldown = MAX_COOLDOWN;
			activate (fromX, fromY, targetX, targetY);
		}
	}
	
	protected abstract void activate (int fromX, int fromY, int targetX, int targetY);
	
	public void cooldown () {
		if (cooldown == 0) return;
		cooldown--; 
	}
}
