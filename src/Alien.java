import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {
	int pattern;
	int speed;
	Alien(int ex, int wy, int widt, int heit) {
		super(ex, wy, widt, heit);
		Random generator = new Random();
		pattern = 1;
		Random speeder = new Random();
		speed = speeder.nextInt(5) + 1;
		// TODO Auto-generated constructor stub
	}
	void update() {
		if(pattern == 0) {
			y += speed;
		}
		if(pattern == 1) {
			y++;
			y = y*2;
		}
		if(pattern == 2) {
			int ogY = y + 20;
			int ogX = x + 20;
			if(y <= ogY) {
				y += 2;
			}else if(y > ogY + 20) {
				y -= 2;
			}
			if(x > ogX - 20) {
				x += 2;
			}else if(x > ogX + 20) {
				x -= 2;
			}
			ogY++;
			ogX++;
		}
		if(pattern == 3) {
			System.out.println("oof");
			y++;
			
		}
		if(pattern == 4) {
			System.out.println("aff");
			y = y^2;
		}
	}
	void draw(Graphics epic) {
		epic.setColor(Color.YELLOW);
		epic.fillRect(x, y, width, height);
	}
}
