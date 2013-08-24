package image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public BufferedImage getImage(String name) {

		BufferedImage img;
			try{
				img = ImageIO.read(ImageLoader.class.getResource("/images/"+name)); 
			}catch (IOException e){ throw new Error(e); }

		
		return img;
	}

}
