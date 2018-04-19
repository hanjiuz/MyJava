package hjz.algorithm;

import java.util.concurrent.CountDownLatch;

public class SleepSorting {

	public static void main(String[] args) {
		
		int [] arr = {38, 70, 30, 22, 14, 21, 5, 66, 62, 65};
		
		System.out.println("array before sorting:");
		print(arr);
		
		System.out.println("array after sleep sorting:");
		sleepSort(arr);
		

	}
	
	/**
	 * Sleep sorting, ha ha ha...
	 */
	public static void sleepSort(int [] arr) {
		
		CountDownLatch cdl = new CountDownLatch(arr.length);
		
		for(int i : arr) {
			
			new Thread(new Runnable(){
				public void run() {
					
					cdl.countDown();
					
					try {
						cdl.await();  //wait to start together
						Thread.sleep(i*10);
						System.out.print(i + " ");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}).start();
		}
	}
	
	/**
	 * print array
	 */
	public static void print(int []arr) {
		for (int i=0; i<arr.length; i++) {
			if(i!=arr.length-1) {
				System.out.print(arr[i]+", ");
			}else{
				System.out.print(arr[i]+". \n");
			}	
		}
	}
	
	
}
