package gui;


import image.ImageLoader;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JPanel;

import map.Map;
import model.Model;

public class ScreenPanel extends JPanel{

	private Graphics2D buffer;
	
	
	private Map map;
	private Model model;
	
	private String currentTurret;
	
	private Cursor cursor;
	
	
    public ScreenPanel(Model model, Map map, String currentTurret){
        setFocusable(true);
        requestFocusInWindow();
        this.currentTurret = currentTurret;

        this.model = model;
        this.map = map;
        
        cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageLoader().getImage("cursor.png"), new Point(0,0), "crosshair");
        
        super.setCursor(cursor);
    }
    
    @Override
    public void paintComponent(Graphics g){
    	
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Image offscreen = createImage(getWidth(), getHeight());
		
		buffer = (Graphics2D) offscreen.getGraphics();
		buffer.setColor(Color.white);
		buffer.fillRect(0, 0, getWidth(), getHeight());
		buffer.setRenderingHints(rh);
		
		if(currentTurret != null){
			cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageLoader().getImage(currentTurret), new Point(0,0), currentTurret);
			//super.setCursor(cursor);
			System.out.println("Changed the cursor to "+currentTurret);
		}

		//TODO drawing of any background shit should go here
		
		g2d.drawImage(offscreen, 0, 0, this);
    }
    
    
}