package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
	
	private int x, y ,dx, dy; 
	private int ballSize =  30;
	
	public Ball(){
		
	x = 200;
	y = 200;
	dx = 1;
	dy = 3;
	}

  public void update() {
	  setPosition();
  }
	 
  public void setPosition(){
	  
   x += dx;
   y +=dy;
   
   if(x < 0) {
	   dx = -dx;
   }
  if(y < 0){
	  dy= - dy;
  }
  if(x > BBMain.WIDTH - ballSize) {
	  dx = - dx;
  }
  if(x > BBMain.HEIGHT - ballSize){
	  dy = -dy;
  }
  
  
  }
  
  public void draw(Graphics2D g){
	  
	 g.setColor(Color.DARK_GRAY);
     g.setStroke(new BasicStroke(4));
     g.drawOval(x, y, ballSize, ballSize);
 }
 
  
}
