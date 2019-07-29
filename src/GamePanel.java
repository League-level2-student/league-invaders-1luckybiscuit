import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	public static BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;
    public static BufferedImage firstImg;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	int lastScore;
	boolean pewpew = true;
	Font titleFont;
	Font instructFont;
	Font deadFont;
	Rocketship rock = new Rocketship(250, 700, 100, 100);
	ObjectManager raccoon = new ObjectManager(rock);
	GamePanel() {
		time = new Timer(1000/60,this);
		titleFont = new Font("Arial", Font.PLAIN, 45);
		instructFont = new Font("Arial", Font.PLAIN, 20);
		deadFont = new Font("Arial", Font.PLAIN, 70);
		try {
            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.jpg"));
            firstImg = ImageIO.read(this.getClass().getResourceAsStream("firstScreen.png"));
		} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}
	}
	void updateMenuState() {
		
	}
	void updateGameState() {
		raccoon.update();
		raccoon.manageEnemies();
		raccoon.checkCollision();
		raccoon.purgeObjects();
		if(rock.isAlive == false) {
			currentState = END_STATE;
			rock = new Rocketship(250, 700, 100, 100);
			lastScore = raccoon.score;
			raccoon = new ObjectManager(rock);
		}
	}
	void updateEndState() {
	
	}
	void drawMenuState(Graphics sad) {
		sad.setColor(Color.BLUE);
		sad.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		sad.drawImage(GamePanel.firstImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		sad.setFont(titleFont);
		sad.setColor(Color.YELLOW);
		sad.drawString("LASAGNA INVADERS", 25, 300);
		sad.setFont(instructFont);
		sad.drawString("Press ENTER to start", 150, 400);
		sad.drawString("Press SPACE for mission debrief", 120, 500);
	}
	void drawGameState(Graphics boy) {
		boy.drawString(Integer.toString(raccoon.score), 10, 20);
		boy.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		raccoon.draw(boy);
	}
	void drawEndState(Graphics hours) {
		hours.setColor(Color.BLACK);
		hours.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		hours.setFont(deadFont);
		hours.setColor(Color.RED);
		hours.drawString("GAME OVER", 40, 300);
		hours.setFont(instructFont);
		hours.drawString("You fought off " + lastScore + " Garfields!", 130, 400);
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
			if(currentState == 1) {
				rock.isAlive = false;
			}else{
			currentState++;
			}
			if(currentState == 3) {
				currentState = 0;
			}
		}
		if(pewpew) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				raccoon.addProjectile(new Projectile(rock.x + 30, (int) rock.y, 20, 40));
				pewpew = false;
				if(currentState == MENU_STATE){
		            JOptionPane.showMessageDialog(null, "Garfield has used his shadow clone jutsu and is raiding all of the lasagna in the kitchen!\n                              Only Pookie has the power to stop him...\n"
		            		+ "                                           ARROW KEYS to move\n"
		            		+ "                                         SPACEBAR to shoot lasers");
				}
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			rock.up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			rock.down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			rock.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rock.right = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			rock.up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			rock.down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			rock.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rock.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			pewpew = true;
		}
	}
}
