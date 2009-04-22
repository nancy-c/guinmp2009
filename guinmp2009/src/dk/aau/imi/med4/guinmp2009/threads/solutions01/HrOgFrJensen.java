package dk.aau.imi.med4.guinmp2009.threads.solutions01;

/**
 * Demonstrates use of synchronized methods.
 * 
 * Without synchronization, statements within withdraw and deposit
 * methods of BankAccount can be interleaved between the fru and hr
 * Threads.
 * 
 * Note that withdraw method can start before deposit method even
 * though hr is started programmatically before fru.
 * 
 * Note use of join() method to make sure that hr and fru complete
 * before the final balance is printed out.
 * 
 * With synchronized methods in BankAccount, withdraw and deposit
 * acquire lock on "this" object and keep lock until method has
 * returned.
 * 
 * Note that, again, fru could complete before hr even though
 * hr is started first in the program.
 * 
 * @author dmeredith
 *
 */
public class HrOgFrJensen {
	
	public static BankAccount ACCOUNT= new BankAccount(1000);
	
	public static void main(String[] args) {
		Deposit runHr = new Deposit(100);
		Thread hr = new Thread(runHr,"Hr. Jensen 2");
		hr.start();
		Withdrawal runFru = new Withdrawal(50);
		Thread fru = new Thread(runFru,"Fru Jensen 2");
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
