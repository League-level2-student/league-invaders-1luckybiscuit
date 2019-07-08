import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed = 10;
	Projectile(int ex, int wy, int widt, int heit) {
		super(ex, wy, widt, heit);
		// TODO Auto-generated constructor stub
	}
	void update() {
		y -= 5;
		if(y<0) {
			isAlive = false;
		}
	}
	void draw(Graphics epic) {
		epic.setColor(Color.RED);
		epic.fillRect(x, y, width, height);
	}
}
