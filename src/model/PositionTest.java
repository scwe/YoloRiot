package model;

import java.awt.Color;
import java.awt.Graphics;

public class PositionTest {
	public int x;
	public int y;

	public PositionTest (int x, int y) {
		this.x = x; this.y = y;
	}
	
	public void draw (Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x-5, y-5, 10, 10);
	}
}
