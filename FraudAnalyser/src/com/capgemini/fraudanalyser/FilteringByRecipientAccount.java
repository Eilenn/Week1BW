package com.capgemini.fraudanalyser;

import java.util.ArrayList;

public class FilteringByRecipientAccount {

	public static ArrayList<Transaction> filter(ArrayList<Transaction> transactionsToAnalyze, long recipientAccount) {
		ArrayList<Transaction> transactionsByRecipientAccount = new ArrayList<>();
		for (int i = 0; i < transactionsToAnalyze.size(); i++) {
			Transaction analyzedTransaction = transactionsToAnalyze.get(i);
			if (analyzedTransaction.getRecipientAccount() == recipientAccount) {
				transactionsByRecipientAccount.add(analyzedTransaction);
			}
		}

		return transactionsByRecipientAccount;
	}
}
