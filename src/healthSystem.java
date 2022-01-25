
public class healthSystem {
	private shipType typeShip;
	private int health;
	private boolean isDestroyed;
	
	public healthSystem(shipType typeShip, int health, boolean isDestroyed) {
		this.typeShip = typeShip;
		this.health = health;
		this.isDestroyed = isDestroyed;
	}
	
	public shipType getShipType() {
		return this.typeShip;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHealth() {
		return this.health;
	}
	public boolean isDestroyed() {
		return isDestroyed;
	}
	public void subtractHealth() {
		this.health -= 1;
		if(health == 0) {
			isDestroyed = true;
		}
	}
}