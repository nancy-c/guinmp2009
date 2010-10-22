package dk.aau.medialogy.med7.mtp.sound;

import java.io.IOException;
import java.io.File;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioFileFormat;

public class Example02Recorder extends Thread {
	private TargetDataLine line;
	private AudioFileFormat.Type targetType;
	private AudioInputStream audioInputStream;
	private File outputFile;

	public Example02Recorder(TargetDataLine line, AudioFileFormat.Type targetType, File file) {
		this.line = line;
		this.audioInputStream = new AudioInputStream(line);
		this.targetType = targetType;
		this.outputFile = file;
	}

	public void run() {
		try {
			line.start();
			AudioSystem.write(audioInputStream, targetType, outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TargetDataLine getLine() {
		return line;
	}

	public static void main(String[] args) {
		try {
			File outputFile = new File("resources/recordingfile.wav");
			AudioFormat	audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
					44100.0F, 16, 2, 4, 44100.0F, false);
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
			TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
			targetDataLine.open(audioFormat);
			Example02Recorder recorder = new Example02Recorder(targetDataLine,
					AudioFileFormat.Type.WAVE,
					outputFile);
			System.out.println("Press ENTER to start the recording.");
			System.in.read();
			recorder.start();
			System.out.println("Recording...");
			System.out.println("Press ENTER to stop the recording.");
			System.in.read();
			recorder.getLine().stop();
			recorder.getLine().close();
			System.out.println("Recording stopped.");
		} catch(IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}
