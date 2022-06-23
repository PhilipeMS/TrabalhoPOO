import javax.swing.*;

public class App {
	
	private static final String TITLE = "WARLOCK'S TOWER: RETURN";
	
	private static void initWindow() {
		JFrame window = new JFrame(TITLE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dungeon dungeon = new Dungeon();
		window.add(dungeon);
		window.addKeyListener(dungeon);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initWindow();
			}
		});
	}
}
