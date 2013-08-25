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
import java.util.HashMap;

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
	private BufferedImage heart;
	private BufferedImage crystal;
	public static String currentButton;
	private Model m;

	HashMap<String,BufferedImage> numbers = new HashMap<String,BufferedImage>();

	
	public static final int BUTTON1X = 66;   //FUYCK yeah
	public static final int BUTTON1Y = 427;
	public static final int BUTTON2X = 129;
	public static final int BUTTON2Y = 427;
	public static final int BUTTON3X = 66;
	public static final int BUTTON3Y = 486;
	public static final int BUTTON4X = 129;
	public static final int BUTTON4Y = 486;
	
	public static final int BUTTONWIDTH = 64;
	public static final int BUTTONHEIGHT = 64;

	public static final int MONEYX = 65;
	public static final int MONEYY = 110;
	
	public static final int LIFE1X = 65;
	public static final int LIFE1Y = 70;
	public static final int LIFEWIDTH = 32;
	public static final int LIFEHEIGHT = 32;
	
	public static final int POWER1X = 65;
	public static final int POWER1Y = 140;
	public static final int POWERWIDTH = 32;
	public static final int POWERHEIGHT = 32;	
	
	public BufferedImage[] numbersA = new BufferedImage[10];
	
	public ItemPanel(Model m){
		this.m = m;
		super.setBorder(new StrokeBorder(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)));
		setFocusable(false);
		ImageLoader il = new ImageLoader();
		background = il.getImage("newGoo.png");
		setPreferredSize(new Dimension(120, YoloRiot.SCREEN_HEIGHT));
		
		addMouseListener (this);

		
		ImageLoader im = new ImageLoader();
		for (int i = 0; i < 10; i++){
			numbers.put(i+"", im.getImage(i+".png"));
			numbersA[i] = im.getImage(i+".png");
		}
		heart = im.getImage("heart.png");
		crystal = im.getImage("crystal.png");
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0,0,getWidth(), getHeight());
		g.drawImage(background,0,0,this.getWidth(),this.getHeight(),null);
		
		int money = Model.model.money;
		String moneyS = new Integer(money).toString();
		
		for (int i=0; i < moneyS.length(); i++) {
			BufferedImage number = numbersA[moneyS.charAt(i) - '0']; 
			g.drawImage(number, MONEYX+i*12, MONEYY, 12, 12, null);	
		}
		
		int lives = Model.model.player.health;
		for (int i=0; i < lives; i++) {
			g.drawImage(heart, LIFE1X + i*16, LIFE1Y, 16, 16, null);	
		}
		
		int powerups = Model.model.powerupcount;
		
		for (int i=0; i < powerups; i++) {
			g.drawImage(crystal, POWER1X + i*POWERHEIGHT, POWER1Y, null);	
		}
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
			return new SpriteSheet(0,0,64, 128, "64_wall.png").getImage(0, 0, 64, 128).getScaledInstance(64, 64, Image.SCALE_FAST);
		}else{
			return null;
		}
	}
	
	public static void resetCurrentButton(){
		currentButton = null;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("Mouse pressed and "+arg0.getX()+" "+arg0.getY());
		int x = arg0.getX();
		int y = arg0.getY();
		
		if (insideButton(x, y, BUTTON1X, BUTTON1Y)) {
			System.out.println("Button 1 pressed");
			currentButton = "NEW_TURRET_ANIMATION.png";
		} else if (insideButton(x, y, BUTTON2X, BUTTON2Y)) {
			
			System.out.println("Button 2 pressed");
		} else if (insideButton(x, y, BUTTON3X, BUTTON3Y)) {
			System.out.println("Button 3 pressed");
			currentButton = "Wall, side top bot.png";
			
		} else if (insideButton(x, y, BUTTON4X, BUTTON4Y)) {
			System.out.println("Button 4 pressed");
			
		}
	}
	
	private boolean insideButton (int x, int y, int buttonx, int buttony) {
		return (x > buttonx && x < buttonx + BUTTONWIDTH && y > buttony && y < buttony+BUTTONHEIGHT);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
