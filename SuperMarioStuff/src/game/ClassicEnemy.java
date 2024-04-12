package game;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class ClassicEnemy extends GameObject {

	
	double velX = -2.2;
	
	Handler handler;
	
	Player player;
	
	private int width = 67;
	
	Bullet bullet;
	
	BufferedImage retard_image;
	
	public ClassicEnemy(float x, float y, ObjectId id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.retard_sheet);
		
		retard_image = ss.grabImage(1, 1, 67, 81);
			
	}

	
	public void tick(LinkedList<GameObject> object) {
		
		x += velX;
		y += velY;
		
		col(object);
		
		
		
		
	}

	

	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.drawImage(retard_image,(int)x,(int)y,null);
		
		
	g.setColor(Color.white);
		g2d.draw(getBoundsTop());
	}

	
	public void col(LinkedList <GameObject> object){
		for(int i = 0;i < object.size(); i ++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player){
				if(getBounds().intersects(tempObject.getBounds())){
					
					
					
				}
				if(getBounds().intersects(tempObject.getBounds())){
					
					
					
					}
					
					//handler.removeObject(this);
				
				
			}
			
				
				if(tempObject.getId() == ObjectId.Bullet){
					if(getBounds().intersects(tempObject.getBounds())){
						handler.removeObject(this);
						handler.removeObject(tempObject);
									
				}
			}
				
				
				if(tempObject.getId() == ObjectId.Block){
					if(getBounds().intersects(tempObject.getBounds())){
						velX = -velX;
					}
				
			
			
			
				}
				
		}
		
		
			
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,67,81);
		
	}
    
    	public Rectangle getBoundsTop() {
    		return new Rectangle((int) ((int)x+(width /2)-((width/2)/2)),(int)y,(int)width/2,1);
}
	
}
