import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Energia extends Componente{
	private int energiaqtd ;
	
	public Energia(int x, int y, int energia) {
		this.alive = true;
		loadImage("images/moeda5.png");
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
	public void interactedByPlayer(Player player, ArrayList<Componente> componentes, Celula[][] celulas) {
		if(alive) {
			player.setEnergy(player.getEnergy() + this.energiaqtd);
			die();
		}
	}
	
	private void die() {
		this.setAlive(false);
		loadImage("images/dead.png");	
	}


}
