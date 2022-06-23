import java.util.ArrayList;

public class Montador {
	
	private static final int MAX = 28;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Player createPlayer() {
		// TODO Auto-generated method stub
		return new Player(0, 0);
	}

	public ArrayList<Componente> createComponents() {
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		componentes.add(new Energia(0, 0, 1));
		return componentes;
	}

	public Celula[][] createCells() {
		Celula[][] celulas = new Celula[MAX][MAX];
		for(int i = 0; i < MAX; i++) {
			for(int j = 0; j < MAX; j++) {
				celulas[i][j] = new CelulaPadrao(i, j);
			}
		}
		
		return celulas;
	}

}
