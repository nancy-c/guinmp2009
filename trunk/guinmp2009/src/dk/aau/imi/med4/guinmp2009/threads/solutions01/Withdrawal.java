package dk.aau.imi.med4.guinmp2009.threads.solutions01;

public class Withdrawal implements Runnable {
	
	private int amount = 0;
	
	public Withdrawal(int amount) {
		super();
		this.amount = amount;
	}
	
	public void run() {
		HrOgFrJensen.ACCOUNT.withdraw(amount);
	}
}
