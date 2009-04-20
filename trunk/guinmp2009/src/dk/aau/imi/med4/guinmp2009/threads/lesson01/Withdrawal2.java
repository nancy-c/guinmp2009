package dk.aau.imi.med4.guinmp2009.threads.lesson01;

public class Withdrawal2 extends Thread {
	
	private int amount = 0;
	
	public Withdrawal2(String name, int amount) {
		super();
		this.amount = amount;
		this.setName(name);
	}
	
	public void run() {
		/*
		 * Because the following code is synchronized on 
		 * HrOgFrJensen.ACCOUNT, there will be no race
		 * condition even if the BankAccount.withdraw method is not
		 * synchronized.
		 */
		synchronized (HrOgFrJensen.ACCOUNT) {
			HrOgFrJensen2.ACCOUNT.withdraw(amount);
		}
	}
}
