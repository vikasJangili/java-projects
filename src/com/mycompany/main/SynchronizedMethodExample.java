package com.mycompany.main;

public class SynchronizedMethodExample {

	public static void main(String[] args) {
		Counter counter = new Counter();

		// Create multiple threads that increment the counter
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
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

		// Print the final count value
		System.out.println("Final Count: " + counter.getCount());
	}
}
