package dk.aau.imi.med4.guinmp2009.threads.solutions01;

public class Tilbage implements Runnable {
	public void run() {
		synchronized (FremOgTilbage.ARRAY) {
			for(int i = 9; i >= 0; i--) {
				FremOgTilbage.ARRAY[i] = 10 - i;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
