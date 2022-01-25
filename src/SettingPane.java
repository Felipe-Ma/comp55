import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import acm.graphics.GImage;
import acm.graphics.GObject;


public class SettingPane extends GraphicsPane {
	
	private MainApplication program;
	private File back = new File("assets/bgm/BACK.wav");
	private GImage backround;
	private GButton rect;
	private GButton rect2;
	private GButton rect3;
	private GButton rect4;
	private GButton rect5;
	private GButton ERROR;
	private GButton escape;
	private GParagraph para0;
	private GParagraph para;
	private GParagraph para2;
	private GParagraph para3;
	private GParagraph para4;
	private GParagraph para5;
	private boolean ShootRec;
	private boolean UpRec;
	private boolean LeftRec;
	private boolean DownRec;
	private boolean RightRec;
	private char Forward = 'W';
	private char Left = 'A';
	private char Down = 'S';
	private char Right = 'D';
	private char Shoot = 'K';
	private int ShootLoc = 32;
	private int ForwardLoc = 87;
	private int LeftLoc = 65;
	private int DownLoc = 83;
	private int RightLoc = 68;
	private final int BUTTON_SIZE_X = 300;
	private final int BUTTON_SIZE_Y = 200;
	private final int BUTTON_POS_Y = 100;
	Color c = new Color(0f,0f,1f,.2f );

