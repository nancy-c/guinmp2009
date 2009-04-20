package dk.aau.imi.med4.guinmp2009.threads.lesson01;

/**
 * Illustrates use of synchronized statements.
 * 
 * See Withdrawal2 and Deposit2.
 * 
 * @author dmeredith
 *
 */
public class HrOgFrJensen2 {
	
	public static BankAccount ACCOUNT= new BankAccount(1000);
	
	public static void main(String[] args) {
		Deposit2 hr = new Deposit2("Hr. Jensen", 100);
		hr.start();
		Withdrawal2 fru = new Withdrawal2("Fru Jensen", 50);
		fru.start();
		try {
			hr.join();
			fru.join();
			System.out.println("Final balance is "+ ACCOUNT.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
