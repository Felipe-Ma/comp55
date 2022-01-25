import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import acm.program.GraphicsProgram;

public class MainApplication extends GraphicsProgram {
	
	File menuBGM = new File ("assets/bgm/Menu.wav");
	File test = new File ("assets/bgm/TestAudio.wav");
	File Game = new File("assets/bgm/fight!.wav");
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";

	private GraphicsPane curScreen;
	private SomePane somePane;
	private MenuPane menu;
	private SettingPane setting;
	private HighScore HighScore;
	private Game gameScreen;
	private boolean game = false;
	
	protected void setupInteractions() {
		requestFocus();
		addKeyListeners();
		addMouseListeners();
	}
	
	protected void switchToScreen(GraphicsPane newScreen) {
		if(curScreen != null) {
			curScreen.hideContents();
		}
		newScreen.showContents();
		curScreen = newScreen;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mousePressed(e);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseReleased(e);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseClicked(e);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseDragged(e);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(curScreen != null) {
			curScreen.mouseMoved(e);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyPressed(e);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyReleased(e);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(curScreen != null) {
			curScreen.keyTyped(e);
		}
	}
	

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		somePane = new SomePane(this);
		menu = new MenuPane(this);
		setting = new SettingPane(this);
		HighScore = new HighScore(this);
		gameScreen = new Game(this);
		setupInteractions();
		switchToMenu();
	}

	public void switchToSetting() {
		JukeBox.STOP();
		switchToScreen(setting);
		JukeBox.PLAY(test);
	}
	
	public void switchToMenu() {
		switchToScreen(menu);
		JukeBox.PLAY(menuBGM);
		
	}

	public void switchToSome() {
		somePane.score = gameScreen.playerShip.playerScore.getScore();
		somePane.death = gameScreen.bossDead;
		switchToScreen(somePane);
	}
	
	public void switchToPlay() {
		JukeBox.STOP();
		switchToScreen(gameScreen);
		game = true;
		JukeBox.PLAY(Game);
	}
	
	public void switchToHighScore() {
		JukeBox.STOP();
		if(game) {
			HighScore.setScore(gameScreen.playerShip.playerScore.getScore());
		}
		switchToScreen(HighScore);
		JukeBox.PLAY(test);
	}
	
	public static void main(String[] args) {
		new MainApplication().start();
	}

	public int getForward() {
		return setting.getForwardLoc();
	}
	
	public int getLeft() {
		return setting.getLeftLoc();
	}
	
	public int getDown() {
		return setting.getDownLoc();
	}
	
	public int getRight() {
		return setting.getRightLoc();
	}
	
	public int getShoot() {
		return setting.getShootLoc();
	}
	
	public boolean getGame() {
		return game;
	}

}
