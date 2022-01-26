import java.awt.Color;
import java.util.ArrayList;
import acm.program.GraphicsProgram;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PlayerShip {
	public GImage playerShip;
	private ArrayList<GImage> hearts = new ArrayList<GImage>(3);
	public healthSystem playerShipHealth;
	public scoreSystem playerScore;
	public int x = 400, y = 400;
	private GraphicsProgram screen;
	public Bullets bullets;
	private final static int SPEED = 15;
	private final static int WIDTH = 50;
	private final static int HEIGHT = 50;
	private GLabel score = new GLabel ("Score: ", 10, 590);
	private int bulletMultiplier;


	//Function adds game screen to PlayerShip class
	public PlayerShip(GraphicsProgram screen) {
		playerShipHealth = new healthSystem(shipType.PLAYERSHIP, 3, false);
		this.screen = screen;
		bullets = new Bullets();
	}
	
	
	public void update() {
		updatePlayerBullet();
		updatePlayerScore();
	}
	
	//change speed here
	public void fireBullet(){
		bullets.addBullet(new Bullet(x+12,y, -15*bulletMultiplier, 1, true, screen));
	}
	private void updatePlayerBullet() {
		for(Bullet b: bullets.bullets) {
			b.update();
		}
	}
	private void updatePlayerScore() {
	        score.setLabel("Score: " + playerScore.getScore());
	 
	}
	
	//Function creates playerShip and adds it to game screen
	public void makePlayerShip() {
		playerShip = new GImage("assets/sprites/UNIT002.gif", x, y);
		File file = new File("/Users/felipe/Downloads/captmidn.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan.nextLine(); // scan next bad line
		scan.nextLine();
		scan.nextLine();
		String str = scan.nextLine();
		bulletMultiplier = Integer.parseInt(str);
		System.out.println("Player Entered " + bulletMultiplier + " player speed");
		screen.add(playerShip);
		for(int i = 0; i < 3; i++) {
			int multipler = i*30;
			hearts.add(new GImage("assets/sprites/heart.png", 770, 500+multipler));
			screen.add(hearts.get(i));
			//
			/*
			File file = new File("/Users/felipe/Downloads/captmidn.txt");
			Scanner scan = null;
			try {
				scan = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scan.nextLine(); // scan next bad line
			String str = scan.nextLine();
			int playerSpeed = Integer.parseInt(str);
			System.out.println("Player Entered " + playerSpeed + " player speed");
			*/
			//
			playerScore = new scoreSystem(0, 3, 0);
			score.setLabel("Score: " + playerScore.getScore());
			score.setColor(Color.WHITE);
			screen.add(score);
		}
	}
	
	public void removeHeart() {
		score.setLabel("Score: 1");
		screen.remove(hearts.get(0));
		hearts.remove(0);
	}
	
	public int getPlayerX() {
		return this.x;
	}
	public int getPlayerY() {
		return this.y;
	}
	public int getPlayerWidth() {
		return WIDTH;
	}
	public int getPlayerHeight() {
		return HEIGHT;
	}
	
	//Function controls playerShip image movement
	public void move(int key) {
		if (key == 1) {
			if(y > 300) {
				y -= SPEED;
				playerShip.move(0, -SPEED);
			}

		} else if (key == 2) {
			if(x > 0) {
				x -= SPEED;
				playerShip.move(-SPEED, 0);
			}

		} else if (key == 3) {
			if(y < 540) {
				y += SPEED;
				playerShip.move(0, SPEED);
			}

		} else if (key == 4){
			if(x < 740) {
				x += SPEED;
				playerShip.move(SPEED, 0);
			}
			
		} else if (key == 5) {
			fireBullet();
			update();
		}
		
	}

	
}