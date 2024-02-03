package smajli;

import javax.swing.JFrame;

public class Main {

public static void main(String[] args){
	
	javax.swing.JFrame f = new javax.swing.JFrame("Smajli");
	
	f.setVisible(true);
	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	f.setResizable(false);
	
	int[] pixels = new int[136 * 136];
	java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().createImage(new java.awt.image.MemoryImageSource(16, 16, pixels, 0, 16));
	java.awt.Cursor transparentCursor = java.awt.Toolkit.getDefaultToolkit().createCustomCursor(image, new java.awt.Point(0, 0), "invisiblecursor");
	f.setCursor(transparentCursor);
	
	
	f.getContentPane().setLayout(new java.awt.BorderLayout());
	
	f.setAlwaysOnTop(true);
	
	new Controller(f);
}
}