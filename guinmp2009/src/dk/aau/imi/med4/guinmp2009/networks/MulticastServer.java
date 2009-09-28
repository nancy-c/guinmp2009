package dk.aau.imi.med4.guinmp2009.networks;

public class MulticastServer {
    public static void main(String[] args) throws java.io.IOException {
        while (true) {
        	MulticastServerThread t = new MulticastServerThread();
        	t.start();
        	try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
        }
    }
}
