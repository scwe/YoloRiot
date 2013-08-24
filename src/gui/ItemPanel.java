package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import image.ImageLoader;

@SuppressWarnings("serial")
public class ItemPanel extends JPanel{
	
	private static final int BUTTON_WIDTH = 64;
	private static final int BUTTON_HEIGHT = 64;
	
	public static String currentButton;
	
	public ItemPanel(){
		
		super.setBorder(new StrokeBorder(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)));
		setFocusable(false);
		setPreferredSize(new Dimension(120, YoloRiot.SCREEN_HEIGHT));
		add(newButton("Button.png"));
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0,0,getWidth(), getHeight());
	}
	
	public JButton newButton(String imageFile){
		Image image = new ImageLoader().getImage(imageFile).getScaledInstance(BUTTON_WIDTH, BUTTON_HEIGHT, Image.SCALE_FAST);
		
		JButton button = new JButton(new ImageIcon(image));
		button.setFocusable(false);
		button.setName(imageFile);
		button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton b = (JButton)(arg0.getSource());
				currentButton = b.getName();
			}
			
		});
		
		return button;
	}
	
	public static void resetCurrentButton(){
		currentButton = null;
	}
}
