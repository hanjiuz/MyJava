package hjz.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("Runtime has this number of cores: " + cores);
		
		
		ExecutorService es = Executors.newFixedThreadPool(cores);
		
		Future<?> result0 = es.submit(new Runnable(){
			public void run()  {
				System.out.println("I am runnable, I have no result and I can not throw checked execeptions.");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		);
		System.out.println("print future result0 ...");
		System.out.println("result0 is: "+result0.get());
		
		Future<String> result1 = es.submit(new Runnable() {
			public void run()  {
				System.out.println("I am runnable, I have a result but I can not throw checked execeptions.");
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		},
		"Runnable run sucessfully!"
		);
		System.out.println("print future result1 ...");
		System.out.println("result1 is: "+result1.get());
		
		
		
		Future<String> result2 = es.submit(new Callable<String>(){
			
			public String call() throws Exception {
				
				System.out.println("I am callable, I have a result and I can throw checked execeptions.");
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				double rValue = Math.random();
				if (rValue < 0.2) {
					throw new Exception("too small random - less than 0.2"+rValue);
				}
				
				return "Callable run successfully!"+rValue;
			}
			
		});
		System.out.println("print future result2 ...");
		System.out.println("result2 is: "+result2.get());

	}

}
