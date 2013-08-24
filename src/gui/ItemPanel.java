package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

import image.ImageLoader;

public class ItemPanel extends JPanel{
	
	
	public ItemPanel(){
		GridBagConstraints gc = new GridBagConstraints();
		setPreferredSize(new Dimension(100, YoloRiot.SCREEN_HEIGHT));
	}
	
	public void paintComponent(Graphics g){
		g.fillRect(0,0,100, YoloRiot.SCREEN_HEIGHT);
	}
	
	public JButton newButton(String imageFile){
		BufferedImage image = new ImageLoader().getImage(imageFile);
		return null;
	}
}
