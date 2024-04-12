package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Chester extends GameObject {

	private BufferedImage chester_image;
	
	public Chester(float x, float y, ObjectId id) {
		super(x, y, id);
	
		
		SpriteSheet ss = new SpriteSheet(Game.chester_sheet);
		
		chester_image = ss.grabImage(1, 1, 110, 140);
		
		
	}

	
	public void tick(LinkedList<GameObject> object) {
		
		
	}

	
	public void render(Graphics g) {
	
		g.drawImage(chester_image,(int)x,(int)y,null);
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,143,113);
	}

	
}
