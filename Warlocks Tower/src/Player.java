import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Player {
	private int x;
	private int y;
	private BufferedImage image;
	
	public Player(int x, int y) {
		loadImage();
		
		this.x = x;
		this.y = y;
		
	}
	
	public void tick(ArrayList<Componente> componentes, Celula[][] celulas) {
		// TODO Auto-generated method stub
		
	}
	
	private void loadImage() {
		try {
			image = ImageIO.read(new File("images/player.jpg"));
		} catch (IOException e) {
			System.out.println("Error opening player image file: " + e.getMessage());
		}
		
	}
	
	public void draw(Graphics g, ImageObserver dungeon) {
		g.drawImage(image, x * Dungeon.CELL_SIZE, y*Dungeon.CELL_SIZE, dungeon);
	}


}
