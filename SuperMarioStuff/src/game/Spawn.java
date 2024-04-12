package game;

import java.util.Random;


public class Spawn {


private Handler handler;
private Hud hud;
private Game game;
private Random r = new Random();

private int scoreKeep = 0;

public Spawn(Handler handler, Hud hud,Game game){
	 this.handler = handler;
	 this.hud = hud;
	 this.game = game;
}

   public void tick(){
   	scoreKeep++;
   	
   	
   	
   	if(scoreKeep >= 250){
   		scoreKeep = 0;
   	hud.setLevel(hud.getLevel() + 1);
   	
   
   	
      }

    	
    
   }
   
}