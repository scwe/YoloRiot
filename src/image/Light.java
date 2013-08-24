package image;

import java.awt.image.BufferedImage;
import java.awt.*;

import map.Location;

public class Light {

	private SpriteSheet image;
	private Location l;
	private int width;
	private int height;
	
	private int count = 0;
	private int tickCount = 0;

	public Light(Location l, String image, int width, int height) {
		this.l = l;
		this.image = new SpriteSheet(0, 0, width, height, image);
		this.width = width;
		this.height = height;
	}

	public void draw(BufferedImage bImage) {

		for (int h = l.getY(); h < l.getY() + height; h++) {
			for (int w = l.getX(); w < l.getX() + width; w++) {
				Color pixel = new Color(bImage.getRGB(w, h));
				image.setX(count);
				Color light = new Color(image.getImage().getRGB(w - l.getX(), h - l.getY()));
				
				int red = pixel.getRed() + light.getRed();
				int green = pixel.getGreen() + light.getGreen();
				int blue = pixel.getBlue() + light.getBlue();
				
				if(red > 255){
					red = 255;
				}
				if(green > 255){
					green = 255;
				}
				if(blue > 255){
					blue = 255;
				}
				
				Color newColor = new Color(red, green, blue);
				
				bImage.setRGB(w, h, newColor.getRGB());
			}
		}
		tickCount++;
		
		if(tickCount >= 10){
			count++;
			
			if(count >= image.getWidth()){
				count = 0;
			}
			
			tickCount = 0;
		}
	}
	
	
	
	
	
}