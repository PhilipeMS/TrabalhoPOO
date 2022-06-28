import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Montador {
	
	enum ComponentType {
		ENERGIA,
		ALAVANCA,
		PORTA,
	}
	
	enum CellType {
		CELULAPADRAO,
		SAIDA,;
	}
	
	public static final int MAX_HEIGHT = (int)Dungeon.SCREEN_HEIGTH/Dungeon.CELL_SIZE;
	public static final int MAX_WIDTH = (int)Dungeon.SCREEN_WIDTH/Dungeon.CELL_SIZE;
	private Dungeon dungeon;
	private BufferedReader br;
	
	public Montador(Dungeon dungeon) {
		this.dungeon = dungeon;
		readFile();
	}

	private void readFile() {
		
		File file = new File("levels/" + dungeon.getLevel() + ".txt");
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			
		} catch (IOException e) {
			
			File exempleFile = new File("levels/exemplo.txt");
			System.out.println(e.getMessage());
			
			try {
				br = new BufferedReader(new FileReader(exempleFile));
				
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}

		}
		
	}
	
	
	private void fileBadFormat() {
		File exempleFile = new File("levels/exemplo.txt");
		System.out.println("Arquivo está com a formatacao errada");
		
		try {
			br = new BufferedReader(new FileReader(exempleFile));
			
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	public Player createPlayer() {
		
		String[] st;
		try {
			st = br.readLine().split(" ");
		} catch (IOException e1) {
			fileBadFormat();
			System.out.println(e1.getMessage());
			return new Player(0, 0, dungeon, 0);
		}
		
		if(st.length != 4) {
			fileBadFormat();
			System.out.println("Player mal formatado");
			return new Player(0, 0, dungeon, 0);
		}
		
		if(!st[0].equals("Player")){
			System.out.println("O arquivo deve comecar com Player");
			fileBadFormat();
			return new Player(0, 0, dungeon, 0);
		}
		
		int x;
		int y;
		int energia;
		
		try {
			x = Integer.parseInt(st[1]);
			y = Integer.parseInt(st[2]);
			energia = Integer.parseInt(st[3]);
			
		} catch(Exception e){
			System.out.println("x, y e energia devem ser inteiros");
			fileBadFormat();
			return new Player(0, 0, dungeon, 0);
		}
		
		return new Player(x, y, dungeon, energia);
	}
	

	public ArrayList<Componente> createComponents() {
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		String[] st;
		String s;
		try {
//			while((s = br.readLine()) != null) {
//				System.out.println(s);
//			}
			
			while((s = br.readLine()) != null) {
				st = s.split(" ");
				String ComponentName;
				int x;
				int y;
				
				if(st.length < 3) {
					fileBadFormat();
					System.out.println("Componente mal formatado");
				}
				
				ComponentName = st[0];
				
				try {
					x = Integer.parseInt(st[1]);
					y = Integer.parseInt(st[2]);
					
					if(ComponentName.equals("Energia")) {
						if(st.length == 4){
							int energia;
							try {
								energia = Integer.parseInt(st[3]);
								componentes.add(new Energia(x, y, energia));
							} catch(Exception e) {
								System.out.println("Energia mal formatada");
							}

						}else {
							System.out.println("Energia mal formatada");
						}

					}else if(ComponentName.equals("Alavanca")){
						if(st.length > 4) {
							ArrayList<Activable> ativaveis = new ArrayList<Activable> ();
							try {
								for(int i = 3; i < st.length; i += 2) {
									int n = Integer.parseInt(st[i]);
									int m = Integer.parseInt(st[i+1]);
									for(Componente componente: componentes) {
										if(n == componente.x && m == componente.y) {
											System.out.println("Adicionado");
											ativaveis.add((Activable) componente);
										}
									}
								}
								
								componentes.add(new Alavanca(x, y, ativaveis));
								
							} catch(Exception e) {
								System.out.println("Alavanca mal formatada");
							}
						}else {
							System.out.println("Alavanca mal formatada");
						}
						
						
					}else if(ComponentName.equals("Porta")) {
						
						if(st.length == 4){
							boolean aberta;
							try {
								aberta = Boolean.parseBoolean(st[3]);
								componentes.add(new Porta(x, y, aberta));
							} catch(Exception e) {
								System.out.println("Porta mal formatada");
							}

						}
						
					}
					
				} catch(Exception e){
					System.out.println("x, y do componente devem ser inteiros");
					fileBadFormat();
				}
				

				
			};
			
		} catch (IOException e) {
			System.out.println("Erro ao pegar componentes");
			return componentes;
		}
		
		return componentes;
	}

	public Celula[][] createCells() {
		
		Celula[][] celulasBadFormat = new Celula[MAX_WIDTH][MAX_HEIGHT];
		for(int i = 0; i < MAX_WIDTH; i++) {
			for(int j = 0; j < MAX_HEIGHT; j++) {
					celulasBadFormat[i][j] = new Parede(i, j);
			}
		}
		
		celulasBadFormat[0][0] = new CelulaPadrao(0, 0);
		celulasBadFormat[0][1] = new Saida(0, 1);
		
		Celula[][] celulas = new Celula[MAX_WIDTH][MAX_HEIGHT];
		for(int i = 0; i < MAX_WIDTH; i++) {
			for(int j = 0; j < MAX_HEIGHT; j++) {
					celulas[i][j] = new Parede(i, j);
			}
		}
		
		celulas[0][0] = new CelulaPadrao(0, 0);
	
		
		String[] st;
		
		try {
			while((st = br.readLine().split(" ")) != null && !st[0].equals("END")) {
				int x;
				int y;
				String cellName;
				
				if(st.length > 3 || st.length < 2) {
					System.out.println("celula mal formatada");
					fileBadFormat();
					return celulasBadFormat;
				}
				
				
				cellName = st.length > 2? st[2] : " ";
				
				try {
					x = Integer.parseInt(st[0]);
					y = Integer.parseInt(st[1]);
					
				} catch(Exception e){
					System.out.println("x, y da celula devem ser inteiros");
					fileBadFormat();
					return celulasBadFormat;
				}
				
				if(cellName.equals("Saida")) {
					celulas[x][y] = new Saida(x, y);
				}
				else {
					celulas[x][y] = new CelulaPadrao(x, y);
				}
				
			}
			
		} catch (IOException e) {
			fileBadFormat();
			
			return celulasBadFormat;
			
		}
		
		return celulas;
	}

}
