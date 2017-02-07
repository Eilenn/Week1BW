package com.capgemini.fibonacci;

public class Fibonacci {
	public Fibonacci(){
		
	}
	// n - ktory element ciagu
	public long fib(int n) {
		if (n == 0) {
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

	public static void main(String[] args) {
		Fibonacci ciag=new Fibonacci();
		System.out.println(ciag.fib(9));
	}
}
