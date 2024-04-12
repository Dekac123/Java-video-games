package game;

import java.awt.image.BufferedImage;

public class Textures {

	
	SpriteSheet bs,ps;
	
	private BufferedImage block_sheet = null;
	
	private BufferedImage player_sheet = null;
	
	public BufferedImage[] block = new BufferedImage[2];
	
	public BufferedImage[] player = new BufferedImage[3];
	
	public Textures(){
		
		
		BufferImageLoader loader = new BufferImageLoader();
		
		
		try {
			block_sheet = loader.loadImage("/block.jpg");
			player_sheet = loader.loadImage("/heroes.jpg");
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
			bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		
		getTextures();
	}	
	
	private void getTextures(){
		
		block[0] = bs.grabImage(1, 1, 32, 32);
		block[1] = bs.grabImage(1, 1, 32, 32);
		
		player[0] = ps.grabImage(1, 1, 58, 96 );
		player[1] = ps.grabImage(2, 1, 58, 96 );
		player[2] = ps.grabImage(3, 1, 58, 96 );
		player[3] = ps.grabImage(4, 1, 58, 96 );
		
		
	}
		
	}

