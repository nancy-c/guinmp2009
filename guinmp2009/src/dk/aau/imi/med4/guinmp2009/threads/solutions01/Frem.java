package dk.aau.imi.med4.guinmp2009.threads.solutions01;

public class Frem implements Runnable {
	public void run() {

		/*
		 * It is usually better to use a synchronized method rather than a
		 * synchronized statement. This is because using a synchronized method
		 * ensures that calls to the code within that method will always be
		 * synchronized. This is called server-side synchronization because the
		 * responsibility for synchronization is placed on the server class
		 * (see, e.g. BankAccount class).
		 * 
		 * However, here we have to use a synchronized statement rather than a
		 * synchronized method because ARRAY is not a class that we can define
		 * methods on and the critical region of code has to be synchronized on
		 * FremOgTilbage.ARRAY (i.e., it is FremOgTilbage.ARRAY which has to be
		 * locked). This is called client-side synchronization because the
		 * responsibility for synchronization lies with every client that
		 * accesses the object on which a lock needs to be obtained.
		 */
		synchronized (FremOgTilbage.ARRAY) {
			for (int i = 0; i < 10; i++) {
				FremOgTilbage.ARRAY[i] = i + 1;
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
