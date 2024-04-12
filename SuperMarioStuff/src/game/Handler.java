package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Handler {

	Camera cam;
	
	public static LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
	private BufferedImage level2 = null;
	
	public Handler(Camera cam){
		
		this.cam = cam;
		
		BufferImageLoader loader = new BufferImageLoader();
		
		level2 = loader.loadImage("/level2.png");//loading level
	}
	
	public int speed = 5;
	
	public void tick(){
		
		
		
		for(int i = 0;i < object.size(); i++){
			tempObject = object.get(i);
		
		 tempObject.tick(object);
		}
	
	
	}
	public void render(Graphics g){
		
		for(int i = 0;i < object.size(); i++){
			
			tempObject = object.get(i);
			
			tempObject.render(g);
		}
	
	
	}

	  public void loadImageLevel(BufferedImage image){
		  
		  int w = image.getWidth();
		  int h = image.getHeight();
		  
		 // System.out.println("wdwd"+ w + h);
		  
		  for(int xx = 0; xx < w; xx++){
			  
	  for(int yy = 0; yy < h; yy ++){
		  
	     int pixel = image.getRGB(xx,yy);
	     int red = (pixel >> 16) & 0xff;
	     int green = (pixel >> 8) & 0xff;
	     int blue = (pixel) & 0xff;
		  
	     
	     if(red == 255 && green == 255 & blue == 255) addObject(new Block(xx * 32,yy * 32,0,ObjectId.Block));
	     if(red == 128 && green == 128 & blue == 128) addObject(new Block(xx * 32,yy * 32,0,ObjectId.Block));
	     if(red == 0 && green == 0 & blue == 255) addObject(new Player(xx * 32,yy * 32,this,cam,ObjectId.Player));
	     if(red == 255 && green == 216 & blue == 0) addObject(new Flag(xx * 32,yy * 32,ObjectId.Flag));
	  
	  }
	
 }

	  
}	  
	
	  public void switchLevel(){
		  
		  clearLevel();
		  cam.setX(0);
		  this.addObject(new Player(100,150,this,cam,ObjectId.Player));
		  
		  switch(Game.LEVEL){
		  
		  case 1:
			  loadImageLevel(level2);
			  break;
	  }
	  
	  } 
	public static void clearLevel(){
		
		object.clear();
		
		
	}
	
	
	
  public void addObject(GameObject object){
	  this.object.add(object);
	  
  }
	public void removeObject(GameObject object){
		this.object.remove(object);
		
	}
	public void createLevel(){
		for (int xx = 0; xx < Game.WIDTH + 32; xx += 32){
			   addObject(new Block(xx, Game.HEIGHT - 32,0, ObjectId.Block));
			   addObject(new Block(0, xx,0, ObjectId.Block));
			   //addObject(new Block(Game.WIDTH-32, xx, ObjectId.Block));   
			  }
			  for(int yy = 32*6; yy < 32*19 ; yy += 32)
			   addObject(new Block(yy, Game.HEIGHT - 32*6,0, ObjectId.Block));
			  
			 
	}

	
		


	}

