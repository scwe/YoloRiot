package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import image.ImageLoader;

public class ItemPanel extends JPanel{
	
	
	public ItemPanel(){
		GridBagConstraints gc = new GridBagConstraints();
		setPreferredSize(new Dimension(120, YoloRiot.SCREEN_HEIGHT));
	}
	
	public void paintComponent(Graphics g){
		g.fillRect(0,0,getWidth(), getHeight());
	}
	
	public JButton newButton(String imageFile){
		BufferedImage image = new ImageLoader().getImage(imageFile);
		
		JButton button = new JButton(new ImageIcon(image));
		button.setPreferredSize(new Dimension(64, 64));
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton b = (JButton)(arg0.getSource());
				
				System.out.println(b.getName());
			}
			
		});
		
		return button;
	}
}