	public SettingPane(MainApplication app) {
		super();
		program = app;
		backround = new GImage("assets/sprites/animatedMenu.gif");
		para0 = new GParagraph("HOW TO PLAY", 300, 50);
		para0.setFont("Arial MS-24");
		rect = new GButton(Forward, 259, BUTTON_POS_Y, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para = new GParagraph("Up", 404, BUTTON_POS_Y+25);
		para.setFont("Arial MS-24");
		rect2 = new GButton(Left, 259, BUTTON_POS_Y+45, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para2 = new GParagraph("Left", 404, BUTTON_POS_Y+70);
		para2.setFont("Arial MS-24");
		rect3 = new GButton(Down, 259, BUTTON_POS_Y+90, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para3 = new GParagraph("Down", 404, BUTTON_POS_Y+115);
		para3.setFont("Arial MS-24");
		rect4 = new GButton(Right, 259, BUTTON_POS_Y+135, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		para4 = new GParagraph("Right", 404, BUTTON_POS_Y+160);
		rect5 = new GButton(Shoot, 259, BUTTON_POS_Y+180, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		rect5.setText("Space");
		para5 = new GParagraph("Shoot", 404, BUTTON_POS_Y+205);
		para5.setFont("Arial MS-24");
		para4.setFont("Arial MS-24");
		escape = new GButton("Escape", 4, 549, BUTTON_SIZE_X/3, BUTTON_SIZE_Y/5);
		ERROR = new GButton("Invalid key selection", 259, BUTTON_POS_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y, Color.white);
		ERROR.setFillColor(Color.black);
		ERROR.setColor(Color.white);
		
		para0.setColor(Color.white);
		para.setColor(Color.white);
		para2.setColor(Color.white);
		para3.setColor(Color.white);
		para4.setColor(Color.white);
		para5.setColor(Color.white);
		
		rect.setFillColor(c);
		rect2.setFillColor(c);
		rect3.setFillColor(c);
		rect4.setFillColor(c);
		rect5.setFillColor(c);
		
		rect.setColor(Color.white);
		rect2.setColor(Color.white);
		rect3.setColor(Color.white);
		rect4.setColor(Color.white);
		rect5.setColor(Color.white);
		
		
		
	}
	
	public char getForward() {
		return Forward;
	}

	public void setForward(char forward) {
		Forward = forward;
	}

	public char getLeft() {
		return Left;
	}

	public void setLeft(char left) {
		Left = left;
	}

	public char getDown() {
		return Down;
	}

	public void setDown(char down) {
		Down = down;
	}

	public char getRight() {
		return Right;
	}
	
	public void setRight(char right) {
		Right = right;
	}
	
	public int getForwardLoc() {
		return ForwardLoc;
	}

	public void setForwardLoc(int forwardLoc) {
		ForwardLoc = forwardLoc;
	}

	public int getLeftLoc() {
		return LeftLoc;
	}

	public void setLeftLoc(int leftLoc) {
		LeftLoc = leftLoc;
	}

	public int getDownLoc() {
		return DownLoc;
	}

	public void setDownLoc(int downLoc) {
		DownLoc = downLoc;
	}

	public int getRightLoc() {
		return RightLoc;
	}

	public void setRightLoc(int rightLoc) {
		RightLoc = rightLoc;
	}

	public int getShootLoc() {
		return ShootLoc;
	}

	public void setShootLoc(int shootLoc) {
		ShootLoc = shootLoc;
	}
	
	@Override
	public void showContents() {
		program.add(backround);
		program.add(rect);
		program.add(rect2);
		program.add(rect3);
		program.add(rect4);
		program.add(rect5);
		program.add(para0);
		program.add(para);
		program.add(para2);
		program.add(para3);
		program.add(para4);
		program.add(para5);
		program.add(escape);
	}

	@Override
	public void hideContents() {
		program.removeAll();
	}
	
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == rect) {
			UpRec = true;
			LeftRec = false;
			DownRec = false;
			RightRec = false;
			ShootRec = false;
		}
	
		if(obj == rect2) {
			UpRec = false;
			LeftRec = true;
			DownRec = false;
			RightRec = false;
			ShootRec = false;
		}
		
		if(obj == rect3) {
			UpRec = false;
			LeftRec = false;
			DownRec = true;
			RightRec = false;
			ShootRec = false;
		}
		
		if(obj == rect4) {
			UpRec = false;
			LeftRec = false;
			DownRec = false;
			RightRec = true;
			ShootRec = false;
		}
		
		if(obj == rect5) {
			UpRec = false;
			LeftRec = false;
			DownRec = false;
			RightRec = false;
			ShootRec = true;
		}
		
		if(obj != ERROR) {
			program.remove(ERROR);
		}
		if(obj == escape) {
			JukeBox.STOP();
			JukeBox.PLAY(back);
			program.switchToMenu();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(UpRec) {
			if(((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122)) && (e.getKeyCode() != LeftLoc && e.getKeyCode() != RightLoc && e.getKeyCode() != DownLoc && e.getKeyCode() != ShootLoc)) {
				Forward = e.getKeyChar();
				ForwardLoc = e.getKeyCode();
				rect.setText(String.valueOf(Forward).toUpperCase());
				UpRec = !UpRec;
			}
			else {
				program.add(ERROR);
			}
		}
		
		if(LeftRec) {
			if(((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122)) && (e.getKeyCode() != ForwardLoc && e.getKeyCode() != RightLoc && e.getKeyCode() != DownLoc && e.getKeyCode() != ShootLoc)) {
				Left = e.getKeyChar();
				LeftLoc = e.getKeyCode();
				rect2.setText(String.valueOf(Left).toUpperCase());
				LeftRec = !LeftRec;
			}
			else {
				program.add(ERROR);
			}
		}
		
		if(DownRec) {
			if(((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122)) && (e.getKeyCode() != ForwardLoc && e.getKeyCode() != RightLoc && e.getKeyCode() != LeftLoc && e.getKeyCode() != ShootLoc)) {
				Down = e.getKeyChar();
				DownLoc = e.getKeyCode();
				rect3.setText(String.valueOf(Down).toUpperCase());
				DownRec = !DownRec;
			}
			else {
				program.add(ERROR);
			}
		}
		
		if(RightRec) {
			if(((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <= 122)) && (e.getKeyCode() != ForwardLoc && e.getKeyCode() != DownLoc && e.getKeyCode() != LeftLoc && e.getKeyCode() != ShootLoc)) {
				Right = e.getKeyChar();
				RightLoc = e.getKeyCode();
				rect4.setText(String.valueOf(Right).toUpperCase());
				RightRec = !RightRec;
			}
			else {
				program.add(ERROR);
			}
		}
		
		if(ShootRec) {
			if((e.getKeyCode() >= 65 && e.getKeyCode() <= 90) || (e.getKeyCode() >= 97 && e.getKeyCode() <=122) || (e.getKeyCode() == 32) && (e.getKeyCode() != ForwardLoc && e.getKeyCode() != LeftLoc && e.getKeyCode() != DownLoc && e.getKeyCode() != RightLoc)) {
				Shoot = e.getKeyChar();
				ShootLoc = e.getKeyCode();
				if(ShootLoc == 32) {
					rect5.setText("Space");
				}
				else {
					rect5.setText(String.valueOf(Shoot).toUpperCase());
				}
				ShootRec = !ShootRec;
			}
			else {
				program.add(ERROR);
			}
		}
		
		if(e.getKeyCode() == 27) {
			program.remove(ERROR);
		}
	}
}