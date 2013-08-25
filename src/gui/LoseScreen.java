package gui;

import image.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class LoseScreen extends JPanel {
	BufferedImage mainIm;
	ImageLoader imLoad;
	
	public LoseScreen(){
		imLoad = new ImageLoader();
		mainIm = imLoad.getImage("StartScreen.png");
	}

	@Override
    public void paintComponent(Graphics g){
		g.drawImage(mainIm,  0, 0, null);
	}

	public void draw(Graphics g) {
		g.drawImage(mainIm, 0,0,null);
		
	}
}
