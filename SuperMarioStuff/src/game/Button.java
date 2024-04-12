package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Button extends GameObject {

	private Handler handler;
	private boolean sudar = false;
	private int timer = 20;
	
	Font font = new Font("Arial",1,50);
	
	public Button(float x, float y, ObjectId id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
	
	}

	
	public void tick(LinkedList<GameObject> object) {
		
	
		
		
		sudar(object);
	}

	
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.drawRect((int)x,(int)y,32,32);
		
		if(sudar){
			for(int i = 0;i < 11;i ++){		
			
			g.setFont(font);
			g.drawString("Debilko!!!", 1350,280);
		
			}	
			}
		if(!sudar){
			g.drawString("Skoci slobodno", 1410, 280);
		}
		
		
		g.setPaintMode();
	}

	
	private void sudar(LinkedList<GameObject> object){
		
		for(int i = 0;i < object.size(); i++){
		GameObject tempObject = handler.object.get(i);
		
		if(tempObject.getId() == ObjectId.Player){
			
			if(getBounds().intersects(tempObject.getBounds())){
				
				//handler.removeObject(this);
			sudar = true;
			
		
				
				
			}
		}
		
	}
}	
	
	public void tick(){
		
		timer++;
	}
	
	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int) y, 32, 32);
	}

}
