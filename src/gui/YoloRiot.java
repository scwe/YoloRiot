package gui;

import javax.swing.JFrame;

import model.Model;
import map.*;

public class YoloRiot extends JFrame{
	public static final int SCREEN_WIDTH = 1024;
	public static final int SCREEN_HEIGHT = 720;
	
	private static final int TICK = 20;

    private ScreenPanel screen;
    private Model model;
    private Map map;

	ScreenPanel mainScreen;
	
	private YoloMouse mouse;
	private YoloKeyboard key;
	
    public YoloRiot(){
    	setTitle("Yolo Riot");
    	setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    	model = new Model();
    	map = new Map("images/TILESET1.png");
        screen = new ScreenPanel(model, map);
        add(screen);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        mouse = new YoloMouse();
        key = new YoloKeyboard(model.getPlayer());
        
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addKeyListener(key);
        

        setFocusable(true);
        setVisible(true);
        
        gameLoop();
    }
    
    public void gameLoop() {
    	while(true){
    		model.tick ();
    		screen.repaint();
    	}
    }

    public static void main(String[] args){
        new YoloRiot();
    }
}