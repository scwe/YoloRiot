package model;

import interactions.Interaction;

import java.awt.Graphics;
import java.awt.Image;

public interface Entity {
	
	public void interact (Interaction i);
	public void update ();
	public void draw (Graphics g);
	
	public void move (int x, int y);
	public void reduceHealth(int amount);
	
	public Location getLocation();
	public Image getSprite ();
	public Hitbox getHitbox();
}
