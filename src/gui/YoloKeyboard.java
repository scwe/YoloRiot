package gui;
import java.awt.event.*;
import model.Player;
import model.Direction;

public class YoloKeyboard extends KeyAdapter{
	private Player c;
    public YoloKeyboard(Player c){
    	this.c = c;
    }

    public void keyPressed(KeyEvent k){
    	if(k.getKeyCode() == KeyEvent.VK_W){
    		c.move(Direction.NORTH);
    	}else if(k.getKeyCode() == KeyEvent.VK_A){
    		c.move(Direction.WEST);
    	}else if(k.getKeyCode() == KeyEvent.VK_S){
    		c.move(Direction.SOUTH);
    	}else if(k.getKeyCode() == KeyEvent.VK_D){
    		c.move(Direction.EAST);
    	}
    }

    public void keyReleased(KeyEvent k){
        
    }
}