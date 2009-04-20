package dk.aau.imi.med4.guinmp2009.threads.lesson01;

public class HrOgFrJensen {
	
	public static BankAccount ACCOUNT= new BankAccount(1000);
	
	public static void main(String[] args) {
		new Deposit("Hr. Jensen", 100).start();
		new Withdrawal("Fru Jensen", 50).start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final balance is "+ ACCOUNT.getBalance());
	}
}
