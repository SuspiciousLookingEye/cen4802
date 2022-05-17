package cen4802;

import java.util.Scanner;

/**
 * This class simply opens a scanner for input, accepts a limit for the highest term in a sequence, and calculates the 
 * Fibonacci Sequence up to said limit. 
 * <p>An important note to consider with summation in Java is that integer overflow can set in rather quickly at larger terms.
 * Long type values have been used to reduce this risk, but it cannot be fully removed. Unusual negative values will appear when integer overflow has been reached.</p>
 * <p>Furthermore, because this program is using recursive code (as requested), it will slow down dramatically when set for large term limits.</p>
 * @author Jordan Roig
 * @since 15.02+7
 */
public class Assignment2Main {

	/**
	 * This main method hosts a Scanner to accept inputs. The input integer is passed as a parameter to the fibonacci() method
	 * and the result is printed in the console window.
	 * @param args This variable handles the inputs passed to the JVM from the console and are standard to main methods. 
	 * The parameter does nothing in this code, as inputs are handled at runtime by Scanner.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the number of terms in the sequence.");
		int limit = input.nextInt();
		long result = fibonacci(limit);
		System.out.println("Calculator found term " + limit + " to equal " + result);
		input.close();

	}
	
	/**
	 * This code recursively calculates the Fibonacci sequence up to a given value. 
	 * It calls back upon itself for every value and adds up the totals until it can reach a solution for the last two terms in the sequence and adds them together.
	 * @param n The last term of the sequence, used to set a limit on how far the program will go.
	 * @return This locates the two terms before the limit and adds them together to solve for the last term, and then returns it.
	 * Because the program is constantly referring to itself, it will continue until it reaches 0 or 1, and add them all up to get an answer.
	 */
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
