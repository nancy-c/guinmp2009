package dk.aau.imi.med4.guinmp2009.threads.lesson01;

/**
 * A simple, single-threaded program.
 * 
 * A single-threaded program consists of a single sequence or "thread" of
 * instructions, executed one after the other.
 * 
 * In a single-threaded program, only one thing is happening within the program
 * at a time.
 * 
 * All the programs we've looked at so far have been single-threaded programs,
 * even the ones that use lots of objects.
 * 
 * A single-threaded program has just one thread, called the "main thread".
 * 
 * @author David Meredith
 * 
 */
public class SingleThreadedProgram {
	public static void main(String[] args) {

		// Open a bank account
		Integer bankBalance = 0;

		// Deposit some money
		bankBalance = bankBalance + 12;

		// Withdraw some money
		bankBalance = bankBalance - 5;

		// Print out the balance
		System.out.println("bankBalance == " + bankBalance);
	}
}
