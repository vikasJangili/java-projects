package com.mycompany.main;

public class BankAccount {

	private int balance = 1000;

	public void deposit(int amount) {
		synchronized (this) {
			balance += amount;
		}
		// Other non-synchronized code can go here
	}

	public void withdraw(int amount) {
		synchronized (this) {
			if (balance >= amount) {
				balance -= amount;
			} else {
				System.out.println("Insufficient balance");
			}
		}
		// Other non-synchronized code can go here
	}

	public int getBalance() {
		return balance;
	}
}
