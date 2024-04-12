package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Flag extends GameObject {

	private	Handler handler;

	ClassicEnemy classicenemy;

	private BufferedImage bullet_image;



		public Flag(float x, float y, ObjectId id) {
			super(x, y, id);
		   
		   
		    		
		    //SpriteSheet ss = new SpriteSheet(Game.bullet_sheet);
		    
		   // bullet_image = ss.grabImage(1,1,50,38);
		}

		
		public void tick(LinkedList<GameObject> object) {
			
			
	
			
			
			
		}
		
		
		public void render(Graphics g) {
			
			g.setColor(Color.yellow);
			g.fillRect((int)x, (int)y, 32, 32);
			
			//g.drawImage(bullet_image,(int)x,(int)y,null);
			
		}

		
		public Rectangle getBounds() {
			
			return new Rectangle((int)x,(int)y,32,32);
		}



		
}
