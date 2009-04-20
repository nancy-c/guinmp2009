package dk.aau.imi.med4.guinmp2009.threads.lesson01;

public class PingPongRunnable implements Runnable {
	private String word;
	private int delay;
	
	/**
	 * PingPongRunnable's constructor.
	 * @param whatToSay The word that the thread should print out.
	 * @param delayTime The delay time in ms between outputs.
	 */
	public PingPongRunnable(String whatToSay, int delayTime) {
		word = whatToSay; 	// What word to print
		delay = delayTime; 	// How long to pause
	}
	
	/**
	 * Runs forever, printing out this PingPongRunnable's word
	 * and then sleeping for delay ms.
	 * 
	 * Cannot throw exceptions because Runnable.run() doesn't.
	 * 
	 * Therefore has to catch the InterruptedException thrown
	 * by Thread.sleep(delay)
	 */
	public void run() {
		try {
			for (;;) {
				System.out.print(word + " ");
				PingPong.lineCount++;
				if (PingPong.lineCount == 10) {
					System.out.println();
					PingPong.lineCount = 0;
				}
				/*
				 * Thread.sleep(delay) causes the currently executing thread
				 * to sleep (i.e., do nothing) for delay ms.
				 */
				Thread.sleep(delay); 	// sleep method can throw an
										// InterruptedException if it
										// is interrupted by some other
										// thread
			}
		} catch (InterruptedException e) {
			/*
			 * Need to use Thread.currentThread() to get the currently executing Thread.
			 * A Runnable object doesn't have a name.
			 */
			System.out.println("\n" + Thread.currentThread().getName() + " was interrupted.\n");
			return;
		}
	}
}
