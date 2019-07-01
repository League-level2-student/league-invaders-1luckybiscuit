import java.awt.Graphics;

public class GameObject {
	int x;
    int y;
    int width;
    int height;
    boolean isAlive;
    GameObject (int ex, int wy, int widt, int heit) {
    	x = ex;
    	y = wy;
    	width = widt;
    	height = heit;
    	isAlive = true;
    }
    void update() {
    }
    void draw(Graphics epic) {
    }
}
