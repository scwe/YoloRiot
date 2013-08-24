package gui;
import java.awt.event.*;
import model.Player;
import model.Direction;

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
    	System.out.println("Key pressed");
    	if(k.getKeyCode() == KeyEvent.VK_W){
    		upPressed = true;
    	}else if(k.getKeyCode() == KeyEvent.VK_A){
    		leftPressed = true;
    	}else if(k.getKeyCode() == KeyEvent.VK_S){
    		downPressed = true;
    	}else if(k.getKeyCode() == KeyEvent.VK_D){
    		rightPressed = true;
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
    	}
    }
    
    public void update(){
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