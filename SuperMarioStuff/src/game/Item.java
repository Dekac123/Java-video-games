package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

public class Item extends GameObject {

	private Handler handler;
	
	Hud hud;
	
	private float gravity = 0.5f;
	
	Random r = new Random();
	

	
	public Item(float x, float y,Handler handler,ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	
	public void tick(LinkedList<GameObject> object) {
		
		y += velY;
		
		if(falling) velY += gravity;
		
		
		collision(object);
		handler.addObject(new Trail(x + 15,y + 10 ,ObjectId.Trail,Color.red,10, 10,0.04f,handler));
	
	}
	
	
	public void collision(LinkedList<GameObject>object){
		for(int i = 0;i < handler.object.size(); i ++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block){
		
	if(getBounds().intersects(tempObject.getBounds())){
		y = tempObject.getY() - 40;
		velY = 0;
		falling = false;
		jumping = false;
	
		
	}
	
		}
			if(tempObject.getId() == ObjectId.Player){
				if(getBounds().intersects(tempObject.getBounds())){
					Hud.HEALTH += 20;
					handler.removeObject(this);
					
				}
			}
		
			if(tempObject.getId() == ObjectId.Player2){
				if(getBounds().intersects(tempObject.getBounds())){
					Hud.HEALTH2 += 20;
					handler.removeObject(this);
				
				}
			}
		
		 
		
		
		}  }
	
	
	
	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect((int)x,(int)y,40,40);
		g.setColor(Color.red);
		g.fillRect((int)x + 15,(int)y + 5,10,30);
		g.setColor(Color.red);
		g.fillRect((int)x + 5,(int)y + 15,30,10);
	}

	
	public Rectangle getBounds() {
	
		return new Rectangle((int)x,(int)y,40,40);
		
	}
		public Rectangle getBoundsX() {
		
			return new Rectangle((int)x + 20,(int)y + 20,40,40);
		
	}

}

