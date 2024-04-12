package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Health extends GameObject{
	
Player player;
	
	 Handler handler;
	
 Camera cam;
	
	 public Health(int x, int y,ObjectId id,Handler handler,Camera cam){
		 super(x,y,id);
 
		 this.handler = handler;
		 this.cam = cam;
		 
		 SpriteSheet ss = new SpriteSheet(Game.hp_sheet);
	 
		
 
Game.hp_sheet = ss.grabImage(1,1,30,30);

	
	}

	

	 
public void render(Graphics g){
	
  g.drawImage(Game.hp_sheet, (int)x, (int)y, null);
  
  
}



public void tick(LinkedList<GameObject> object) {

 x += velX;
	
 x = -cam.getX() + 10;

  handler.removeObject(this);

 }




public Rectangle getBounds() {
	
	return new Rectangle(-10,-10,30,30);
}


	

	
	

	


}