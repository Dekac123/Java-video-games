package game;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Bullet extends GameObject {

private	Handler handler;

ClassicEnemy1 classicenemy1;

private BufferedImage bullet_image;



	public Bullet(float x, float y, ObjectId id,int velX,Handler handler) {
		super(x, y, id);
	    this.velX =velX;
	    this.handler = handler;
	    		
	    SpriteSheet ss = new SpriteSheet(Game.bullet_sheet);
	    
	    bullet_image = ss.grabImage(1,1,50,38);
	}

	
	public void tick(LinkedList<GameObject> object) {
		x += velX;
		
		sudar(object);
		
		
		  //handler.addObject(new Trail(x,y,ObjectId.Trail,Color.orange.brighter(),16, 16,0.3f,handler));
	}
	
	public void sudar(LinkedList<GameObject> object){
		

		 for(int i =0;i<handler.object.size();i++){
			   GameObject tempObject=handler.object.get(i);
			   if(tempObject.getId()==ObjectId.Player){   
			    if(getBounds().intersects(tempObject.getBounds())){
			   
			    	handler.removeObject(this);
	                    Hud.HEALTH = Hud.HEALTH - 10;
	}
			  }
			   if(tempObject.getId()==ObjectId.Player2){   
				    if(getBounds().intersects(tempObject.getBounds())){
				   
				    	handler.removeObject(this);
		                    Hud.HEALTH2 = Hud.HEALTH2 - 10;
		}
				  }
		 
		 if(tempObject.getId() == ObjectId.Block){
			if(getBounds().intersects(tempObject.getBounds())){
			 handler.removeObject(this);
		 }
		
		 }
		 
		 if(tempObject.getId() == ObjectId.Enemy){
			 if(getBounds().intersects(tempObject.getBounds())){
				 
				handler.removeObject(classicenemy1);
				handler.removeObject(this);
				 
				 
			 }
		 }
		
		 }		   
		
	}
	
	public void render(Graphics g) {
		
		g.drawImage(bullet_image,(int)x,(int)y,null);
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,16,16);
	}

	
	
	
}
