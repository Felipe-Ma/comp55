import java.awt.Color;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program;
	private GImage background;
	private GImage menu;
	private GButton rect;
	private GButton rect2;
	private GButton rect3;
	private GButton rect4;
	private final int BUTTON_SIZE_X = 200;
	private final int BUTTON_SIZE_Y = 100;
	private final int STATIC_ADDER = 50;
	Color c = new Color(0f,0f,1f,.2f );

	public MenuPane(MainApplication app) {
		super();
		program = app;
		background = new GImage("assets/sprites/animatedMenu.gif");
		menu = new GImage("assets/sprites/menu.png");
		rect = new GButton("Play", app.getWidth()/2-BUTTON_SIZE_X/2, app.getHeight()/2-BUTTON_SIZE_Y/2 - (3*STATIC_ADDER), BUTTON_SIZE_X, BUTTON_SIZE_Y);
		rect.setFillColor(c);
		rect2 = new GButton("Setting", app.getWidth()/2-BUTTON_SIZE_X/2, app.getHeight()/2-BUTTON_SIZE_Y/2- (STATIC_ADDER*.5), BUTTON_SIZE_X, BUTTON_SIZE_Y);
		rect2.setFillColor(c);
		rect3 = new GButton("High Score", app.getWidth()/2-BUTTON_SIZE_X/2, app.getHeight()/2-BUTTON_SIZE_Y/2 + (STATIC_ADDER*2), BUTTON_SIZE_X, BUTTON_SIZE_Y);
		rect3.setFillColor(c);
		rect4 = new GButton("Quit", app.getWidth()/2-BUTTON_SIZE_X/2, app.getHeight()/2-BUTTON_SIZE_Y/2 + (STATIC_ADDER*4.5), BUTTON_SIZE_X, BUTTON_SIZE_Y);
		rect4.setFillColor(c);
		
		rect.setColor(Color.white);
		rect2.setColor(Color.white);
		rect3.setColor(Color.white);
		rect4.setColor(Color.white);
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(menu);
		program.add(rect);
		program.add(rect2);
		program.add(rect3);
		program.add(rect4); 
	}

	@Override
	public void hideContents() {
		program.removeAll();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect) {
			program.switchToPlay();
		}
		if (obj == rect2) {
			program.switchToSetting();
		}
		if (obj == rect3) {
			program.switchToHighScore();
		}
		if (obj == rect4) {
			System.exit(0);
		}
	}
}
