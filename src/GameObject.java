import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
    double y;
    int width;
    int height;
    boolean isAlive;
    Rectangle colBox;
    GameObject (int ex, int wy, int widt, int heit) {
    	x = ex;
    	y = wy;
    	width = widt;
    	height = heit;
    	isAlive = true;
    	colBox = new Rectangle(x,(int) y,width,height);
    }
    void update() {
    	colBox.setBounds(x,(int)y,width,height);
    }
    void draw(Graphics epic) {
    }
}
