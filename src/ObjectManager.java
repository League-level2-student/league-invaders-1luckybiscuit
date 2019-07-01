import java.awt.Graphics;

public class ObjectManager {
	Rocketship raccoon;
	ObjectManager(Rocketship Apollo) {
		raccoon = Apollo;
	}
	void update() {
		raccoon.update();
	}
	void draw(Graphics eh) {
		raccoon.draw(eh);
	}
}
