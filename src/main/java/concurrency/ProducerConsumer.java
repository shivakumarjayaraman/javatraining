package concurrency;

public class ProducerConsumer {
	
	public static class SharedBuffer {
		private static int SIZE = 10;
		private int []array = new int[SIZE];
		
		public int readIndex = 0;
		public int writeIndex = 0;
		
		public boolean isEmpty() {
			return readIndex == writeIndex;
		}
		public boolean isFull() {
			return (writeIndex + 1)%SIZE == readIndex;
		}
		
		public synchronized int get() throws Exception {
			while (isEmpty()) {
				wait();
			}
			int val = array[readIndex];
			readIndex = (readIndex + 1) % SIZE;
			notifyAll();
			return val;
			
		}
		
		public synchronized void put(int x) throws Exception {
			while (isFull()) {
				wait();
			}
			
			array[writeIndex] = x;
			writeIndex = (writeIndex + 1) % SIZE;
			notifyAll();
		}
	}
	
	public static void main(String [] args) throws Exception {
		SharedBuffer buf = new SharedBuffer();
		
		Thread producer = new Thread(()->{
			for (int i = 0; i < 100; i++) {
				//System.out.println("Produced " + i);
				try {
					buf.put(i);
					
				} catch (Exception e) {}
			}
		});
		
		Thread consumer = new Thread(()->{
			for (int i = 0; i < 100; i++) {
				try {
					System.out.println("Consumed " + buf.get());
					Thread.sleep(100);
				} catch (Exception e) {}
			}
		});
		
		producer.start();
		consumer.start();
		
		producer.join();
		consumer.join();
	}
}
