package interactions;

import model.Entity;

public class SimpleDamage extends Interaction {
	public final int amount;
	
	public SimpleDamage (int amount) {
		this.amount = amount;
	}

	@Override
	public void apply(Entity e) {
		e.reduceHealth (5);		
	}
}
