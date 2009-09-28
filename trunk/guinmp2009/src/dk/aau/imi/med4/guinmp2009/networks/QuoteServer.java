package dk.aau.imi.med4.guinmp2009.networks;

import java.io.*;

public class QuoteServer {
    public static void main(String[] args) throws IOException {
    	try {
    		while(true) {
    			QuoteServerThread t = new QuoteServerThread();
    			t.start();
    			t.join();
    		}
    	} catch(InterruptedException e) {
    		return;
    	}
    }
}
