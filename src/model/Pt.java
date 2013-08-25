package model;

import java.awt.Color;
import java.awt.Graphics;

public class Pt {
	int x;
	int y;
	
	public Pt (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw (Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x-4, y-4, 8, 8);
	}
}
