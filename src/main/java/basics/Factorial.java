package basics;

import java.math.BigInteger;

public class Factorial {
	public static long fact(int n) {
		long res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		
		return res;
	}
	

	
	public static void main(String [] args) {
		for (int i = 0; i < 50; i++) {
			System.out.println("factorial of " + i +  " is " + fact(i));
		}
	}
	
//	public static BigInteger fact(int n) {
//	BigInteger b = BigInteger.valueOf(1);
//	for (int i = 1; i <= n; i++) {
//		b = b.multiply(BigInteger.valueOf(i));
//	}
//	return b;
//}
}
