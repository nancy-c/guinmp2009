package dk.aau.imi.med4.guinmp2009.threads.lesson01;

public class PingPong {
	public static int lineCount = 0;
	
	public static void main(String[] args) {
		new PingPongThread("ping", 50).start();		//Write "ping" every 50ms
		new PingPongThread("PONG", 50).start();		//Write "PONG" every 50ms
	}
}
