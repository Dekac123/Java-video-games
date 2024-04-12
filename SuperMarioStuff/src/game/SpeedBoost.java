package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.util.LinkedList;



public class SpeedBoost extends GameObject  {

	private Handler handler;
	
	public Hud hud;
	
	private float gravity = 0.5f;

	public SpeedBoost(float x, float y, ObjectId id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
	
		
	}

	
	public void tick(LinkedList<GameObject> object) {
y += velY;
		
		if(falling) velY += gravity;
	
		
		collision(object);
		handler.addObject(new Trail(x + 15,y + 10 ,ObjectId.Trail,new Color(32,178,170),10, 10,0.04f,handler));
		
		//  handler.addObject(new Trail(x,y,ObjectId.Trail,Color.orange.brighter(),16, 16,0.3f,handler));
	
	
	}
		public void collision(LinkedList<GameObject> object){
			
		
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
						handler.speed = 7;
						//handler.addObject(new Trail(x,y + 98/2 - 30,ObjectId.Trail,Color.cyan.darker(),10, 60,0.04f,handler));
						handler.removeObject(this);
						
						
						
					}
				}
			
				if(tempObject.getId() == ObjectId.Player2){
					if(getBounds().intersects(tempObject.getBounds())){
						handler.speed = 7;
						//handler.addObject(new Trail(x,y + 98/2 - 30,ObjectId.Trail,Color.cyan.darker(),10, 60,0.04f,handler));
						handler.removeObject(this);
						hud.timer--;
						hud.tick();
						
						
						  
						
					}
				
				
				}
			
			 
			
			
			}  
			
		
		
		}
	
			

	
	public void render(Graphics g) {
	
		g.setColor(new Color(32,178,170));
		g.fillRect((int)x, (int)y, 40, 40);
	;
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,16,16);
	}


	
	
		
	}


