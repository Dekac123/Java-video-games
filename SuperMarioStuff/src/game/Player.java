package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;


public class Player extends GameObject {

	private float width = 60, height = 96;
	
	public int life = 3;

	public boolean lifer = false;
	
	public BufferedImage player_image;
	
	private float gravity = 0.5f;
	
	private float sped = 0.8f;
	
	private final float MAX_SPEED = 10;
	
	ClassicEnemy classicenemy;
	
	private Camera cam;
	
	private Handler handler;
	
	Textures tex = Game.getInstance();
	
	private Animation playerWalk;
	
	public Player(float x, float y, Handler handler,Camera cam,ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		this.cam = cam;
		
		
		playerWalk = new Animation(10,tex.player[1],tex.player[2],tex.player[3]);
		
		
		
	}

	
	public void tick(LinkedList<GameObject> object) {
	
		x += velX;
		y += velY;
		
		if(falling || jumping){
			
			velY += gravity;
			
		
		  if(velY > MAX_SPEED)
			  velY = MAX_SPEED;
		
		}
		
		handler.addObject(new Trail(x,y + height/2 - 30,ObjectId.Trail,Color.cyan.darker(),10, 60,0.04f,handler));
		Collision(object);
	
		playerWalk.runAnimation();
	}	
	
	
	private void Collision(LinkedList<GameObject>object){	
		
		for(int i = 0;i < handler.object.size(); i ++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block){
				
				if(getBoundsTop().intersects(tempObject.getBounds())){
					y = tempObject.getY() + 32;
					velY = 0;
					
		
				
			}	
				if(getBounds().intersects(tempObject.getBounds())){
					y = tempObject.getY() - height;
					velY = 0;
					falling = false;
					jumping = false;
					knockback = false;
				
				}else
					falling = true;
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = tempObject.getX() - width;
					
					
				}
				
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX() + 35;
					
					
				}
			}
		
				
				if(tempObject.getId() == ObjectId.Enemy){
					if(getBoundsRight().intersects(tempObject.getBounds())){
				    knockback = true;
						velX = -4;
					velY = -7;
					
					if(tempObject.getId() == ObjectId.Block){
						if(getBounds().intersects(tempObject.getBounds())){
			        velX = 0;
			        
							
						}
					}	
					}
					
					
					
				}
				
				
		
		
			
				
				if(tempObject.getId() == ObjectId.Enemy1){
					if(getBoundsRight().intersects(tempObject.getBounds())){
						velX = -3;
						velY = -7;
						knockback = true;
						
						
			
					}
					
					if(getBoundsLeft().intersects(tempObject.getBounds())){
						velX = -3;
						velY = -7;
						
			
					}
					
					if(getBounds().intersects(tempObject.getBounds())){
						velX = -3;
						velY = -7;
						
			
					}
			}
		
		
					
		
		else if(tempObject.getId() == ObjectId.Flag){
			//switch level
			if(getBounds().intersects(tempObject.getBounds())){
				
				handler.switchLevel();
			}
			
		}
			
		}
	
	}
	
	
		
	
	
	public void render(Graphics g) {
	
		
		//g.setColor(Color.blue);
		//g.fillRect((int)x, (int)y, (int)width, (int)height);
	
	Graphics2D g2 = (Graphics2D) g;
	
	//g.setColor(Color.red);
	//g2.draw(getBounds());
	//g2.draw(getBoundsRight());
	//g2.draw(getBoundsLeft());
	//g2.draw(getBoundsTop());
	//g.setColor(Color.GRAY);
	//g2.fill(getRifle());
	
	if(velX != 0)
		playerWalk.drawAnimation(g, (int)x, (int)y,58,96);
	else
	g.drawImage(tex.player[0],(int)x,(int)y,58,96,null);
	
	
	
	
	}

	
	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x + (width / 2)-((width/2)/2)),(int) ((int)y + (height/2)),(int)width/2,(int)height/2);
	
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x+(width /2)-((width/2)/2)),(int)y,(int)width/2,(int)height/2);
	
	}
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x + width - 5),(int)y + 5,(int)5,(int)height - 10);
	
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x,(int)y + 5,(int)5,(int)height - 10);
	
	}
	
		




}

