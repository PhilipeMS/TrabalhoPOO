import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Energia extends Componente{
	private int energiaqtd ;
	
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


}
