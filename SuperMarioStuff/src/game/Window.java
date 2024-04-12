package game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {

	
	public Window(int w, int h, String title,Game game){
		
		game.setPreferredSize(new Dimension(w, h));
		game.setMaximumSize(new Dimension(w , h));
		game.setMinimumSize(new Dimension(w,h));
	
	JFrame j = new JFrame(title);
	j.add(game);
	j.pack();
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	j.setVisible(true);
	j.setResizable(false);
	j.setLocationRelativeTo(null);
	j.setFocusable(true);
	
	game.start();
	
	
	}

}