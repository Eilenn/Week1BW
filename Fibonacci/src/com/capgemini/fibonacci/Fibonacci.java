package com.capgemini.fibonacci;

public class Fibonacci {
	public Fibonacci() {

	}

	// n - ktory element ciagu
	public static long fib(int n) throws ResultOutOfRangeException {
		if(obliczFib(n)>Long.MAX_VALUE){
			throw new ResultOutOfRangeException("Wynik operacji nie miesci sie w zakresie long");
		}
		return obliczFib(n);
	}

	public static long fib(double a) {
		int n = (int) Math.round(a);
		return obliczFib(n);
	}

	public static long obliczFib(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Numer elementu ciagu musi byc liczba nieujemna!");
		} else if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		} else {
			long[] elementyCiagu = new long[n + 1];
			elementyCiagu[0] = 0;
			elementyCiagu[1] = 1;
			elementyCiagu[2] = 1;
			for (int i = 3; i <= n; i++) {
				elementyCiagu[i] = elementyCiagu[i - 1] + elementyCiagu[i - 2];
			}
			return elementyCiagu[n];
		}

	}

}
