package concurrency;

import java.util.List;
import java.util.concurrent.*;



public class ThreadPools {
	public static void main(String [] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 20; i++) {
			final int n = i;
			es.execute(() -> {
				System.out.println("I am thread " + Thread.currentThread().getId() + " printing " + n);});
		}
		
		es.shutdown();
		
	
	}
}
