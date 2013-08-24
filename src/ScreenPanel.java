
import java.awt.*;
import model.*;
import javax.swing.*;

public class ScreenPanel extends JPanel{

	private YoloKeyboard key;
	private YoloMouse mouse;
	private Graphics2D buffer;
	
	private Map map;
	private Model model;
	
    public ScreenPanel(Model model){
        setFocusable(true);
        requestFocusInWindow();
        mouse = new YoloMouse();
        key = new YoloKeyboard();
        
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addKeyListener(key);
        
        this.model = model;
        initGame();
    }
    
    public void initGame(){
    	this.map = new Map();
    }
    
    @Override
    public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Image offscreen = createImage(getWidth(), getHeight());
		buffer = (Graphics2D) offscreen.getGraphics();
		buffer.setColor(Color.white);
		buffer.fillRect(0, 0, getWidth(), getHeight());

		draw(buffer);
		
		g2d.drawImage(offscreen, 0, 0, this);
    }
    
    public void draw(Graphics2D g){
    	g.drawRect(0, 0, YoloRiot.SCREEN_WIDTH, YoloRiot.SCREEN_HEIGHT);
    	if(map != null){
    		map.draw(g);
    	}
    }
    
    
}