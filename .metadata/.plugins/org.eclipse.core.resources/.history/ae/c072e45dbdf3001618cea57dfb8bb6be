package com.capgemini.fraudanalyser;

import java.util.ArrayList;
import java.util.Set;

public class FilteringByUser implements Filter{


	public ArrayList<Transaction> filter(ArrayList<Transaction> transactionsToAnalyze, int userID) {
		ArrayList<Transaction> transactionsByUser=new ArrayList<>();
		for (int i=0;i<transactionsToAnalyze.size();i++) {
			Transaction analyzedTransaction=transactionsToAnalyze.get(i);
			if(analyzedTransaction.getUserID()==userID){
				transactionsByUser.add(analyzedTransaction);
			}
		}
		
		return transactionsByUser;
	}

	@Override
	public boolean isSuspect(Transaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Transaction> returnListOfSuspectTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

}
