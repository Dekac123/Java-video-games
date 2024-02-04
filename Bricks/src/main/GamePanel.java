package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable  {

private boolean running;
private BufferedImage image;	
private Graphics2D g;	
	
	Ball theBall;



public GamePanel() {
	
    init();
	
	}


public void init() {

	theBall = new Ball();
	
	running = true;
	
	image = new BufferedImage(BBMain.WIDTH,BBMain.HEIGHT,BufferedImage.TYPE_INT_RGB);

     g = (Graphics2D) image.getGraphics();

    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

}

@Override

public void run(){
	while(running){
		
	update();
	
	
	draw();
	
	
	repaint();
	
	try {
		Thread.sleep(10);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	}
}
 
public void update() {
	
	theBall.update();
	
}

public void draw(){
	
//background
	g.setColor(Color.WHITE);
g.fillRect(0,0,BBMain.WIDTH,BBMain.HEIGHT);


theBall.draw(g);


}

public void paintComponent(Graphics g) {
	
Graphics2D g2 = (Graphics2D) g;

 g2.drawImage(image,0,0,BBMain.WIDTH,BBMain.HEIGHT,null);

   g2.dispose();


}


public void playGame() {
	


}

}
