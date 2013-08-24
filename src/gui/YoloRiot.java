package gui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import map.Map;
import model.Model;

public class YoloRiot extends JFrame implements ActionListener{
	public static final int SCREEN_WIDTH = 1024;
	public static final int SCREEN_HEIGHT = 720;
	
	private static final int TICK = 10;

    private ScreenPanel screen;
    private Model model;
    private Map map;

	ScreenPanel mainScreen;
	StartScreen startScreen;
	
	private YoloMouse mouse;
	private YoloKeyboard key;
	
	private boolean startS = true, mainS = false;
	
	Timer t = new Timer(1000,this);
	Timer startTimer;
	
    public YoloRiot(){
    	setTitle("Yolo Riot");
    	setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    	model = new Model();
    	map = new Map("TILESET1.png");
    	
    	startScreen = new StartScreen();
        add(startScreen);
        startScreen.setVisible(true);
    	
        screen = new ScreenPanel(model, map);
        add(screen);
        screen.setVisible(false);
    
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mouse = new YoloMouse(model);
        key = new YoloKeyboard(model.getPlayer());
        
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addKeyListener(key);
        
        setFocusable(true);
        setVisible(true);
        
        t = new Timer(TICK,this);
        startTimer = new Timer(1000,this);
        startTimer.start();
    }
    
    public void gameLoop() {
    	if (startS){
    		startScreen.repaint();
    	}
    	else{
	    	model.tick();
	    	key.update();
	    	screen.repaint();
    	}
    	
    }

    public static void main(String[] args){
        new YoloRiot();
    }

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == startTimer && startS){
			System.out.println("true");
			startScreen.setVisible(false);
			screen.setVisible(true);
			startS = false;
			startTimer.stop();
			t.start();
		}
		gameLoop();
	}
}