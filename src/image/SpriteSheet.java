package image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Random;

public class SpriteSheet {

	private int x;
	private int y;
	private int spriteWidth;
	private int spriteHeight;
	private BufferedImage image;
	private HashMap<Integer, BufferedImage> storedMove = new HashMap<Integer,BufferedImage>();
	
	public SpriteSheet(int x, int y, int spriteWidth, int spriteHeight, String filename){
		this.x = x;
		this.y = y;
		this.spriteHeight = spriteHeight;
		this.spriteWidth = spriteWidth;

		
		ImageLoader imLoad = new ImageLoader();
		image = imLoad.getImage(filename);
	
	}

	
	public BufferedImage getImage(){
		if(storedMove.containsKey(x)){
			return storedMove.get(x);
		}
		
		BufferedImage im =  image.getSubimage(x*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight);
		storedMove.put(x,im);
		return im;
	}
	
	public BufferedImage getImage(int x, int y, int width, int height){
		if(storedMove.containsKey(x)){
			return storedMove.get(x);
		}
		
		BufferedImage im =  image.getSubimage(x, y, width, height);
		storedMove.put(x,im);
		return im;

	}
	
	public BufferedImage getImage(String val){
		int xVal = 0;
		if (val.equals("RIGHT")){
			xVal = 3;
		}
		else if (val.equals("LEFT")){
			xVal = 0;
		}
		else if (val.equals("TOP")){
			xVal = 1;
		}
		else if (val.equals("BOTTOM")){
			xVal = 2;
		}
		return image.getSubimage(xVal*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight);

	}
	
	public BufferedImage getImage(int val){
		
		return image.getSubimage(val*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight);

	}
	
	public BufferedImage getRandomImage(){
		Random r = new Random();
		int choice = (int)(r.nextDouble()*getWidth());
		return image.getSubimage(choice*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight);
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
	 * The width of the sprite sheet, i.e. how many sprites there are in the row
	 * @return
	 */
	public int getWidth(){
		return image.getWidth()/spriteWidth;
	}
	
	public int getHeight(){
		return image.getHeight()/spriteHeight;
	}
	
	

}
