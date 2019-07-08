import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rock;
	ArrayList<Projectile> projectileList = new ArrayList();
	ArrayList<Alien> alienList = new ArrayList();
	long enemyTime;
	int enemyWait = 500;
	ObjectManager(Rocketship Apollo) {
		rock = Apollo;
	}
	void update() {
		rock.update();
		for(int i = 0;i < projectileList.size();i++) {
			projectileList.get(i).update();
		}
		for(int i = 0;i < alienList.size();i++) {
			alienList.get(i).update();
		}
	}
	void draw(Graphics eh) {
		rock.draw(eh);
		for(int i = 0;i < projectileList.size();i++) {
			projectileList.get(i).draw(eh);
		}
		for(int i = 0;i < alienList.size();i++) {
			alienList.get(i).draw(eh);
		}
	}
	void addProjectile(Projectile vomit) {
		projectileList.add(vomit);
	}
	void addAlien(Alien vomit) {
		alienList.add(vomit);
	}
	void manageEnemies() {
		if(System.currentTimeMillis() - enemyTime >= enemyWait) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
			enemyTime = System.currentTimeMillis();
		}
	}
	void purgeObjects() {
		for(int i = 0;i < projectileList.size();i++) {
			if(projectileList.get(i).isAlive == false) {
				projectileList.remove(i);
			}
		}
		for(int i = 0;i < alienList.size();i++) {
			if(alienList.get(i).isAlive == false) {
				alienList.remove(i);
			}
		}
	}
}
