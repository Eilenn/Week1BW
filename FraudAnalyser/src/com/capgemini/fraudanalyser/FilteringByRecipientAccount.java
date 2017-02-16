package com.capgemini.fraudanalyser;

import java.util.ArrayList;

/**
 * This class filters transaction list by provided account of the recipient.
 * 
 * @author BOWROBEL
 *
 */
public class FilteringByRecipientAccount {

	/**
	 * filters list of transactions by recipient account, returns list of
	 * transactions involving recipient account.
	 * 
	 * @param transactionsToAnalyze
	 * @param recipientAccount
	 * @return
	 */
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
