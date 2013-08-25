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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.StrokeBorder;

import model.Model;

@SuppressWarnings("serial")
public class ItemPanel extends JPanel implements MouseListener {
	
	private static final int BUTTON_WIDTH = 64;
	private static final int BUTTON_HEIGHT = 64;
	private BufferedImage background;
	public static String currentButton;
	private Model m;
	
	public static final int BUTTON1X = 0;
	public static final int BUTTON1Y = 0;
	public static final int BUTTON2X = 0;
	public static final int BUTTON2Y = 0;
	public static final int BUTTON3X = 0;
	public static final int BUTTON3Y = 0;
	public static final int BUTTON4X = 0;
	public static final int BUTTON4Y = 0;
	
	public static final int BUTTONWIDTH = 64;
	public static final int BUTTONHEIGHT = 64;

	public static final int MONEYX = 0;
	public static final int MONEYY = 0;
	
	public static final int LIFE1X = 0;
	public static final int LIFE1Y = 0;
	public static final int LIFE2X = 0;
	public static final int LIFE2Y = 0;
	public static final int LIFE3X = 0;
	public static final int LIFE3Y = 0;
	public static final int LIFE4X = 0;
	public static final int LIFE4Y = 0;
	public static final int LIFE5X = 0;
	public static final int LIFE5Y = 0;
	
	public static final int LIFEWIDTH = 32;
	public static final int LIFEHEIGHT = 32;
	
	public static final int POWER1X = 0;
	public static final int POWER1Y = 0;
	public static final int POWER2X = 0;
	public static final int POWER2Y = 0;
	public static final int POWER3X = 0;
	public static final int POWER3Y = 0;
	
	public static final int POWERWIDTH = 32;
	public static final int POWERHEIGHT = 32;	
	
	public ItemPanel(Model m){
		this.m = m;
		super.setBorder(new StrokeBorder(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)));
		setFocusable(false);
		this.setLayout(null);
		//setPreferredSize(new Dimension(120, YoloRiot.SCREEN_HEIGHT));
		JButton but = newStructureButton("NEW_TURRET_ANIMATION.png", 32, 0, 64, 64);
		but.setBounds(60,270, 100, 100);
		add(but);
		ImageLoader il = new ImageLoader();
		background = il.getImage("NEW_GUI.png");
		setPreferredSize(new Dimension(120, YoloRiot.SCREEN_HEIGHT));
		add(newStructureButton("Wall, side top bot.png", 0, 0, 32, 32));
		
		addMouseListener (this);
		
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

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		
		if (insideButton(x, y, BUTTON1X, BUTTON1Y)) {
						
		} else if (insideButton(x, y, BUTTON2X, BUTTON2Y)) {
			
			
		} else if (insideButton(x, y, BUTTON3X, BUTTON3Y)) {
			
			
		} else if (insideButton(x, y, BUTTON4X, BUTTON4Y)) {
			
			
		}
	}
	
	private boolean insideButton (int x, int y, int buttonx, int buttony) {
		return (x > buttonx && x < buttonx + BUTTONWIDTH && y > buttony && y <BUTTONHEIGHT);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
