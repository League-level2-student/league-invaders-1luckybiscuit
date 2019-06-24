import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	final static int WIDTH = 500;
	final static int HEIGHT = 800;
	GamePanel gamePanel;
	public static void main(String[] args) {
		LeagueInvaders li = new LeagueInvaders();
		li.setup();
	}
	LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
	}
	void setup() {
		frame.add(gamePanel);
		frame.addKeyListener(gamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        gamePanel.startGame();
	}
}

