package com.capgemini.fraudanalyser;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class enables filtering given list of transactions by provided date
 * shortened to year, month and day.
 * 
 * @author BOWROBEL
 *
 */
public class FilteringByDate {
	/**
	 * filters transaction list by date, returns list of transactions on this
	 * date.
	 * 
	 * @param transactionsToAnalyze
	 * @param dateOfTransaction
	 * @return
	 */
	public static ArrayList<Transaction> filter(ArrayList<Transaction> transactionsToAnalyze,
			LocalDate dateOfTransaction) {
		ArrayList<Transaction> transactionsByDate = new ArrayList<>();
		for (int i = 0; i < transactionsToAnalyze.size(); i++) {
			Transaction analyzedTransaction = transactionsToAnalyze.get(i);
			if (analyzedTransaction.getDateWithoutHour().equals(dateOfTransaction)) {
				transactionsByDate.add(analyzedTransaction);
			}
		}

		return transactionsByDate;
	}

}
