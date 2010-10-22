package dk.aau.medialogy.med7.mtp.sound;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Example03ClipPlayer implements LineListener {
	private Clip clip;
	private AudioInputStream audioInputStream;

	public Example03ClipPlayer(String clipFileName, int nLoopCount) {
		try {
			File clipFile = new File(clipFileName);
			audioInputStream = AudioSystem.getAudioInputStream(clipFile);
			AudioFormat	format = audioInputStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.addLineListener(this);
			clip.open(audioInputStream);
//			clip.setMicrosecondPosition(1000000L);
			clip.loop(nLoopCount);
//			clip.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}

	public void update(LineEvent event) {
		if (event.getType().equals(LineEvent.Type.STOP))
			clip.close();
		else if (event.getType().equals(LineEvent.Type.CLOSE))
			System.exit(0);
	}

	public static void main(String[] args) {
		try {
			new Example03ClipPlayer("resources/MichaelCaine.wav", 4);
			System.in.read();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}