package image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;



public class ImageLoader {

	
	
	static HashMap<String,BufferedImage> storage = new HashMap<String,BufferedImage>();
	public BufferedImage getImage(String name) {

		if (storage.containsKey(name)){
			return storage.get(name);
		}
		BufferedImage img;
			try{
				img = ImageIO.read(ImageLoader.class.getResource("/images/"+name)); 
			}catch (IOException e){ throw new Error(e); }

		storage.put(name,img);
		return img;
	}
	
	public BufferedImage getImage(String name, int loc){
		
		if (storage.containsKey(name)){
			return storage.get(name);
		}
		BufferedImage img;
		try{
			img = ImageIO.read(ImageLoader.class.getResource("/images/"+name)); 
		}catch (IOException e){ throw new Error(e); }

		storage.put(name,img);
		return img;
		
	}

}
