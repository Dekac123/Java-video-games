package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	
Handler handler;

GameObject gb;


public KeyInput(Handler handler){
	this.handler = handler;
	
	 
	 
	
}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0;i < handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player){
				if(key == KeyEvent.VK_D)tempObject.setVelX(handler.speed);
					if(key == KeyEvent.VK_A) tempObject.setVelX(-handler.speed);
				if(key == KeyEvent.VK_SPACE && !tempObject.isJumping()) 
				{
					
					tempObject.setJumping(true);
					tempObject.setVelY(-13);
				}
			
			if(key == KeyEvent.VK_F){
				handler.addObject(new Bullet(tempObject.getX() + 40,tempObject.getY() + 32,ObjectId.Bullet,tempObject.getFacing() * 9,handler));
			}
		}
			if(tempObject.getId() == ObjectId.Player2){
				if(key == KeyEvent.VK_RIGHT)tempObject.setVelX(handler.speed);
					if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-handler.speed);
				if(key == KeyEvent.VK_UP && !tempObject.isJumping()) 
				{
					tempObject.setJumping(true);
					tempObject.setVelY(-13);
				}
			
			if(key == KeyEvent.VK_ENTER){
				handler.addObject(new Bullet(tempObject.getX() - 21,tempObject.getY() + 48,ObjectId.Bullet,tempObject.getFacing() * -9,handler));
			}
		}
		
		
		
		}
	
		if(key == KeyEvent.VK_ESCAPE){
		System.exit(0);	
		
		}
	
	

	
	}

public void keyReleased(KeyEvent e){
	int key = e.getKeyCode();
	
	for(int i = 0;i < handler.object.size();i++){
		GameObject tempObject = handler.object.get(i);
		
		if(tempObject.getId() == ObjectId.Player){
			if(key == KeyEvent.VK_D) tempObject.setVelX(0);
			if(key == KeyEvent.VK_A) tempObject.setVelX(0);
			
		}
		
		
		if(tempObject.getId() == ObjectId.Player2){
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
				
}

}
}
}