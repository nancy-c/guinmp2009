package dk.aau.imi.med4.guinmp2009.threads.solutions01;

import java.util.Random;

public class BankAccount {
	private int balance = 0;

	public BankAccount(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public /* synchronized */ void deposit(int amount) {
		try {
			Random rnd = new Random();
			int bal = getBalance();
			System.out.println(Thread.currentThread().getName()+" just read the balance to be "+bal);
			Thread.sleep(rnd.nextInt(100));
			bal = bal + amount;
			System.out.println(Thread.currentThread().getName()+" just set bal to "+bal);
			Thread.sleep(rnd.nextInt(100));
			setBalance(bal);
			System.out.println(Thread.currentThread().getName()+" just set the account balance to "+bal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public /* synchronized */ void withdraw(int amount) {
		try {
			Random rnd = new Random();
			int bal = getBalance();
			System.out.println(Thread.currentThread().getName()+" just read the balance to be "+bal);
			Thread.sleep(rnd.nextInt(100));
			bal = bal - amount;
			System.out.println(Thread.currentThread().getName()+" just set bal to "+bal);
			Thread.sleep(rnd.nextInt(100));
			setBalance(bal);
			System.out.println(Thread.currentThread().getName()+" just set the account balance to "+bal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
