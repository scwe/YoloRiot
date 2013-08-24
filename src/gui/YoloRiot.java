package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.Model;
import map.*;

public class YoloRiot extends JFrame implements ActionListener{
	public static final int SCREEN_WIDTH = 1024;
	public static final int SCREEN_HEIGHT = 720;
	
	private static final int TICK = 20;

    private ScreenPanel screen;
    private Model model;
    private Map map;

	ScreenPanel mainScreen;
	StartScreen startScreen;
	
	private YoloMouse mouse;
	private YoloKeyboard key;
	
	private boolean startS = true, mainS = false;
	
	Timer t = new Timer(1000,this);
	
    public YoloRiot(){
    	setTitle("Yolo Riot");
    	setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    	model = new Model();
    	map = new Map("images/TILESET1.png");
        screen = new ScreenPanel(model, map);
        add(screen);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        startScreen = new StartScreen();
        startScreen.setVisible(false);
        add(startScreen);
        mouse = new YoloMouse();
        key = new YoloKeyboard(model.getPlayer());
        
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addKeyListener(key);
        

        setFocusable(true);
        setVisible(true);
        
        gameLoop();
        Timer t = new Timer(TICK,this);
        t.start();
    }
    
    public void gameLoop() {
   
    		model.tick ();
    		screen.repaint();
    		key.update();
  
    }

    public static void main(String[] args){
        new YoloRiot();
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		gameLoop();
	}
}