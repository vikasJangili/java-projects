package com.mycompnay.main;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapConcurrencyExample {
	public static void main(String[] args) {
		// Create a ConcurrentHashMap instance
		ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

		// Runnable tasks for writing to the map
		Runnable writeTask = () -> {
			for (int i = 0; i < 5; i++) {
				map.put("Key" + i, i);
				System.out.println("Written: Key" + i + " = " + i);
				try {
					Thread.sleep(100); // Simulate time taken to write
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		};

		// Runnable tasks for reading from the map
		Runnable readTask = () -> {
			for (int i = 0; i < 5; i++) {
				Integer value = map.get("Key" + i);
				System.out.println("Read: Key" + i + " = " + value);
				try {
					Thread.sleep(150); // Simulate time taken to read
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		};

		// Create and start threads for writing and reading
		Thread writerThread = new Thread(writeTask);
		Thread readerThread = new Thread(readTask);

		writerThread.start();
		readerThread.start();

		// Wait for threads to complete
		try {
			writerThread.join();
			readerThread.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		// Final map content
		System.out.println("Final map content:");
		map.forEach((key, value) -> System.out.println(key + ": " + value));
	}
}
