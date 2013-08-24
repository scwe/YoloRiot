package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class StartScreen implements SplashScreen{
	
	GlassPane gp;
	Image mainIm = new BufferedImage(1,1,1);
	
	public StartScreen(){
		
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	class GlassPane extends JComponent implements ItemListener {
		public void itemStateChanged(ItemEvent e){
		setVisible(e.getStateChange() == ItemEvent.SELECTED);
		}
	}

}
