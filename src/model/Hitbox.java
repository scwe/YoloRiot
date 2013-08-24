package model;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * hitboxes are centered on the object, so the 'middle' of the object
 * is considered (0, 0) for the hithbox.
 * 
 * @author Tony
 */
public class Hitbox{
	public enum Type {RECT, POLY};
	
	public final Type hitboxtype;
	
	private Polygon polygon;
	private Rectangle rect;
	
	public Hitbox (Polygon poly) {
		this.polygon = poly;
		hitboxtype = Type.POLY;
	}
	
	public Hitbox(Rectangle r){
		this.rect = r;
		hitboxtype = Type.RECT;
	}
	
	public Hitbox(int x, int y, int width, int height){
		//int[] xPoints = {x, x+ width, x + width, x};
		//int[] yPoints = {y, y, y + height, y + height};
		//polygon = new Polygon(xPoints, yPoints, xPoints.length);
		rect = new Rectangle (x, y, width, height);		
		hitboxtype = Type.RECT;
	}
	
	public Polygon getPoly () {
		return polygon;
	}
	
	public Rectangle getRect () {
		return rect;
	}
	
	public boolean intersects (Hitbox other) {
		if (other.hitboxtype == Type.RECT && hitboxtype == Type.RECT) {
			return rect.intersects(other.rect);
		} else if (other.hitboxtype == Type.POLY && hitboxtype == Type.RECT) {
			return other.polygon.intersects((Rectangle2D) rect);
		} else if (other.hitboxtype == Type.RECT && hitboxtype == Type.POLY) {
			return polygon.intersects((Rectangle2D) other.rect);
		} else {
			return intersectsPoly (other);
		}
	}
	
	public boolean intersectsPoly (Hitbox other) {
		Polygon otherP = other.getPoly ();
		
		for (int i=0; i < polygon.xpoints.length - 1; i++) {
			for (int j=0; j < otherP.xpoints.length - 1; j++) {
				if (lineIntersection(polygon.xpoints[i], polygon.ypoints[i], polygon.xpoints[i+1], polygon.ypoints[i+1], otherP.xpoints[j], otherP.ypoints[j], otherP.xpoints[j+1], otherP.ypoints[j+1])) return true;
			}
			if (lineIntersection (polygon.xpoints[i], polygon.ypoints[i], polygon.xpoints[i+1], polygon.ypoints[i+1], otherP.xpoints[0], otherP.ypoints[0], otherP.xpoints[otherP.xpoints.length - 1], otherP.ypoints[otherP.xpoints.length - 1])) return true;
		}
		if (lineIntersection (polygon.xpoints[0], polygon.ypoints[0], polygon.xpoints[polygon.xpoints.length-1], polygon.ypoints[polygon.xpoints.length-1], otherP.xpoints[0], otherP.ypoints[0], otherP.xpoints[otherP.xpoints.length - 1], otherP.ypoints[otherP.xpoints.length - 1])) return true;
		return false;		
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
	
	public void moveHitbox(int x, int y){
		polygon.translate(x, y);
	}
	
	
	public void draw(Graphics g){
		if (hitboxtype == Type.RECT) g.drawRect(rect.x, rect.y, rect.width, rect.height); 
		else g.drawPolygon(polygon);
	}
}