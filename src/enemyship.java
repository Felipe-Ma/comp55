import java.awt.Color;
import java.util.ArrayList;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class enemyship extends GraphicsProgram {
    private RandomGenerator rgen;
    private GraphicsProgram screen;
    public shipType typeShip;
    public healthSystem bossHealth;
    
    public static final int SIZE = 25;
    public static final int SPEED = 2;
    public static final int MS = 50;
    public static final int WINDOW_HEIGHT = 600;
    public static final int WINDOW_WIDTH = 800;
    public int numTimes = -1;
    public Boolean right = true;
    private int x, y;    
    public GImage enemy;
    public Bullets bullets;
    private ArrayList<GRect> bossHealthDisplay = new ArrayList<GRect>(20);
    private GRect overBossHealth;
    private GLabel nameBossHealth = new GLabel("Boss Health", 370 , 575);
    
    //Each EnemyShip has its own coordinates, use x and y to locate it 
    public enemyship(shipType typeShip, int x, int y, GraphicsProgram screen) { //location of the ship
        this.typeShip = typeShip;
        this.x=x;
        this.y=y;
        this.screen = screen;
        bullets = new Bullets();
        rgen = RandomGenerator.getInstance();
    
    }    
    
    public int getEnemyX() {
    	return x;
    }
    public int getEnemyY() {
    	return y;
    }
    
    public void update() {

        updateBullet();
        int rand = rgen.nextInt(1500);
        if(typeShip == shipType.BOSSSHIP) {
            if(rand < 200) {
                fireBullet();
            }
        }else if(typeShip == shipType.ENEMYSHIP) {
            if(rand < 15)
                fireBullet();
        }
        }
    public void updateBullet() {
        for(Bullet b : bullets.bullets) {
            b.update();
        }
    } 
    
    protected void finalize() {
		bullets.clearBullet();
	}
    
    public void fireBullet(){
        bullets.addBullet(new Bullet(x,y, 10, 1, false, screen));
    }  
    
    public void run() {
        rgen = RandomGenerator.getInstance();
        makeBoss();
    }
    
    public void makeEnemy() {
        enemy = new GImage("assets/sprites/badguy.gif", x, y);
        screen.add(enemy);
    }
    
    
    
    public void makeBoss() {
        enemy = new GImage("assets/sprites/boss.gif");
        bossHealth = new healthSystem(shipType.BOSSSHIP, 20, false);
        screen.add(enemy); 
        for(int i = 150; i < 650; i += 25) {
        	bossHealthDisplay.add(new GRect(i, 575, 25, 25));
        }
        for (int i = 0; i < 20; i++) {
        	bossHealthDisplay.get(i).setColor(Color.RED);
        	bossHealthDisplay.get(i).setFilled(true);
        	screen.add(bossHealthDisplay.get(i));
        }
        overBossHealth = new GRect(150, 575, 500, 25);
        overBossHealth.setColor(Color.WHITE);
        screen.add(overBossHealth);
        nameBossHealth.setColor(Color.WHITE);
        screen.add(nameBossHealth);
    }
    
    public void subtractBossHealth() {
    	screen.remove(bossHealthDisplay.get(bossHealthDisplay.size()-1));
    	bossHealthDisplay.remove(bossHealthDisplay.size()-1);
    	bossHealth.subtractHealth();
    	
    }
    
    //Utilizes the timer so that it will move left and right everytime the timer reaches 5
    public void moveEnemy() {
        if(typeShip == shipType.ENEMYSHIP) {
            if(numTimes == 5) {
                if(right) {
                    right = false;
                    numTimes =0;
                }
                else if(!right) {
                    right = true;
                    numTimes = 0;
                }
            }
            if(right) {
                x += 2;
                enemy.move(2, 0);       
            }
            if(!right) {
                x +=-2;
                enemy.move(-2, 0);
            }
        }
        else {
            if(numTimes == 140) {
                if(right) {
                    right = false;
                    numTimes = 0;
                }
                else if(!right) {
                    right = true;
                    numTimes = 0;
                }
            }
            if(right) {
                x +=5;
                enemy.move(5, 0);
            }
            if(!right) {
                x +=-5;
                enemy.move(-5, 0);
            }
        }
    }
    
    //Call this to Delete the Gobject
    public void killEnemy(GraphicsProgram screen) {
        screen.remove(enemy);
    }
    
    public void init() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}