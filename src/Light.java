import java.awt.*;

import map.Location;

import javax.imageio.ImageIO;
import java.io.*;


public class Light {
	private Image image;
	
	
	public Light(Location l, String image){
		try {
			this.image = ImageIO.read(new File(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void draw(Graphics g){
    	
    }
}