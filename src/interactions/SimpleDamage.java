package interactions;

import model.Interaction;

public class SimpleDamage extends Interaction {
	public final int amount;
	
	public SimpleDamage (int amount) {
		this.amount = amount;
	}
}
