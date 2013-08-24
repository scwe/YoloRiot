package creeps;

import image.ImageLoader;
import interactions.SimpleDamage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.AI;
import model.Creep;
import model.Interaction;
import model.Location;
import model.Model;
import ais.SimpleCreepAI;

public class SimpleCreep extends Creep {
	private final Interaction attack = new SimpleDamage (5);
	
	public SimpleCreep(Location location, Model model) {
		super(location, model);
		tickspeed = 25;
	}

	@Override
	protected AI makeAI() {
		return new SimpleCreepAI ();
	}

	@Override
	public void interact(Interaction i) {
		model.killEntity(this);
	}
	
	/*public void update() {
		Action a = ai.getNext (this);
		if (a.state == Action.State.ATTACK) {
			Entity attacking = a.interacting;
			attacking.interact(attack);
		} else if (a.state == Action.State.MOVE) {
			location.moveLeft (1);
		}
	}*/

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
