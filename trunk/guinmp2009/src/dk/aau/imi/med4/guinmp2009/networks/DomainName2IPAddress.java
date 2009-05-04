package dk.aau.imi.med4.guinmp2009.networks;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DomainName2IPAddress {
	public static void main(String[] args) {
		String domainName = "www.imi.aau.dk";
		InetAddress[] ipAddresses;
		try {
			ipAddresses = InetAddress.getAllByName(domainName);
			for(InetAddress inetAddress : ipAddresses) {
				System.out.print(inetAddress.getHostAddress());
				System.out.println("; Canonical host name: "+inetAddress.getCanonicalHostName());
			}
		} catch (UnknownHostException e) {
			System.out.println("Unknown host!");
		}
	}
}
