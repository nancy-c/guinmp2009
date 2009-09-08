package dk.aau.imi.med4.guinmp2009.threads.lesson01;

public class Deposit extends Thread {
	
	private int amount = 0;
	
	public Deposit(String name, int amount) {
		this.amount = amount;
		this.setName(name);
	}
	
	public void run() {
		HrOgFrJensen.ACCOUNT.deposit(amount);
	}
}
