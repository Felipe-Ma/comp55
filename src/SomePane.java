import java.awt.Color;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class SomePane extends GraphicsPane {
    private MainApplication program; 
    private GImage background;
    private GButton returnToMenu;
    private GButton gameOver;
    private GButton winOver;
    private GButton winReturnToMenu;
    public GButton scores;
    public boolean death = false;
    public int score = 0;

    public SomePane(MainApplication app) {
    		this.program = app;
    		gameOver = new GButton("Game Over", 200, 20, 400, 300);
    		returnToMenu = new GButton("Back to menu", 300, 300, 200, 100);
    		background = new GImage("assets/sprites/animatedMenu.gif");
        	gameOver.setFillColor(new Color(0f,0f,0f,0f ));
        	returnToMenu.setFillColor(new Color(0.9f, 0f, 0f, 0.2f));
        	returnToMenu.setColor(Color.WHITE);
        	gameOver.setColor(Color.red);

    		winOver = new GButton("You Win!", 200, 20, 400, 300);
    		winReturnToMenu = new GButton("Back to menu", 300, 300, 200, 100);
    		background = new GImage("assets/sprites/animatedMenu.gif");
        	winOver.setFillColor(new Color(0f,0f,0f,0f ));
        	winReturnToMenu.setFillColor(new Color(0f, 0.9f, 0f, 0.2f));
        	winReturnToMenu.setColor(Color.WHITE);
        	winOver.setColor(Color.green);
        	
        	scores = new GButton("Score: ", 285, 200, 100, 100);
        	scores.setFillColor(new Color(0f,0f,0f,0f ));
        	scores.setColor(Color.WHITE);
    }
    
    @Override
    public void showContents() {
        program.add(background);
    	if (!death) {
    		program.add(gameOver);
    		program.add(returnToMenu);
    		scores.setText("Your score is: " + score);
    		program.add(scores);
    	} else {
    		program.add(winOver);
    		program.add(winReturnToMenu);
    		scores.setText("Your score is: " + score);
    		program.add(scores);
    	}
    }

    @Override
    public void hideContents() {
    	if (!death) {
    		program.remove(gameOver);
    		program.remove(returnToMenu);
    	} else {
    		program.remove(winOver);
    		program.remove(winReturnToMenu);
    	}
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GObject obj = program.getElementAt(e.getX(), e.getY());
        if (obj == returnToMenu || obj == winReturnToMenu) {
        	JukeBox.STOP();
            program.switchToMenu();
        }
    }
}