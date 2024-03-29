package pong;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Pong implements ActionListener,KeyListener{

public static Pong pong;

public int width = 700,height = 700;

public Renderer renderer;

public Paddle player1;

public Paddle player2;

public Ball ball;

public boolean bot = false;

public boolean w ,s ,up ,down;

public Pong()
{
	Timer timer = new Timer(20,this);
JFrame jframe = new JFrame("Pong");
renderer = new Renderer();

jframe.setSize(width + 15, height);
jframe.setVisible(true);
jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jframe.add(renderer);
jframe.addKeyListener(this);

start();

timer.start();
}

public void start()
{
	player1 = new Paddle(this,1);
	player2 = new Paddle(this,2);
	ball = new Ball(this);
}

public void update()
{
	if(w)
	{
		player1.move(true);
	}
	if(s)
	{
		player1.move(false);
	}
	if(up)
	{
		player2.move(true);
	}
	if(down)
	{
		player2.move(false);
	}
	
}

public void render(Graphics2D g){
	
	g.setColor(Color.BLACK);
	g.fillRect(0,0,width,height);
	
	g.setColor(Color.WHITE);
	g.setStroke(new BasicStroke(5f));
	g.drawLine(width / 2, 0 ,width / 2, height);
	
	player1.render(g);
	player2.render(g);
	ball.render(g);
}

@Override
public void actionPerformed(ActionEvent arg0) {

	update();


renderer.repaint();


}


public static void main(String []args){
	
	pong = new Pong();
	
	
	
}

@Override
public void keyPressed(KeyEvent e) {
	int id = e.getKeyCode();
	
	if(id == KeyEvent.VK_W){
		w = true;
	}
	if(id == KeyEvent.VK_S){
		s = true;
  }
	if(id == KeyEvent.VK_UP){
		up = true;
  }
	if(id == KeyEvent.VK_DOWN){
		down = true;
  }

}

@Override
public void keyReleased(KeyEvent e) {
int id = e.getKeyCode();
	
	if(id == KeyEvent.VK_W){
		w = false;
	}
	if(id == KeyEvent.VK_S){
		s = false;
  }
	if(id == KeyEvent.VK_UP){
		up = false;
  }
	if(id == KeyEvent.VK_DOWN){
		down = false;
  }

	
}

@Override
public void keyTyped(KeyEvent e) {

	
}


}
