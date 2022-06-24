import java.util.ArrayList;

public class Montador {
	
	public static final int MAX_HEIGHT = (int)Dungeon.SCREEN_HEIGTH/Dungeon.CELL_SIZE;
	public static final int MAX_WIDTH = (int)Dungeon.SCREEN_WIDTH/Dungeon.CELL_SIZE;
	private Dungeon dungeon;
	
	
	public Montador(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Player createPlayer() {
		// TODO Auto-generated method stub
		return new Player(0, 0, dungeon);
	}

	public ArrayList<Componente> createComponents() {
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		componentes.add(new Energia(0, 0, 1));
		return componentes;
	}

	public Celula[][] createCells() {
		Celula[][] celulas = new Celula[MAX_WIDTH][MAX_HEIGHT];
		for(int i = 0; i < MAX_WIDTH; i++) {
			for(int j = 0; j < MAX_HEIGHT; j++) {
				if(i == MAX_WIDTH-1) {
					celulas[i][j] = new Parede(i, j);
				}else {
					celulas[i][j] = new CelulaPadrao(i, j);
				}
			}
		}
		
		return celulas;
	}

}
