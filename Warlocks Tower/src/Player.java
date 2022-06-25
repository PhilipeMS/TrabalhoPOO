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
	private ArrayList<Position> pastPositions;
	private BufferedImage image;
	private Dungeon dungeon;
	private int energia;
	
	public Player(int x, int y, Dungeon dungeon, int energia) {
		loadImage();
		this.energia = energia;
		this.dungeon = dungeon;
		this.x = x;
		this.y = y;
		pastPositions = new ArrayList<Position>();
		
	}
	
	private boolean inValidPosition(int x, int y) {
		boolean isValid = true;
		
		if(x >= Montador.MAX_WIDTH || x < 0 || y >= Montador.MAX_HEIGHT || y < 0) {
			isValid = false;
			return isValid;
		}
		
		if(!dungeon.getCells()[x][y].getPassable()) {
			isValid = false;
			return isValid;
		}
		
		return isValid;
	}
	
	
	public void tick(ArrayList<Componente> componentes, Celula[][] celulas) {
		
		
		if(x >= Montador.MAX_WIDTH || x < 0 || y >= Montador.MAX_HEIGHT || y < 0) {
			this.x = pastPositions.get(pastPositions.size()-1).getX();
			this.y = pastPositions.get(pastPositions.size()-1).getY();
		}
		
		if(!celulas[this.x][this.y].getPassable()) {
			this.x = pastPositions.get(pastPositions.size()-1).getX();
			this.y = pastPositions.get(pastPositions.size()-1).getY();
		}
		
		
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
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void move(int deltaX, int deltaY) {
		
		if(!this.inValidPosition(this.x, this.y)){
			return;
		}
		
		if(!this.inValidPosition(this.x + deltaX, this.y + deltaY)) {
			return;
		}
		

		this.pastPositions.add(new Position(this.x, this.y));
		this.x = this.x  + deltaX;
		this.y = this.y + deltaY;
		this.energia --;
		
	}
	
	public void playerInteract() {
		dungeon.getCells()[this.x][this.y].interactedByPlayer(this, dungeon.getComponentes(), dungeon.getCells());
		for(Componente componente: dungeon.getComponentes()) {
			if(componente.getX() == this.x && componente.getY() == this.y) {
				componente.interactedByPlayer(this, dungeon.getComponentes(), dungeon.getCells());
			}
		}
	}
	
	public void setEnergy(int energy) {
		this.energia = energy;
	}
	
	public int getEnergy() {
		return this.energia;
	}

}
