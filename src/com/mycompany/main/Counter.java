package com.mycompany.main;

public class Counter {

	private int count = 0;

	// Synchronized method to increment the counter
	public synchronized void increment() {
		count++;
	}

	// Synchronized method to get the current count
	public synchronized int getCount() {
		return count;
	}
}
