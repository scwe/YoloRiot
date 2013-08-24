import javax.swing.JFrame;

import model.Model;

public class YoloRiot extends JFrame{
	public static final int SCREEN_WIDTH = 1024;
	public static final int SCREEN_HEIGHT = 720;
	
	private static final int TICK = 20;

    private ScreenPanel screen;
    private Model model;

	ScreenPanel mainScreen;
	
    public YoloRiot(){
    	setTitle("Yolo Riot");
    	setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    	model = new Model ();
        screen = new ScreenPanel(model);
        add(screen);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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