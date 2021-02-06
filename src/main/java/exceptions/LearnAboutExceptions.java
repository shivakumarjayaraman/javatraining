package exceptions;

import java.io.IOException;

public class LearnAboutExceptions {
	public static void main(String [] args) {
//		Throwable t;
		
//		try {
//			demoCheckedAndUncheckedExceptions();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//		    System.out.println("In finally block");
//	    }
		    
		 try (MyCloseable c = new MyCloseable()) {
			 System.out.println("Inside the try-with-resources");
		 }
		    
		 
		 // Learn about stack traces
		 try {
			 recurssiveCall(1);
		 } catch (Exception e) {
			 //e.printStackTrace();
			 StackTraceElement[] ste = e.getStackTrace();
			 for (StackTraceElement s : ste) {
				 System.out.println (s.getClassName() + ":" + s.getLineNumber());
			 }
		 }
		 
		 // Assert
		 //assert(5 > 10);
	}
	
	private static void recurssiveCall(int n) {
		if (n == 5) {
			throw new IllegalArgumentException("I hate 5");
		}
		recurssiveCall(n+1);
	}

	private static void demoCheckedAndUncheckedExceptions() throws IOException {
		//throw new ArithmeticException("Whoops"); 
	}
	
	
	static class MyCloseable implements AutoCloseable {
		@Override
		public void close()  {
			System.out.println("Closing expensive resources");
			//new Exception().printStackTrace();
		}		
	}
}
