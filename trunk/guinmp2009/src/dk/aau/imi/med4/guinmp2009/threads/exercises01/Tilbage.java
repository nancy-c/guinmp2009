package dk.aau.imi.med4.guinmp2009.threads.exercises01;

public class Tilbage implements Runnable {
	public void run() {
		for(int i = 9; i >= 0; i--) {
			FremOgTilbage.ARRAY[i] = 10 - i;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
