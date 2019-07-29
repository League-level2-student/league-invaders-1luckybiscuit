import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {
	int pattern;
	int difficulty = 3;
	int speed;
	int yPos = 2;
	int xPos = -2;
	int xxPos = 2;
	int counter = 0;
	int ccounter = 0;
	int cccounter = 0;
	Random generator = new Random();
	int genInt = generator.nextInt(10);
	Alien(int ex, int wy, int widt, int heit) {
		super(ex, wy, widt, heit);
		pattern = generator.nextInt(4);
		Random speeder = new Random();
		speed = (speeder.nextInt(5) + 1)*difficulty;
		// TODO Auto-generated constructor stub
	}
	int modX = x = x + genInt*speed;
	void update() {
		super.update();
		if(y<=0) {
			y++;
		}else {
			if(pattern == 0) {
				
				y += speed;
			}
			if(pattern == 1) {
				y = y * 1.03 + speed/3;
			}
			if(pattern == 2) {
				if(counter == genInt) {
					yPos = -yPos;
				}
				if(counter == genInt*2) {
					counter = 0;
					xPos = -xPos;
				}
				counter++;
				y += speed*yPos + difficulty;
				modX += speed*xPos;
				x = modX;
			}
			if(pattern == 3) {
				if(ccounter == genInt) {
					ccounter = 0;
					xxPos = -xxPos;
				}
				ccounter++;
				x += speed*2*xxPos;
				y += difficulty;
				
			}
			if(pattern == 4) {
				if(cccounter == genInt+10) {
					cccounter = 0;
					y += 11*difficulty + genInt*difficulty;
				}
				cccounter++;
			}
		}
	}
	void draw(Graphics epic) {
		epic.drawImage(GamePanel.alienImg, x, (int) y, width, height, null);
	}
}
