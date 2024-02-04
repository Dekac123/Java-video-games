package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball 
{

	public  int x,y,width = 25,height = 25;
	
	public int motionX,motionY;
	
	public Random random;
	
public Ball(Pong pong)
	{
		random = new Random();
		this.x = pong.width / 2 - this.width / 2;
		this.y = pong.height/ 2 - this.height/ 2;
	}
	
public void update(Paddle paddle1,Paddle paddle2)
{
   if(checkCollision(paddle1) == 1)
   {
	  this.motionX = 1;
	  this.motionY = -2 + random.nextInt(4);
   }
   if(checkCollision(paddle2) == 1)
   {
	  this.motionX = -1;
	  this.motionY = -2 + random.nextInt(4);
   }
   if(checkCollision(paddle1) == 2)
   {
	 paddle2.score ++;
   }
   if(checkCollision(paddle2) == 2)
   {
	 paddle1.score ++;
   }
}

public int checkCollision(Paddle paddle)
{
		
	if(paddle.x < x + width || paddle.x > x)
	{
		if(paddle.y > y + height || paddle.y + height < y){
		}
		else 
		{
			return 2;//zid
		}
	}
	return 0;//nista
}


public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
	g.fillOval(x, y, width,height);
	}
}
