package com.capgemini.fibonacci;

public class Fibonacci {
	public Fibonacci() {

	}

	// n - ktory element ciagu
	public static long fib(int n) {
		if(evaluateFib(n)>Long.MAX_VALUE){
			throw new ResultOutOfRangeException("Result of this operation is out of range");
		}
		return evaluateFib(n);
	}

	public static long fib(double a) {
		int n = (int) Math.round(a);
		return evaluateFib(n);
	}

	public static long evaluateFib(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Element's number must be a non-negative number!");
		} else if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		} else {
			long[] elementsOfFibonacci = new long[n + 1];
			elementsOfFibonacci[0] = 0;
			elementsOfFibonacci[1] = 1;
			elementsOfFibonacci[2] = 1;
			for (int i = 3; i <= n; i++) {
				elementsOfFibonacci[i] = elementsOfFibonacci[i - 1] + elementsOfFibonacci[i - 2];
			}
			return elementsOfFibonacci[n];
		}

	}

}
