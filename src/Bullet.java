import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Bullet{
	private GraphicsProgram screen;
	private static final int WIDTH = 25;
	private static final int HEIGHT = 25;
	private boolean friendlyBullet;
	double dy; //velocity
	int damage;
	private GImage sprite;
	int x; //bullet x coordinate
	int y; //bullet y coordinate

	public Bullet(int x, int y, double dy, int damage, boolean friendlyBullet, GraphicsProgram screen){
		this.x = x;
		this.y = y;
		this.dy = dy;
		this.damage = damage;
		this.friendlyBullet = friendlyBullet;
		this.screen = screen;
		
		if(friendlyBullet) {
			sprite = new GImage("assets/sprites/torpedo.gif",x,y);
		}
		else {
			sprite = new GImage("assets/sprites/bossBullets.gif",x,y);
		}
		
		screen.add(sprite);
	}
	public int returnBulletX() {
		return this.x;
	}
	public int returnBulletY() {
		return this.y;
	}
	public boolean returnFriendly() {
		return friendlyBullet;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
		screen.remove(sprite);
	}
	
	public void removeBullet() {
		screen.remove(sprite);
	}
	
		
	public void update() {
		y += dy;
		sprite.move(0, dy);
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
}
