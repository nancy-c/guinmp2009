package dk.aau.imi.med4.guinmp2009.threads.solutions01;

public class Frem implements Runnable {
	public void run() {
		synchronized (FremOgTilbage.ARRAY) {
			for(int i = 0; i < 10; i++) {
				FremOgTilbage.ARRAY[i] = i+1;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
