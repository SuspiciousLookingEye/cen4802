package cen4802;

import java.util.Scanner;

public class Assignment2Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the number of terms in the sequence.");
		int limit = input.nextInt();
		long result = fibonacci(limit);
		System.out.println("Calculator found term " + limit + " to equal " + result);
		input.close();

	}
	
	public static long fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
