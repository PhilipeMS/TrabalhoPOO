import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class CelulaPadrao extends Celula {
	
	private int x;
	private int y;

	public CelulaPadrao(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
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
	
}
