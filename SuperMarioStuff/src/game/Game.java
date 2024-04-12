package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Game extends Canvas implements Runnable  {
private static final long serialVersionUID = 1L;
	
	//public enum STATE {
		
//Menu,Help,Game,End;
		
	//}
	//public static STATE gameState = STATE.Menu;
	private boolean running = false;
	
	private Thread thread;
	
	public static int WIDTH,HEIGHT;
	
	private BufferedImage level = null;
	
	public BufferedImage level2 = null;
	
	Handler handler;
	
	static Textures tex;
	
	public static BufferedImage sprite_sheet;
	
	public static BufferedImage bullet_sheet;
	
	public static BufferedImage hp_sheet;
	
	public static BufferedImage chester_sheet;
	
	public static BufferedImage hot_sheet;
	
	public static BufferedImage dusan_sheet;
	
	public static BufferedImage retard_sheet;
	
	public static BufferedImage retard1_sheet;
	
	
	Random r;

	Hud hud;
	
	Bullet bullet;
	
	SpeedBoost speedb;
	
	HotChester hot;
	
	Item item;
	
	Button button;
	
	Chester chester;
	
	Health hp;
	
	public static int LEVEL = 1;
	
	Camera cam;
	
	public void init(){
		
	WIDTH = getWidth();
	HEIGHT = getHeight();
	
	tex = new Textures();
	
	

	BufferImageLoader loader = new BufferImageLoader();
	level = loader.loadImage("/level1.png");//loading level
	sprite_sheet = loader.loadImage("/danilo3.jpg");
	bullet_sheet = loader.loadImage("/bullet.gif");
	hp_sheet = loader.loadImage("/hp1.jpg");
	chester_sheet = loader.loadImage("/chester.jpg");
	hot_sheet = loader.loadImage("/hot.gif");
	dusan_sheet = loader.loadImage("/dusan2.jpg");
	retard_sheet = loader.loadImage("/retard5.jpg");
	retard1_sheet = loader.loadImage("/retard0.jpg");
	
	

 
 hud = new Hud();
 
 Random r = new Random();
 
 cam = new Camera(0,0);
 
  handler = new Handler(cam);
 
 handler.loadImageLevel(level);
 
 //menu = new Menu(this,handler,hud);
 
//if(gameState == STATE.Game){
 
 handler.addObject(new Player(100,150,handler,cam,ObjectId.Player));
 //handler.addObject(new DaniloBoss(100,100,ObjectId.Danilo,handler));
 //handler.addObject(new Player2(400,100,handler,ObjectId.Player2));
 //handler.addObject(new Item(r.nextInt(WIDTH),100,handler,ObjectId.Item));
 //handler.addObject(new SpeedBoost(r.nextInt(WIDTH),100,ObjectId.Item,handler));
 handler.addObject(new Health(10,10,ObjectId.Hp,handler,cam));
// handler.addObject(new Chester(350,30,ObjectId.Image));
 //handler.addObject(new HotChester(350,30,ObjectId.Image));
 //handler.addObject(new Dusan(350,420,ObjectId.Dusan,handler));
 //handler.addObject(new Button(1450,380,ObjectId.Button,handler));

 handler.addObject(new ClassicEnemy(550,200,ObjectId.Enemy,handler));
 //handler.addObject(new ClassicEnemy1(550,200,ObjectId.Enemy1,handler));
 
 
 
 //handler.createLevel();

 
	
 //}
 this.addKeyListener(new KeyInput(handler));
 }	
	
	
	public synchronized void start(){
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
 public synchronized void stop(){
	 
	 
	 running = false;
	 try {
		running = false;
		 thread.join();
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
 }
 
 
	 public void run(){
		 init();
			this.requestFocus();
			long lastTime = System.nanoTime();
			double amountOfTicks = 60.0;
			double ns = 1000000000 / amountOfTicks;
			double delta = 0;
			long timer = System.currentTimeMillis();
			while (running) {
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while (delta >= 1) {
					tick();
					delta--;
				}
				if (running)
					render();
				if (System.currentTimeMillis() - timer > 1000) {
					timer += 1000;

				}
			}

			stop();
	 }
	 
	 private void tick(){
		//if(gameState == STATE.Game){
		 handler.tick();
		 hud.tick();
		//button.tick();
		
	
		
		
		
		 
		 for(int i = 0;i < handler.object.size();i++){
			 if(handler.object.get(i).getId() == ObjectId.Player){
				  cam.tick(handler.object.get(i));
			  
			 }
		 }
		 
		
		  
		
		 
  // }
	 }
	 private void render(){
		 
		 
		 BufferStrategy bs = this.getBufferStrategy();
		 if(bs == null){
			 
			 this.createBufferStrategy(3);
			 return;
		 }
  Graphics g = bs.getDrawGraphics();
  Graphics2D g2d = (Graphics2D) g;
  
 
 
  g.setColor(Color.BLACK);
  g.fillRect(0, 0, getWidth(), getHeight());
  
  g2d.translate(cam.getX(), cam.getY());
  
  //if(gameState == STATE.Game){
  
  hud.render(g);
  handler.render(g);
  


 
  
  
  g2d.translate(-cam.getX(), -cam.getY());
  
  g.dispose();
  bs.show();
  
  }
  
	//}
	  public static float clamp( float var,float min,float max){
		if(var >=max)
			return var = max;
		else if(var <= min)
			return var = min;
		else 
			return var;
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
		  
	     
	     if(red == 255 && green == 255 & blue == 255) handler.addObject(new Block(xx * 32,yy * 32,0,ObjectId.Block));
	    
	     if(red == 128 && green == 128 & blue == 128) handler.addObject(new Block(xx * 32,yy * 32,0,ObjectId.Block));
	     if(red == 0 && green == 0 & blue == 255) handler.addObject(new Player(xx * 32,yy * 32,handler,cam,ObjectId.Player));
	     if(red == 255 && green == 216 & blue == 0) handler.addObject(new Flag(xx * 32,yy * 32,ObjectId.Flag));
	  
	  }
	
   }

	  
}	  
	 public static Textures getInstance(){ 
		 
		 return tex;
	 }
	  
	  
	  public static void main(String []args){
	new Window(800,600,"Valjda uspe",new Game());
  }

}
