package concurrency;

public class BasicThreads {
	public static void main(String [] args) {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread 1");
					try { Thread.sleep(1000); } catch (Exception e) {}
				}
			}
		};
		
		Runnable r = ()->{
			for (int i = 0; i < 10; i++) {
				System.out.println("Thread 2");
				try { Thread.sleep(1000); } catch (Exception e) {}
			}
		};
		
		Thread t2 = new Thread(r);
		
		t1.start(); t2.start();
	}
}
