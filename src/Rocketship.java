import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	Rocketship(int ex, int wy, int widt, int heit) {
		super(ex, wy, widt, heit);
		speed = 5;
		// TODO Auto-generated constructor stub
	}
	void update() {
		
	}
	void draw(Graphics epic) {
		epic.setColor(Color.BLUE);
        epic.fillRect(x, y, width, height);
	}
}
