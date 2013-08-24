package image;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageLoader {
	
	public Image getImage(String path){
		
		Image bg = new ImageIcon(getClass().getResource(path)).getImage();
		
		return bg;
	}

}
