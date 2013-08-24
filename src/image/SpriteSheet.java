package image;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import map.Tile;

public class SpriteSheet {

	private int x;
	private int y;
	private int spriteWidth;
	private int spriteHeight;
	
	private ArrayList<BufferedImage> sheets;
	private ArrayList<BufferedImage> edgeTiles;
	private ArrayList<BufferedImage> groundTiles;
	
	
	
	public SpriteSheet(int x, int y, int spriteWidth, int spriteHeight, ArrayList<String> filenames){
		this.x = x;
		this.y = y;
		this.spriteHeight = spriteHeight;
		this.spriteWidth = spriteWidth;
		sheets = new ArrayList<BufferedImage>();
		
		ImageLoader imLoad = new ImageLoader();
		for (int i = 0; i < filenames.size(); i++){
			sheets.add(imLoad.getImage(filenames.get(i)));
		}
		
	
	}
	
	public Image getImage(int sheet){
		
		
		return null;
		
	}
	
	
	public Image getImage(){
		return sheets.get(0).getSubimage(x*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight);
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
	
	public int getSpriteWidth(){
		return spriteWidth;
	}
	public void setSpriteWidth(int width){
		this.spriteWidth = width;
	}
	
	public int getSpriteHeight(){
		return spriteHeight;
	}
	
	public void setSpriteHeight(int height){
		this.spriteHeight = height;
	}
	
	/**
	 * The width of the sprtie sheet, i.e. how many sprites there are in the row
	 * @return
	 */
	public int getWidth(){
		return sheets.get(0).getWidth()/spriteWidth;
	}
	
	public int getHeight(){
		return sheets.get(0).getHeight()/spriteHeight;
	}

}
