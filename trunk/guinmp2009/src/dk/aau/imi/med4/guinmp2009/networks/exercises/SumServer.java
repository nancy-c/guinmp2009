package dk.aau.imi.med4.guinmp2009.networks.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SumServer {
	
	private static String sum(String inputString1, String inputString2) {
		Double x = Double.parseDouble(inputString1);
		Double y = Double.parseDouble(inputString2);
		Double sum = x + y;
		return sum.toString();
	}
	
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String inputLine1, inputLine2;
		try {
			serverSocket = new ServerSocket(50000);
			clientSocket = serverSocket.accept();
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			while ((inputLine1 = in.readLine()) != null){
				inputLine2 = in.readLine();
				out.println(sum(inputLine1, inputLine2));
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
