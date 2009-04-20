package dk.aau.imi.med4.guinmp2009.threads.lesson01;

/**
 * Creates two threads, one writes "ping" and the other writes
 * "PONG". Each delays 50ms between writes, but the output from
 * each thread does not strictly interleave because the precise
 * timing of the output depends on the way that the computer's
 * processor allocates processor time to each thread (this is
 * called "time slicing").
 * 
 * This version of PingPong uses Runnable objects instead of
 * directly subtyping Thread.
 * 
 * @author dmeredith
 *
 */
public class PingPong2 {
	
	/**
	 * A static field to store the number of words printed
	 * so far to the current line. When this number reaches
	 * 10, it is reset to 0.
	 */
	public static int lineCount = 0;
	
	public static void main(String[] args) {
		try {
			PingPongRunnable pingRunnable = new PingPongRunnable("ping", 50);
			PingPongRunnable pongRunnable = new PingPongRunnable("PONG", 50);
			Thread pingThread = new Thread(pingRunnable,"PingThread");
			Thread pongThread = new Thread(pongRunnable,"PongThread");
			pingThread.start();
			pongThread.start();
			Thread.sleep(10000);
			pingThread.interrupt();
			Thread.sleep(5000);
			pongThread.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
