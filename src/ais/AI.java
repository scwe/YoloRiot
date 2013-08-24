package ais;

import model.Action;
import model.Location;

public interface AI {
	public Action getNext (Location l);
}
