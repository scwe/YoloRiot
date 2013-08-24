package creeps;

import image.ImageLoader;
import interactions.Interaction;
import interactions.SimpleDamage;

import java.awt.image.BufferedImage;

import model.Location;
import model.Model;
import creepAIs.CreepAI;
import creepAIs.SimpleCreepAI;

public class SimpleCreep extends Creep {
	private final Interaction attack = new SimpleDamage (5);
	
	public SimpleCreep(Location location) {
		super(location);
		tickspeed = 25;
	}

	@Override
	protected CreepAI makeAI() {
		return new SimpleCreepAI ();
	}

	@Override
	public void interact(Interaction i) {
		Model.model.killEntity(this);
	}

	@Override
	public BufferedImage getSprite() {
		if (image == null || attackingImage == null){
			ImageLoader il = new ImageLoader();
			image = il.getImage("CREEP1.png");
			attackingImage = il.getImage("CREEP1_ATTACKING.png");
			return image;
		}
		if (this.state == CreepState.ATTACKING)
			return attackingImage;
		return image;

	}


}
