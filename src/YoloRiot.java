import java.awt.*;
import javax.swing.*;

public class YoloRiot extends JFrame{
	public static final int SCREEN_WIDTH = 1024;
	public static final int SCREEN_HEIGHT = 720;

    private ScreenPanel screen;

    public YoloRiot(){
    	setTitle("Yolo Riot");
    	setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        screen = new ScreenPanel();
        add(screen);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setFocusable(true);
        setVisible(true);
        
        gameLoop();
    }
    
    public void gameLoop(){
    	while(true){
    		screen.repaint();
    	}
    }

    public static void main(String[] args){
        new YoloRiot();
    }
}