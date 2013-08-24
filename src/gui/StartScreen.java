package gui;

import image.ImageLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class StartScreen extends JComponent implements SplashScreen{
	
	BufferedImage mainIm;
	ImageLoader imLoad;
	
	public StartScreen(){
		imLoad = new ImageLoader();
		mainIm = imLoad.getImage("StartScreen.png");
		if (mainIm == null)System.out.println("NULL");
	}

	@Override
    public void paintComponent(Graphics g){
		

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(mainIm, 0,0,null);
		
	}
	

	

}
