package concurrency;

public class ProblemWithThreads {
	
	static int sharedState = 0;
	
	public static void main(String [] args) throws Exception {
		int count = 20000;
		
		Thread t1 = new Thread(()->{
			for (int i = 0; i < count; i++) {
				incrementSharedState();
			}
		});
		
		Thread t2 = new Thread(()->{
			for (int i = 0; i < count; i++) {
				incrementSharedState();
			}
		});
		
		t1.start(); t2.start();
		t1.join(); t2.join();
		
		System.out.println(sharedState);
	}

	private  static void incrementSharedState() {
		sharedState++;
	}
}
