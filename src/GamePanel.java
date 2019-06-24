import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font instructFont;
	Font deadFont;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	GamePanel() {
		time = new Timer(1000/60,this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		instructFont = new Font("Arial", Font.PLAIN, 20);
		deadFont = new Font("Arial", Font.PLAIN, 70);
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		rocket.update();
	}
	void updateEndState() {
	
	}
	void drawMenuState(Graphics sad) {
		sad.setColor(Color.BLUE);
		sad.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		sad.setFont(titleFont);
		sad.setColor(Color.YELLOW);
		sad.drawString("LEAGUE INVADERS", 25, 300);
		sad.setFont(instructFont);
		sad.drawString("Press ENTER to start", 150, 500);
	}
	void drawGameState(Graphics boy) {
		rocket.draw(boy);
	}
	void drawEndState(Graphics hours) {
		hours.setFont(deadFont);
		hours.setColor(Color.BLACK);
		hours.drawString("GAME OVER", 40, 300);
		hours.setFont(instructFont);
		hours.drawString("You killed " + "so many " + "enemies!", 120, 400);
		hours.drawString("Press ENTER to restart", 140, 500);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if(currentState == MENU_STATE){
            updateMenuState();
		}else if(currentState == GAME_STATE){
            updateGameState();
		}else if(currentState == END_STATE){
            updateEndState();
		}
	}
	void startGame() {
		time.start();
	}
	@Override

	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){
           drawMenuState(g);
		}else if(currentState == GAME_STATE){
           drawGameState(g);
		}else if(currentState == END_STATE){
           drawEndState(g);
		}
	        }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		// Does not apply to arrow keys
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if(currentState == 3) {
				currentState = 0;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.y-=rocket.speed;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.y+=rocket.speed;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.x-=rocket.speed;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.x+=rocket.speed;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
