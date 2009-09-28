package dk.aau.imi.med4.guinmp2009.networks;

import java.net.*;

public class ParseURL {
    public static void main(String[] args) throws Exception {
    	String urlString = "http://java.sun.com:80/docs/books/tutorial/index.html?name=networking#DOWNLOADING";
    	System.out.println(urlString);
        URL aURL = new URL(urlString);
        System.out.println("protocol = " 	+ aURL.getProtocol());
        System.out.println("authority = " 	+ aURL.getAuthority());
        System.out.println("host = " 		+ aURL.getHost());
        System.out.println("port = " 		+ aURL.getPort());
        System.out.println("path = " 		+ aURL.getPath());
        System.out.println("query = " 		+ aURL.getQuery());
        System.out.println("filename = " 	+ aURL.getFile());
        System.out.println("ref = " 		+ aURL.getRef());
    }
}