package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

import image.ImageLoader;

public class ItemPanel extends JPanel{
	
	private static final int BUTTON_WIDTH = 64;
	private static final int BUTTON_HEIGHT = 64;
	
	private HashMap<String, String> buttonMap;
	
	public ItemPanel(){
		buttonMap = new HashMap<String, String>();
		buttonMap.put("Button.png", "test");
		GridBagConstraints gc = new GridBagConstraints();
		setPreferredSize(new Dimension(120, YoloRiot.SCREEN_HEIGHT));
		add(newButton("Button.png"));
	}
	
	public void paintComponent(Graphics g){
		g.fillRect(0,0,getWidth(), getHeight());
	}
	
	public JButton newButton(String imageFile){
		Image image = new ImageLoader().getImage(imageFile).getScaledInstance(BUTTON_WIDTH, BUTTON_HEIGHT, Image.SCALE_FAST);
		
		JButton button = new JButton(new ImageIcon(image));
		button.setName(buttonMap.get(imageFile));
		button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		
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
