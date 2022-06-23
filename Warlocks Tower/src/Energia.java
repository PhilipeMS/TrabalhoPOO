import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Energia extends Componente{
	private int energiaqtd ;
	int x;
	int y;
	
	public Energia(int energia, int x, int y) {
		this.energiaqtd = energia;
		this.x = x;
		this.y = y;
		
	
	}

	@Override
	public void tick(Player player, ArrayList<Componente> componentes, Celula[][] celulas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interact(Player player, ArrayList<Componente> componentes, Celula[][] celulas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g, ImageObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interactedByPlayer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
		
	}

	@Override
	public void setY(int y) {
		this.y = y;
		
	}

	
	
}
