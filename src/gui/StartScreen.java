package gui;

import image.ImageLoader;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class StartScreen extends JComponent implements SplashScreen{
	
	Image mainIm;
	ImageLoader imLoad;
	
	public StartScreen(){
		//imLoad = new ImageLoader();
		//mainIm = imLoad.getImage("/images/StartScreen.png");
	}

	@Override
	public void draw(Graphics g) {
		
		g.drawImage(mainIm, 0,0,null);
	}
	

	

}
