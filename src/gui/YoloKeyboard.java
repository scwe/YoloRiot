package gui;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Direction;
import model.Model;
import model.Player;

public class YoloKeyboard extends KeyAdapter{
	private Player c;
	private boolean rightPressed;
	private boolean leftPressed;
	private boolean downPressed;
	private boolean upPressed;
	
    public YoloKeyboard(Player c){
    	this.c = c;
    	rightPressed = false;
    	leftPressed = false;
    	downPressed = false;
    	upPressed = false;
    }

    public void keyPressed(KeyEvent k){
    	if(k.getKeyCode() == KeyEvent.VK_W){
    		upPressed = true;
    	}else if(k.getKeyCode() == KeyEvent.VK_A){
    		leftPressed = true;
    	}else if(k.getKeyCode() == KeyEvent.VK_S){
    		downPressed = true;
    	}else if(k.getKeyCode() == KeyEvent.VK_D){
    		rightPressed = true;
    	}else if(k.getKeyCode() == KeyEvent.VK_ESCAPE){
    		System.exit(0);
    	}
    }

    public void keyReleased(KeyEvent k){
    	if(k.getKeyCode() == KeyEvent.VK_W){
    		upPressed = false;
    	}else if(k.getKeyCode() == KeyEvent.VK_A){
    		leftPressed = false;
    	}else if(k.getKeyCode() == KeyEvent.VK_S){
    		downPressed = false;
    	}else if(k.getKeyCode() == KeyEvent.VK_D){
    		rightPressed = false;
    	} else if (k.getKeyChar() == '?') {
    		Model.model.FULLYOL0 ();
    	}
    }
    
    public void update(){
    	System.out.println("Update");
    	if(upPressed){
    		c.move(Direction.NORTH);
    	}
    	if(downPressed){
    		c.move(Direction.SOUTH);
    	}
    	if(leftPressed){
    		c.move(Direction.WEST);
    	}
    	if(rightPressed){
    		c.move(Direction.EAST);
    	}
    }
}