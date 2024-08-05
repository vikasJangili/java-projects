package com.mycompnay.main;

public class Test2 {

public static void main(String []args) {
	
	Runnable r1 = () -> {System.out.println("thread name r1:: "+Thread.currentThread().getName());};
	Runnable r2 = () -> {System.out.println("thread name r2 :: "+Thread.currentThread().getName());};
	
	Thread t1 = new Thread(r1, "Thread1");
	Thread t2 = new Thread(r2, "Thread2");
	
	t1.start();
	t2.start();
	
	System.out.println("Current Thread: "
            + Thread.currentThread().getName());
       try {
		t1.join();
	} catch (InterruptedException e) {		
		e.printStackTrace();
	}
}

}
