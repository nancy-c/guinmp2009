package dk.aau.imi.med4.guinmp2009.threads.lesson01;

public class PingPongThread extends Thread {
	private String word;
	private int delay;
	
	public PingPongThread(String whatToSay, int delayTime) {
		word = whatToSay; 	// What word to print
		delay = delayTime; 	// How long to pause
	}
	
	public void run() {
		try {
			for (;;) {
				System.out.print(word + " ");
				PingPong.lineCount++;
				if (PingPong.lineCount == 10) {
					System.out.println();
					PingPong.lineCount = 0;
				}
				Thread.sleep(delay);
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
