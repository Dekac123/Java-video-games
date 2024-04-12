package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Dusan extends GameObject{

	Handler handler;
	
	Hud hud;
	
	public BufferedImage dusan_image;
	
	public boolean touch = false;
	private float gravity = 0.5f;
	private int max_speed = 15;
	int width = 48;
	int height = 96;
	
	
	public Dusan(float x, float y, ObjectId id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
	
		
		SpriteSheet ss = new SpriteSheet(Game.dusan_sheet);
		
		dusan_image = ss.grabImage(1, 1, 48, 96);
	}

	
	public void tick(LinkedList<GameObject> object) {
	
		y += velY;
		x += velX;
		
		if(falling || jumping){
			velY += gravity;
		}
		
		if(velY > max_speed){
			velY = max_speed;
		}

	action(object);
	Collision(object);
	}

	
private void Collision(LinkedList<GameObject>object){	
		
		for(int i = 0;i < handler.object.size(); i ++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block){
				if(getBoundsTop().intersects(tempObject.getBounds())){
					y = tempObject.getY() + 32;
					velY = 0;
					
		
				
			}	
				if(getBounds().intersects(tempObject.getBounds())){
					y = tempObject.getY() - height;
					velY = 0;
					falling = false;
					jumping = false;
				
				}else
					falling = true;
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = tempObject.getX() - width;
					
				}
				
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX() + 35;
					
				}
			
		
		
			}		
		
		
			
		}
	
  }
	public void action(LinkedList<GameObject>object){

		
	}


public void render(Graphics g) {
		
		g.drawImage(dusan_image,(int)x,(int)y,null);
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,48,96);
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x+(width /2)-((width/2)/2)),(int)y,(int)width/2,(int)height/2);
	
	}
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x + width - 5),(int)y + 5,(int)5,(int)height - 10);
	
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x,(int)y + 5,(int)5,(int)height - 10);
	}
}
