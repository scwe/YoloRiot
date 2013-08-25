package gui;

import image.ImageLoader;
import image.SpriteSheet;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.StrokeBorder;

import model.Model;

@SuppressWarnings("serial")
public class ItemPanel extends JPanel{
	
	private static final int BUTTON_WIDTH = 64;
	private static final int BUTTON_HEIGHT = 64;
	private BufferedImage background;
	public static String currentButton;
	private Model m;

	
	public ItemPanel(Model m){
		this.m = m;
		super.setBorder(new StrokeBorder(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)));
		setFocusable(false);
		this.setLayout(null);
		//setPreferredSize(new Dimension(120, YoloRiot.SCREEN_HEIGHT));
		JButton but = newStructureButton("NEW_TURRET_ANIMATION.png", 0, 0, 64, 64);
		but.setBounds(60,270, 100, 100);
		add(but);
		ImageLoader il = new ImageLoader();
		background = il.getImage("NEW_GUI.png");
		setPreferredSize(new Dimension(120, YoloRiot.SCREEN_HEIGHT));
		add(newStructureButton("NEW_TURRET_ANIMATION.png", 32, 0, 64, 64));
		add(newStructureButton("Wall, side top bot.png", 0, 0, 32, 32));
		
		JButton yoloButton = new JButton(new ImageIcon(new ImageLoader().getImage("64_yolo_button.png")));
		yoloButton.setFocusable(false);
		yoloButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ItemPanel.this.m.FULLYOL0();
			}
			
		});
		yoloButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		yoloButton.setBackground(Color.white);
		add(yoloButton);

	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0,0,getWidth(), getHeight());
		g.drawImage(background,0,0,this.getWidth(),this.getHeight(),null);
	}
	
	public JButton newStructureButton(String imageFile, int x, int y, int width, int height){
		SpriteSheet image = new SpriteSheet(0, 0, 64,64, imageFile);
		
		
		JButton button = new JButton(new ImageIcon(image.getImage(x, y, width, height).getScaledInstance(64, 64, Image.SCALE_FAST)));
		button.setFocusable(false);
		button.setName(imageFile);
		button.setBackground(Color.white);
		button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(getWidth()+" "+ getHeight());
				JButton b = (JButton)(arg0.getSource());
				currentButton = b.getName();
			}
			
		});
		
		return button;
	}
	
	
	
	public static int getButtonNum(){
		if(currentButton.equals("NEW_TURRET_ANIMATION.png")){
			return 0;
		}else if(currentButton.equals("Wall, side top bot.png")){
			return 1;
		}else{
			return -1;
		}
	}
	
	public static Image getImage(){
		if(currentButton.equals("NEW_TURRET_ANIMATION.png")){
			return new SpriteSheet(0, 0, 64, 64, "NEW_TURRET_ANIMATION.png").getImage(32, 0, 64, 64).getScaledInstance(64, 64, Image.SCALE_FAST);
		}else if(currentButton.equals("Wall, side top bot.png")){
			return new SpriteSheet(0, 0, 64, 64, "Wall, side top bot.png").getImage(0, 0, 32, 32).getScaledInstance(64, 64, Image.SCALE_FAST);
		}else{
			return null;
		}
	}
	
	public static void resetCurrentButton(){
		currentButton = null;
	}
}
