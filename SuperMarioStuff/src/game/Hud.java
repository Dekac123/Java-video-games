package game;

import java.awt.Color;
import java.awt.Graphics;



public class Hud {

private int level = 1;
	
	
 public static float HEALTH = 100;
 public static float HEALTH2 = 100;
 public float greenValue = 255f;
 public float greenValue2 = 255f;
 

 

 
int score;
int timer = 500;
	
 
 public void tick() {
		 HEALTH =  Game.clamp(HEALTH, 0, 100);
      greenValue = HEALTH *2;
		 greenValue =  Game.clamp(greenValue, 0, 255);
	
		  HEALTH2 =  Game.clamp(HEALTH2, 0, 100);
	      greenValue2 = HEALTH2 *2;
			 greenValue2 =  Game.clamp(greenValue2, 0, 255);
	 
	
	
	score ++;
	
	timer --;
	
	
	
 }

 public void render(Graphics g) {
	// g.setColor(Color.gray);
	// g.fillRect(15,15,200,32);
	// g.setColor(new Color(75, (int)greenValue , 0));
	// g.fillRect(15,15,(int)HEALTH *2,32);
     //g.setColor(Color.white);
    // g.drawRect(15,15,200 ,32);
     
    // g.setColor(Color.gray);
	// g.fillRect(600,15,200,32);
	// g.setColor(new Color(75, (int)greenValue2 , 0));
	// g.fillRect(600,15,(int)HEALTH2 * 2,32);
    // g.setColor(Color.white);
    // g.drawRect(600,15,200 ,32);
     
     g.setColor(Color.WHITE);
     g.drawString(""+ score, 300, 100);
     
    // g.setColor(Color.white);
		//g.drawString(""+ timer, 300, 300);
		
 }
 
 
 public void setScore(int score){
	 
	 this.score = score;
 }
 
public int getScore(){
	
	return score;
}

public int getLevel(){
	 return level;
}

public void setLevel(int level){
	this.level = level;
}

}
