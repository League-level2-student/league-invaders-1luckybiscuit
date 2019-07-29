import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rock;
	ArrayList<Projectile> projectileList = new ArrayList();
	ArrayList<Alien> alienList = new ArrayList();
	long enemyTime;
	Random generator = new Random();
	int enemyWait = generator.nextInt(5)*100;
	int score = 0;
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
	int getScore() {
		return score;
	}
	void checkCollision() {
		for(Alien a: alienList) {
			if(rock.colBox.intersects(a.colBox)) {
				rock.isAlive = false;
			}
			for(Projectile p: projectileList) {
				if(a.colBox.intersects(p.colBox)) {
					a.isAlive = false;
					p.isAlive = false;
					score++;
				}
			}
			if(a.y > LeagueInvaders.HEIGHT) {
				a.isAlive = false;
			}
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
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), -100, 100, 100));
			enemyTime = System.currentTimeMillis();
			enemyWait = generator.nextInt(5)*100;
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
