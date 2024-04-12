package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class HotChester extends GameObject {

	private BufferedImage hot_image;
	
	public HotChester(float x, float y, ObjectId id) {
		super(x, y, id);
		
		SpriteSheet ss = new SpriteSheet(Game.hot_sheet);
		
		hot_image = ss.grabImage(1, 1, 100, 10);
	}

	
	public void tick(LinkedList<GameObject> object) {
		
		
	}


	public void render(Graphics g) {
		
		
		g.drawImage(hot_image,(int)x,(int)y,null);
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,100,10);
	}

	
}
