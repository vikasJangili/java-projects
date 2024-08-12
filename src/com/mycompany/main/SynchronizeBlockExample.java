package com.mycompany.main;

public class SynchronizeBlockExample {

	public static void main(String[] args) {
		BankAccount account = new BankAccount();

		//Create a thread and perform deposit operation
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				account.deposit(100);
			}
		});

		//Create a thread and perform withdraw operation
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				account.withdraw(50);
			}
		});

		thread1.start();
		thread2.start();

		// main thread Wait's for both threads to finish
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final Balance: " + account.getBalance());
	}
}
