package bloop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;



public class HardEnemy extends GameObject {

	private Random r = new Random();
	
	private Handler handler;
	
	public HardEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
	  
		this.handler = handler;
		
		velX = 5;
		velY = 5;
		
	
	}
public Rectangle getBounds() {
		return new Rectangle((int)x , (int)y, 16 , 16);
	
}
	public void tick() {
		x += velX;
		y += velY;
		
	    if(y <= 0 || y >= Game.HEIGHT -32) {
	    if(velY < 0) velY = -(r.nextInt(7)+1) * -1; 
	    else velY = (r.nextInt(7)+1) * -1;
	    }
	    if(x <= 0 || x >= Game.WIDTH -16) {
	    if(velX < 0) velX = -(r.nextInt(7)+1) * -1; 
	    else velX = (r.nextInt(7)+1) * -1;
	    }
	  
	    
	    handler.addObject(new Trail( x , y ,ID.Trail ,new Color(111,173,243) ,16 ,16,0.02f,handler));
	}

	
	public void render(Graphics g) {
		g.setColor(new Color(111,173,243));
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

	
	
	}


