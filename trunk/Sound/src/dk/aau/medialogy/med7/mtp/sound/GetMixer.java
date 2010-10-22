package dk.aau.medialogy.med7.mtp.sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Port;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class GetMixer {
	public static void main(String[] args) {

		//List all available mixers
		Mixer.Info[] mixerInfoArray = AudioSystem.getMixerInfo();
		for(Mixer.Info info : mixerInfoArray) {
			System.out.println("Name: "+info.getName());
			System.out.println("Description: "+info.getDescription());
			System.out.println("Vendor: "+info.getVendor());
			System.out.println("Version: "+info.getVersion());
			System.out.println("Class: "+info.getClass());
			System.out.println();
		}

		//Obtain the Java Sound Audio Engine
		Mixer javaSoundMixer = AudioSystem.getMixer(mixerInfoArray[0]);
		for(Mixer.Info info : mixerInfoArray) {
			if (info.getName().equals("Java Sound Audio Engine")) {
				javaSoundMixer = AudioSystem.getMixer(info);
				break;
			}
		}
		System.out.println("Java Sound Mixer is following:");
		System.out.println("Name: "+javaSoundMixer.getMixerInfo().getName());
		System.out.println("Description: "+javaSoundMixer.getMixerInfo().getDescription());
		System.out.println("Vendor: "+javaSoundMixer.getMixerInfo().getVendor());
		System.out.println("Version: "+javaSoundMixer.getMixerInfo().getVersion());
		System.out.println("Class: "+javaSoundMixer.getMixerInfo().getClass());
		System.out.println();

//		/*
//		 * Now let's get a line from AudioSystem. This does not depend on us having
//		 * gotten a mixer first.
//		 */
//
//
//		TargetDataLine targetDataLine;
//		AudioFormat format = new AudioFormat(44100,16,2,true,true);
//		DataLine.Info lineInfo = new DataLine.Info(TargetDataLine.class, format);
//		if (!AudioSystem.isLineSupported(lineInfo)) {
//			System.out.println("Sorry! TargetDataLine not supported!");
//		} else {
//			try {
//				targetDataLine = (TargetDataLine) AudioSystem.getLine(lineInfo);
//				targetDataLine.open(format);
//				System.out.println("TargetDataLine opened");
//				System.out.println("TargetDataLine info: "+targetDataLine.getLineInfo().toString());
//				targetDataLine.close();
//				System.out.println("TargetDataLine closed");
//			} catch(LineUnavailableException e) {
//				e.printStackTrace();	
//			}
//		}
//		System.out.println();
//
//		/*
//		 * Let's now get a port, for example, a microphone input, from the AudioSystem.
//		 */
//		Port microphone;
//		if (!AudioSystem.isLineSupported(Port.Info.MICROPHONE)) {
//			System.out.println("Sorry! Microphone not supported!");
//		} else {
//			try {
//				microphone = (Port) AudioSystem.getLine(Port.Info.MICROPHONE);
//				microphone.open();
//				System.out.println("Microphone opened");
//				System.out.println("Microphone info: "+microphone.getLineInfo().toString());
//				microphone.close();
//				System.out.println("Microphone closed");
//			} catch(LineUnavailableException e) {
//				e.printStackTrace();	
//			}
//		}
//		System.out.println();
//
//		/*
//		 * Get the AudioSystem to tell us about all the installed source data lines and target data lines
//		 */
//		System.out.println("A list of source data lines:");
//		Line.Info[] sourceLineInfoArray = AudioSystem.getSourceLineInfo(new DataLine.Info(SourceDataLine.class, format));
//		for(Line.Info sourceLineInfo : sourceLineInfoArray)
//			System.out.println(sourceLineInfo.toString());
//		System.out.println();
//
//		System.out.println("A list of target data lines:");
//		Line.Info[] targetLineInfoArray = AudioSystem.getTargetLineInfo(new DataLine.Info(TargetDataLine.class, format));
//		for(Line.Info targetLineInfo : targetLineInfoArray)
//			System.out.println(targetLineInfo.toString());
//		System.out.println();
//
//
//		/*
//		 * Scan through the available mixers, getting information about the source lines
//		 * and target lines of each.
//		 */
//
//		for(Mixer.Info mixerInfo : mixerInfoArray) {
//			Mixer mixer = AudioSystem.getMixer(mixerInfo);
//			System.out.println();
//			System.out.println("Lines on mixer with name "+mixerInfo.getName());
//			try {
//				mixer.open();
//				System.out.println("Source lines:");
//				Line.Info[] sourceLineInfoArray2 = mixer.getSourceLineInfo();
//				for(Line.Info info : sourceLineInfoArray2) {
//					System.out.println(info.toString());
//					Line line = mixer.getLine(info);
//					if(!(line instanceof Clip)) {
//						line.open();
//						System.out.println("Line, "+line.toString()+", opened");
//						line.close();
//						while(line.isOpen());
//						System.out.println("Line, "+line.toString()+", closed");
//					}
//				}
//				System.out.println("Target lines:");
//				Line.Info[] targetLineInfoArray2 = mixer.getTargetLineInfo();
//				for(Line.Info info : targetLineInfoArray2) {
//					System.out.println(info.toString());
//					Line line = mixer.getLine(info);
//					line.open();
//					System.out.println("Line, "+line.toString()+", opened");
//					line.close();
//					while(line.isOpen());
//					System.out.println("Line, "+line.toString()+", closed");
//				}
//				mixer.close();
//			} catch (LineUnavailableException e) {
//				e.printStackTrace();
//			}
//		}

	}
}
