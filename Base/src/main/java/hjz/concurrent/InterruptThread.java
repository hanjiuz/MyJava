package hjz.concurrent;

import java.lang.Thread.State;

public class InterruptThread {

	public static void main(String[] args) throws InterruptedException {
		
		//use lambda expression to create a impl for functional interface
		Runnable r = () -> {
			System.out.println("thread start to run...");
			State s = Thread.currentThread().getState();
			System.out.println("thread state: " + s.toString());
			
			//sleep() is not an static method of Thread
			//during sleep, the main thread can check its status (TIMED_WAITING)
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("I am interrupted from sleep(5000)");
				
				System.out.println("I am interrupted from sleep(5000), isInterrupted is: " + Thread.currentThread().isInterrupted());
				
				
			}
			System.out.println("I am awake from sleep(5000)");
			System.out.println("I am awake from sleep(5000), isInterrupted is: " + Thread.currentThread().isInterrupted());
			
			
			
			//wait() is not the instance method of Thread, it is Object's.
			//wait will cause current thread to go into WAITING or TIMED_WAITING status
			try {
				Object o = new Object();
				//wait must be called by the thread owning the o's monitor.
				synchronized (o) {
					o.wait(5000);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("I am interrupted from wait(5000)");
				
				System.out.println("I am interrupted from wait(5000), isInterrupted is: " + Thread.currentThread().isInterrupted());
				
			}
			System.out.println("I am awake from wait(5000)");
			System.out.println("I am awake from sleep(5000), isInterrupted is: " + Thread.currentThread().isInterrupted());
			
			
		};
		
		Thread t = new Thread(r);
		System.out.println("thread state before start(): " + t.getState().toString());
		
		t.start();
		
		System.out.println("thread state after start(): " + t.getState().toString());
		
		//keep checking thread status
		int count = 0;
		while(count < 20) {
			
			
			Thread.sleep(1000);
			
			System.out.println("thread state during running: " + t.getState().toString());
			
			count ++;
			
			//try to interrupt sleep
			if (count == 3 ) {
				t.interrupt();
			}
			
			//try to interrupt wait
			if (count == 7 ) {
				t.interrupt();
			}
						
		}
		
		System.out.println("thread state after long time: " + t.getState().toString());
		
		
	}

}
