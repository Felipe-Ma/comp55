import java.util.ArrayList;

public class Bullets {
public ArrayList<Bullet>bullets;
	

	public Bullets() {
		bullets = new ArrayList<>();
	}
	
	public void addBullet(Bullet b) {
		bullets.add(b);
	}
	
	//clearBullets will clear the entire bullet list
	public void clearBullet() {
		for(int i = bullets.size() - 1; i >= 0; i--) {
			bullets.get(i).removeBullet();
		}
		bullets.clear();
	}
}
