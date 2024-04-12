package game;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public  class DaniloBoss extends GameObject {

	private Handler handler;
	
	private GameObject danilo;
	
	Player player;
	
	private BufferedImage danilo_image;
	
	public DaniloBoss(int x, int y, ObjectId id, Handler handler) {
		super(x, y, id);
	  
		this.handler = handler;
	
		 SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		 danilo_image = ss.grabImage(1, 1, 120, 120);
		 
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == ObjectId.Player) danilo = handler.object.get(i); 
			
		}
		
		
	}
public Rectangle getBounds() {
		return new Rectangle((int)x , (int)y, 16 , 16);
	
}
	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;
		
	   float diffX = x - danilo.getX() - 16;
	   float diffY = y - danilo.getY() - 16;
	   float distance = (float) Math.sqrt((x - danilo.getX()) * (x - danilo.getX()) + (y - danilo.getY())* (y - danilo.getY()));
		
		velX = (float)((-4.2/distance) * diffX);
		velY = (float)((-4.0/distance) * diffY);
		
		
	   for(int i = 0;i < object.size(); i++){
		  GameObject tempObject = handler.object.get(i); 
		  
		  if(tempObject.getId() == ObjectId.Player){
			  if(getBounds().intersects(tempObject.getBounds())){
				 player.life = player.life -1;
			  }
		  }
	   }
	 
	   
	   
	   
	   // if(y <= 0 || y >= Game.HEIGHT -32) velY *= -1;
	    //if(x <= 0 || x >= Game.WIDTH -16) velX *= -1;
	
	 // handler.addObject(new Trail(x , y ,ObjectId.Trail ,Color.green ,16 ,16,0.02f,handler));
	}

	
	public void render(Graphics g) {
		//g.setColor(Color.green);
		//g.fillRect((int)x, (int)y, 16, 16);
		g.drawImage(danilo_image,(int)x,(int)y,null);
		
	}
	
		
	
}

	
	





