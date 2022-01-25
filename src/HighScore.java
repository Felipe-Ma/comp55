import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import acm.graphics.GImage;
import acm.graphics.GObject;

public class HighScore extends GraphicsPane {
	private GImage backround;
    private MainApplication program;
    private GButton score;
    private GButton score2;
    private GButton score3; 
    private GButton score4;
    private GButton score5;
    private GButton box1;
	private final int BUTTON_SIZE_X = 300;
	private final int BUTTON_SIZE_Y = 200;
	private final int BUTTON_POS_Y = 100;
    public int Score;
    private int F1 = 81000;
    private int F2 = 74560;
    private int F3 = 69000;
    private int F4 = 42000;
    private int F5 = 25300;
    
    File back = new File ("assets/bgm/BACK.wav");

    Color c = new Color(0f,0f,1f,.2f );
    
    public void setScore(int Score) {
    	this.Score = Score;
    }
    
    public HighScore(MainApplication app) {
        super();
        backround = new GImage("assets/sprites/animatedMenu.gif");
        program = app;
        box1 = new GButton("Escape", 4, 549, 300/3, 200/5);
        score = new GButton("" + Score, 350, BUTTON_POS_Y, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
        score2 = new GButton("" + Score, 350, BUTTON_POS_Y+45, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
        score3 = new GButton("" + Score, 350, BUTTON_POS_Y+90, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
        score4 = new GButton("" + Score, 350, BUTTON_POS_Y+135, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
        score5 = new GButton("" + Score, 350, BUTTON_POS_Y+180, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
        score.setColor(Color.WHITE);
        score2.setColor(Color.WHITE);
        score3.setColor(Color.WHITE);
        score4.setColor(Color.WHITE);
        score5.setColor(Color.WHITE);
        score.setFillColor(c);
        score2.setFillColor(c);
        score3.setFillColor(c);
        score4.setFillColor(c);
        score5.setFillColor(c);
    }

    @Override
    public void showContents() {
    	program.add(backround);
        program.add(box1);
        program.add(score);
        program.add(score2);
        program.add(score3);
        program.add(score4);
        program.add(score5);
        score.setText("" + F1);
        score2.setText("" + F2);
        score3.setText("" + F3);
        score4.setText("" + F4);
        score5.setText("" + F5);
        if(Score > F1) {
            score.setText("" + Score);
            F1 = Score;
            program.add(score);
        }
        else if(Score > F2) {
        	score2.setText("" + Score);
        	F2 = Score;
        	program.add(score2);
        }
        else if(Score > F3) {
        	score3.setText("" + Score);
        	F3 = Score;
        	program.add(score3);
        }
        else if(Score > F4) {
        	score4.setText("" + Score);
        	F4 = Score;
        	program.add(score4);
        }
        else if(Score > F5) {
        	score5.setText("" + Score);
        	F5 = Score;
        	program.add(score5);
        }
    }

    @Override
    public void hideContents() {
        program.removeAll();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        GObject obj = program.getElementAt(e.getX(), e.getY());
        if (obj == box1) {
        	JukeBox.STOP();
        	JukeBox.PLAY(back);
            program.switchToMenu();
        }
    }
}