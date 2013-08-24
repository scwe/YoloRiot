package model;

import java.awt.Image;

public interface Entity {
	public void interact (Interaction i);
	public void update ();
	public Location getLocation();
	public Image getSprite ();
}
