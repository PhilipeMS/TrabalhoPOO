import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class Dungeon extends JPanel implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6198124569792911337L;
	private static final int SCREEN_WIDTH = 750;
	private static final int SCREEN_HEIGTH = 750;
	private static final int CELL_SIZE = 25;
	//Tabuleiro 30 por 30
	private static final int DELAY = 25;
	
	private Timer timer;
	private Player player;
	
	private ArrayList<Componente> componentes;
	private Celula[][] celulas;
	private Montador montador;
	private Controlador controlador;
	
	public Dungeon() {
		setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGTH));
		setBackground(new Color(0, 0, 0));
		
		montador = new Montador();
		controlador = new Controlador();
		
		player = montador.createPlayer();
		componentes = montador.createComponents();
		celulas = montador.createCells();
	
		controlador.setPlayer(player);
		
		timer = new Timer(DELAY, this);
		timer.start();
		
	}
	
	//KEY EVENTS
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		controlador.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	//
	
	//ACTIONS

	@Override
	public void actionPerformed(ActionEvent e) {
		player.tick(componentes, celulas);
		
		cellsInteraction();
		componentsInteraction();
		
		controlador.playerAction(componentes, celulas);
		controlador.setPlayerActionNull();
		
		repaint();
		
	}
	
	public void cellsInteraction() {
		
		for(Celula[] celulaArray: celulas) {
			for(Celula celula: celulaArray) {
				celula.interact(player, componentes, celulas);
			}
		}
	}
	
	public void componentsInteraction() {
		for(Componente componente: componentes) {
			componente.tick(player, componentes, celulas);
			componente.interact(player, componentes, celulas);
		}
	}
	
	//
	
	//DRAW
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawBackground(g);
		
		for(Celula[] celulaArray: celulas) {
			for(Celula celula: celulaArray) {
				celula.draw(g, this);
			}
		}
		
		player.draw(g, this);
		
		for(Componente componente: componentes) {
			componente.draw(g, this);
		}
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void drawBackground(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		for(int row = 0; row < (int)SCREEN_HEIGTH/CELL_SIZE; row++) {
			for(int col = 0; col < (int)SCREEN_WIDTH/CELL_SIZE; col++) {
				if((row+col) % 2 == 1) {
					g.fillRect(row*CELL_SIZE, col*CELL_SIZE, CELL_SIZE, CELL_SIZE);
				}
			}
		}
	}
	
	
}
