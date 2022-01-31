import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileReader{
	Scanner scan = null;
	private int normalLevelRows, bossLevelRows;
	private int playerBulletSpeed, playerHealth;
	private String bossPicture;
	private String str;
	
	public void run() {
		try {
			File file = new File("assets/fileIO/customizeGame.txt"); //locate file
 			Scanner scan = new Scanner(file);
 			scanEnemyInfo(scan);
 			scanPlayerInfo(scan);
 			scanBossPicture(scan);
 			checkPlayerHealth();
 			checkPlayerBulletSpeed();
 			printInfo();
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 			System.out.println("Error.");
 		}
	}
	private void printInfo() {
		System.out.println("Normal level Rows: " + getNormalLevelRows());
		System.out.println("Boss level Rows: " + getBossLevelRows());
		System.out.println("Player Bullet Speed: " + getPlayerBulletSpeed());
		System.out.println("Player Hearts: " + getPlayerHealth());
		System.out.println("Boss PNG: " + getBossPicture());

	}
	private void scanPlayerInfo(Scanner scan) {
		scan.nextLine();
		str = scan.nextLine();
		playerBulletSpeed = Integer.parseInt(str);
		scan.nextLine();
		str = scan.nextLine();
		playerHealth = Integer.parseInt(str);
		
	}

	private void scanEnemyInfo(Scanner scan) {
		scan.nextLine();
		str=scan.nextLine();
		normalLevelRows = Integer.parseInt(str);
		scan.nextLine();
		str = scan.nextLine();
		bossLevelRows = Integer.parseInt(str);
	}
	private void scanBossPicture(Scanner scan) {
		scan.nextLine();
		bossPicture = scan.nextLine();
	}
	public void checkPlayerHealth() {
		if(playerHealth < 1) {
			playerHealth = 3;
		}
		if(playerHealth > 15) {
			playerHealth = 15;
		}		
	}
	public void checkPlayerBulletSpeed() {
		if(playerBulletSpeed < 0) {
			playerBulletSpeed = 0;
		}
		if(playerBulletSpeed > 2) {
			playerBulletSpeed = 2;
		}
	}
	public int getNormalLevelRows() {
		return this.normalLevelRows;
	}
	public int getBossLevelRows() {
		return this.bossLevelRows;
	}
	public int getPlayerBulletSpeed() {
		return this.playerBulletSpeed;
	}
	public int getPlayerHealth() {
		return this.playerHealth;
	}
	public String getBossPicture() {
		return this.bossPicture;
	}
}
