package bloop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import bloop.Game.STATE;

public class Menu extends MouseAdapter{

	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
  
	private Color menuButton1 = Color.blue;
	private Color menuButton2 = Color.white;
	private Color menuButton3 = Color.white;
	
	private int bx1 = 210;
	private int bw1 = 200;
	
	private int bx2 = 210;
	private int bw2 = 200;
	
	private int bx3 = 210;
	private int bw3 = 200;
	
	public Menu (Game game, Handler handler, HUD hud) {
	  this.game = game;
	  this.hud = hud;
	  this.handler = handler;
  }
	
	public void mousePressed(MouseEvent e){
	 
	 int mx = e.getX();
	 int my = e.getY();
	 
	 if(game.gameState == STATE.Menu){
	 
	 //play button
	 if(mouseOver(mx,my, 210, 150 , 200 ,64)) {
		
		 game.gameState = STATE.Select;
	   return;
	 }
	 
	
	  //help button
	 if(game.gameState == STATE.Menu){
	 if(mouseOver(mx , my , 210,250,200,64)){
		 game.gameState = STATE.Help;
		 
		 return;
	 }
} 
	 //back button for help
	 if(game.gameState == STATE.Help){
		 if(mouseOver(mx , my ,210 , 350 , 200 ,64)) {
			 game.gameState = STATE.Menu;
			 return;
		 }
	 }
	 
	 //quit button
	 if(mouseOver(mx , my , 210 , 350, 200 ,64)) {
		 System.exit(1);
	 }
	}
	
if(game.gameState == STATE.Select){
	 //normal button
	 if(mouseOver(mx,my, 210, 150 , 200 ,64)) {
		game.gameState = STATE.Game;
		  handler.addObject(new Player(Game.WIDTH / 2 - 32,Game.HEIGHT/2 - 32,ID.Player,handler));
		handler.clearEnemy();
		  handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.BasicEnemy, handler));    	 
		 
		 hud.setLevel(1);;
			hud.setScore(0);
		  
		 game.diff = 0;
	 }
	}
	  //hard button
	 if(mouseOver(mx , my , 210,250,200,64)){
		 game.gameState = STATE.Game;
	 handler.addObject(new Player(Game.WIDTH / 2 - 32,Game.HEIGHT/2 - 32,ID.Player,handler));
		 handler.clearEnemy();
		  handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50),ID.BasicEnemy, handler));    	 
		 
		 hud.setLevel(1);;
			hud.setScore(0);
		  
		  game.diff = 1;
	 }
  
	 
	 //back button for help
	 if(game.gameState == STATE.Help){
		 if(mouseOver(mx , my ,210 , 350 , 200 ,64)) {
			 game.gameState = STATE.Menu;
			 return;
		 }
	 
	 
	 }
	 //back button
	 if(mouseOver(mx , my , 210 , 350, 200 ,64)) {
		 if(mouseOver(mx , my ,210 , 350 , 200 ,64)) {
			 game.gameState = STATE.Menu;
			 return;
		 }
	 }
	 
	 //back button for help
	 if(game.gameState == STATE.Help){
		 if(mouseOver(mx , my ,210 , 350 , 200 ,64)) {
			 game.gameState = STATE.Menu;
			
			 return;
		 }
		 
	 }	 
	
	 
  // back button for gameover
	 if(game.gameState == STATE.End){
		 if(mouseOver(mx , my ,210 , 350 , 200 ,64)) {
			 game.gameState = STATE.Menu;
			hud.setLevel(1);;
			hud.setScore(0);
			
			return;
		
		   }	 
	     
	   }
	 
     
	}
	

 
	
	public void mouseReleased(MouseEvent e){
		
		}
	
	public void mouseMoved(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
	
		 if(game.gameState == STATE.Menu){
			 
			 //play button
			if(mouseOver(mx,my,210,150,200,64)){
				menuButton1 = Color.blue;
				
			}else menuButton1 = Color.white;
		
			  //help button
			 
			 if(mouseOver(mx , my , 210,250,200,64)){
				menuButton2 = Color.green;
				}else {
					menuButton2 = Color.white;
				 
			 }
				
	
			 //quit button
			 if(mouseOver(mx , my , 210 , 350, 200 ,64)) {
				menuButton3 = Color.pink;
			
			}else {
				
				menuButton3 = Color.white;
			}
			 
		if(game.gameState == STATE.Select){
	
			//normal button
				 if(mouseOver(mx,my,210,150,200,64)){
						menuButton1 = Color.blue;
						
					}else menuButton1 = Color.white;
			 }
			
			  //hard button
			 if(mouseOver(mx , my , 210,250,200,64)){
				 game.gameState = STATE.Game;
			
			 }
			 
			 //back button for help
			 if(game.gameState == STATE.Help){
				 if(mouseOver(mx , my ,210 , 350 , 200 ,64)) {
					 
					 return;
				 }
			 
			 
			 }
			 //back button
			 if(mouseOver(mx , my , 210 , 350, 200 ,64)) {
				 if(mouseOver(mx , my ,210 , 350 , 200 ,64)) {
					
					 return;
				 }
			 }
			 
			 //back button for help
			 if(game.gameState == STATE.Help){
				 if(mouseOver(mx , my ,210 , 350 , 200 ,64)) {
					
					
					 return;
				 }
				 
			 }	 
			
			 
		  // back button for gameover
			 if(game.gameState == STATE.End){
				 if(mouseOver(mx , my ,210 , 350 , 200 ,64)) {
					
					
					return;
				
				 }			   }	 
			     
		}
		}
	
	
	private boolean mouseOver(int mx , int my, int x, int y,int width, int height) {
		if( mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		} else return false;
	}
 
	
 public void tick() {
	
	 if(menuButton1 == Color.white){
		 bx1 +=(230 - bx1) * 0.05;//210
		 bw1 += (200 - bw1) * 0.05;//200
	 }else{
		 bx1 +=(110 - bx1) * 0.05;
		 bw1 +=(400 - bw1) * 0.05;
	 }
	 if(menuButton2 == Color.white){
		 bx2 +=(230 - bx2) * 0.05;//210
		 bw2 += (200 - bw2) * 0.05;//200
	 
	 }else{
		 bx2 +=(110 - bx2) * 0.05;
		 bw2 +=(400 - bw2) * 0.05;
	 }
	 if(menuButton3 == Color.white){
		 bx3 +=(230 - bx3) * 0.05;//210
		 bw3 += (200 - bw3) * 0.05;//200
	 }else {
		 bx3 +=(110 - bx3) * 0.05;//210
		 bw3 += (400 - bw3) * 0.05;//200
	 }
 }
 
	
	public void render(Graphics g){
    if(game.gameState == STATE.Menu) {
    	
		Font fnt = new Font("Arial" ,1 ,50);
    Font fnt2 = new Font("Arial", 1 ,30);
		
    g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Boom",240, 70 );
		
		g.setFont(fnt2);
		g.setColor(menuButton1);
		 g.drawRect(bx1, 150, bw1, 64);
		 g.drawString("Play",260 , 190 );
		 g.setColor(Color.white);
      
		 g.setColor(menuButton2);
		  g.drawRect(bx2, 250, bw2, 64);
			g.drawString("Help",260 , 290 );
			 g.setColor(Color.white);
			
			 g.setColor(menuButton3);	
			 g.drawRect(bx3, 350, bw3, 64);
				g.drawString("Quit",260 , 390 );
				 g.setColor(Color.white);
	   }else if(game.gameState == STATE.Help){
			
		   Font fnt = new Font("Arial" ,1 ,50);
		   Font fnt2 = new Font("Arial", 1 ,30);
		    
		   g.setFont(fnt);
				g.setColor(Color.white);
				g.drawString("Help",240, 70 );
	   
				g.setFont(fnt2);
				g.drawString("Koristi strelice da pobegnes neprijatelju",50,300);
				
				g.setFont(fnt2);
				g.drawRect(210, 350, 200, 64);
				g.drawString("Back",260 , 390 );
	   
	   }else if(game.gameState == STATE.End){
			
		   Font fnt = new Font("Arial" ,1 ,50);
		   Font fnt2 = new Font("Arial", 1 ,30);
		    
		   g.setFont(fnt);
				g.setColor(Color.white);
				g.drawString("Game Over",180, 70 );
	   
				g.setFont(fnt2);
				g.drawString("    Tvoj skor je: "+ hud.getScore(),175,200);
				
				g.setFont(fnt2);
				g.drawRect(210, 350, 200, 64);
				g.drawString("Probaj opet",230 , 390 );
	   
	   
	   }if(game.gameState == STATE.Select) {
	    	
			Font fnt = new Font("Arial" ,1 ,50);
	    Font fnt2 = new Font("Arial", 1 ,30);
			
	    g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Select",240, 70 );
			
			g.setFont(fnt2);
			 g.drawRect(210, 150, 200, 64);
			 g.drawString("Normal",250 , 190 );
	      
			  
		     
				g.drawRect(210, 250, 200, 64);
				g.drawString("Hard",270 , 290 );
				
					g.drawRect(210, 350, 200, 64);
					g.drawString("Back",260 , 390 );
		   }if(game.gameState == STATE.Game2) {
		    	
				Font fnt = new Font("Arial" ,1 ,50);
		    Font fnt2 = new Font("Arial", 1 ,30);
				
		    g.setFont(fnt);
				g.setColor(Color.white);
				g.drawString("Select",240, 70 );
				
				g.setFont(fnt2);
				 g.drawRect(210, 150, 200, 64);
				 g.drawString("1 Player",250 , 190 );
		      
				  
			     
					g.drawRect(210, 250, 200, 64);
					g.drawString("2 Players",244 , 290 );
					
						g.drawRect(210, 350, 200, 64);
						g.drawString("Back",260 , 390 );
			   }
	}

}
