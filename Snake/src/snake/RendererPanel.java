package snake;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RendererPanel extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(0));
		g.fillRect(0 , 0 ,800, 700);
		super.paintComponent(g);
	}

}
