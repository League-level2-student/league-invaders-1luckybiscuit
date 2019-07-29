import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	boolean left = false;
	boolean right = false;
	boolean up = false;
	boolean down = false;
	int distance;

	Rocketship(int ex, int wy, int widt, int heit) {
		super(ex, wy, widt, heit);
		speed = 5;
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
			if(up) {
				y-=speed;
			}
			if(down) {
				if(y<LeagueInvaders.HEIGHT - this.height) {
					y+=speed;
				}
			}
			if(left) {
				if(x>0) {
				x-=speed;
				}
			}
			if(right) {
				if(x<LeagueInvaders.WIDTH - this.width) {
					x+=speed;
				}
			}
	}

	void draw(Graphics epic) {
		epic.drawImage(GamePanel.rocketImg, x, (int)y, width, height, null);
	}
}
