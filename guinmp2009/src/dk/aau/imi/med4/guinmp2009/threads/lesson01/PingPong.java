package dk.aau.imi.med4.guinmp2009.threads.lesson01;

/**
 * Creates two threads, one writes "ping" and the other writes
 * "PONG". Each delays 50ms between writes, but the output from
 * each thread does not strictly interleave because the precise
 * timing of the output depends on the way that the computer's
 * processor allocates processor time to each thread (this is
 * called "time slicing").
 * 
 * @author dmeredith
 *
 */
public class PingPong {
	public static int lineCount = 0;
	
	public static void main(String[] args) {
		try {
			PingPongThread ping = new PingPongThread("ping", 50);
			PingPongThread pong = new PingPongThread("PONG", 50);
			ping.start();
			pong.start();
			Thread.sleep(10000);
			ping.interrupt();
			Thread.sleep(5000);
			pong.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
