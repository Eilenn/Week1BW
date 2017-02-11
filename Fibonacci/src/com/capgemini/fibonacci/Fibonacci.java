package com.capgemini.fibonacci;
/**
 * Fibonacci returns value of given element of Fibonacci series given by int.
 * Returns 1 for first and second elements of Fibonacci series.
 * Cannot compute results for elements' number beyond 92. 
 * @author BOWROBEL
 *
 */


public class Fibonacci {
	public Fibonacci() {

	}
/**
 * returns value of given element of Fibonacci series, checking if value can be computed first
 * @param seriesElementNumber
 * @return long value of Fibonacci series for given element
 */
	// n - series' element number
	public static long fib(int seriesElementNumber) {
		if(evaluateFib(seriesElementNumber)<0){
			throw new ResultOutOfRangeException("Result of this operation is out of range");
		}
		return evaluateFib(seriesElementNumber);
	}
/**
 * computes value of Fibonacci series element
 * @param seriesElementNumber
 * @return long value of Fibonacci series for given element
 */
	public static long evaluateFib(int seriesElementNumber) {
		if (seriesElementNumber <= 0) {
			throw new IllegalArgumentException("Element's number must be a non-negative number!");
		} else if (seriesElementNumber == 1 || seriesElementNumber == 2) {
			return 1;
		} else {
			long[] elementsOfFibonacci = new long[seriesElementNumber + 1];
			elementsOfFibonacci[0] = 0;
			elementsOfFibonacci[1] = 1;
			elementsOfFibonacci[2] = 1;
			for (int i = 3; i <= seriesElementNumber; i++) {
				elementsOfFibonacci[i] = elementsOfFibonacci[i - 1] + elementsOfFibonacci[i - 2];
			}
			return elementsOfFibonacci[seriesElementNumber];
		}

	}

}
