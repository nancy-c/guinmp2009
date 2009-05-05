package dk.aau.imi.med4.guinmp2009.networks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ReverseServer {
	
	private static String reverse(String inputString) {
		StringBuffer sb = new StringBuffer();
		int l = inputString.length();
		for(int i = 0; i < l; i++) {
			sb.append(inputString.charAt(l - 1 - i));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String inputLine;
		try {
			serverSocket = new ServerSocket(50000);
			clientSocket = serverSocket.accept();
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			while ((inputLine = in.readLine()) != null){
				out.println(reverse(inputLine));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}
