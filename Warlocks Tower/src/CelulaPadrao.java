import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class CelulaPadrao extends Celula {
	
	public CelulaPadrao(int x, int y) {
		this.x = x;
		this.y = y;
		this.passable = true;
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
	public void interactedByPlayer(Player player, ArrayList<Componente> componentes, Celula[][] celulas) {
		// TODO Auto-generated method stub
		
	}


	
}
