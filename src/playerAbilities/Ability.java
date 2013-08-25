package playerAbilities;

import gui.SoundFactory;
import model.Model;

public abstract class Ability {	
	protected int maxCooldown = 50;
	protected int yoloMaxCooldown = 5;
	
	protected int cooldown = maxCooldown;
	
	public void use (int fromX, int fromY, int targetX, int targetY) {
		if (cooldown == 0) {
			cooldown = Model.model.yolomode ? yoloMaxCooldown : maxCooldown;
			activate (fromX, fromY, targetX, targetY);
			int rand = (int)(Math.random()*3);
			if(rand < 1){
				SoundFactory.playSound("audio/phasers3.wav");
			}else if(rand < 2){
				SoundFactory.playSound("audio/you_suck.wav");
			}else{
				SoundFactory.playSound("audio/bird.wav");
			}
		}
	}
	
	protected abstract void activate (int fromX, int fromY, int targetX, int targetY);
	
	public void cooldown () {
		if (cooldown == 0) return;
		cooldown--; 
	}
}
