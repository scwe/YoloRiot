package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Hitbox {

	private int[] xpoints;
	private int[] ypoints;
	private int length;
	
	private int centreX;
	private int centreY;
	
	private boolean noRotation = true;
	Rectangle bounding;
	
	public Hitbox (int x, int y, int width, int height) {
		xpoints = new int[] {x, x + width, x + width, x, x + width};	
		ypoints = new int[] {y, y, y + height, y + height, y};
		length = 5;

		centreX = x + width/2;
		centreY = y + height/2;
		
		bounding = new Rectangle (x, y, width, height);
	}
	
	public void rotate (double angle) {
		double sin = Math.sin(angle);
		double cos = Math.cos(angle);
		
		double rotX; double rotY;

		for (int i = 0; i < length; i++) {
			xpoints[i] -= centreX;
			ypoints[i] -= centreY;
			
			rotX = xpoints[i] * cos - ypoints[i] * sin;
			rotY = xpoints[i] * sin - ypoints[i] * cos;
			
			xpoints[i] = (int) rotX + centreX;
			xpoints[i] = (int) rotY + centreY;
		}
	}
	
	public boolean intersects (Hitbox other) {
		if (!bounding.intersects(other.bounding)) return false;
		if (noRotation && other.noRotation && bounding.intersects(other.bounding)) return true;
		
		for (int i=0; i < length; i++) {
			for (int j=0; j < other.length; j++) {
				if (lineIntersection(xpoints[i], ypoints[i], xpoints[i+1], ypoints[i+1], other.xpoints[j], other.ypoints[j], other.xpoints[j+1], other.ypoints[j+1])) return true;
			}
		}
		return false;		
	}
	
	public void move (int x, int y) {
		for (int i=0; i < length; i++) {
			xpoints[i] += x;
			ypoints[i] += y;
		}
		
		centreX += x;
		centreY += y;
		bounding.translate(x, y);		
	}
	
	private boolean lineIntersection (int ax1, int ay1, int ax2, int ay2, int bx1, int bx2, int by1, int by2) {
		int px = Math.min(ax1, ax2);
		int py = Math.min(ay1, ay2);
		int rx = Math.abs(ax2 - ax1);
		int ry = Math.abs(ay2 - ay1);
		
		int qx = Math.min(bx1, bx2);
		int qy = Math.min(by1, by2);
		int sx = Math.abs(bx2 - bx1);
		int sy = Math.abs(by2 - by1);
		
		// potential div/0.
		double t = ((qx - px)*sy - (qy - py)*sx) / (rx*sy - ry*sx);
		double u = ((qx - px)*ry - (qy - py)*rx) / (rx*sy - ry*sx);
		
		return t >= 0 && u >= 0 && t <= 1 && u <= 1;
	}	
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(bounding.x, bounding.y, bounding.width, bounding.height);
	}
}
