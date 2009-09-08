package dk.aau.imi.med4.guinmp2009.threads.solutions01;

public class Deposit implements Runnable {
	
	private int amount = 0;
	
	public Deposit(int amount) {
		this.amount = amount;
	}
	
	public void run() {
		HrOgFrJensen.ACCOUNT.deposit(amount);
	}
}
