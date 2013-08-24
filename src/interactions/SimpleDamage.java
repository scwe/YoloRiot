package interactions;

import model.Entity;
import model.Interaction;

public class SimpleDamage extends Interaction {
	public final int amount;
	
	public SimpleDamage (int amount) {
		this.amount = amount;
	}

	@Override
	public void apply(Entity e) {
		e.reduceHealth (10);		
	}
}
