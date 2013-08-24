package gui;


import java.awt.*;

import map.Map;
import model.*;
import javax.swing.*;

public class ScreenPanel extends JPanel{

	private YoloKeyboard key;
	private YoloMouse mouse;
	private Graphics2D buffer;
	
	private MapPanel mapPanel;
	
	private Map map;
	private Model model;
	
    public ScreenPanel(Model model, Map map){
        setFocusable(true);
        requestFocusInWindow();
        
        mapPanel = new MapPanel(model, map);
        add(mapPanel);

        this.model = model;
        this.map = map;
    }
    
    @Override
    public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Image offscreen = createImage(getWidth(), getHeight());
		buffer = (Graphics2D) offscreen.getGraphics();
		buffer.setColor(Color.white);
		buffer.fillRect(0, 0, getWidth(), getHeight());

		//TODO drawing of any background shit should go here
		mapPanel.repaint();
		
		g2d.drawImage(offscreen, 0, 0, this);
    }
    
    
}