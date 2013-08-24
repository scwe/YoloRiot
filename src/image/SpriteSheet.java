package image;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private int x;
	private int y;
	private int width;
	private int height;
	
	private BufferedImage image;
	
	public SpriteSheet(int x, int y, int width, int height, String filename){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		try {
			image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			//e.printStackTrace();  TODO unsilence this please
		}
	}
	
	public Image getImage(){
		return image.getSubimage(x*width, y*height, width, height);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth(){
		return width;
	}
	public void setWidth(int width){
		this.width = width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int height){
		this.height = height;
	}

}
