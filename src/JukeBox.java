import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

//lets get jazzy

public class JukeBox {

	static Clip Audio;
	
	JukeBox() {}
	
	static void PLAY (File SelectedAudio) {
		try {
			Audio = AudioSystem.getClip();
			Audio.open(AudioSystem.getAudioInputStream(SelectedAudio));
			Audio.start();
			FloatControl gameControl = (FloatControl)Audio.getControl(FloatControl.Type.MASTER_GAIN);
			gameControl.setValue(-20.0f);
		}
		catch (Exception e) {}
	}
	
	static void STOP () {
		Audio.stop();
		Audio.close();
		Audio.drain();
	}
	
	public static void main (String [] args) {
		File TestAudio = new File("assets/bgm/TestAudio.wav");
		PLAY(TestAudio);
	}
	
}
