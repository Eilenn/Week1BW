package com.capgemini.fraudanalyser;

import java.util.ArrayList;
import java.util.Set;

/**
 * This class enables filtering given list of transactions by provided user ID.
 * 
 * @author BOWROBEL
 *
 */
public class FilteringByUser{

/**
 * filters transaction list by user ID, returns list of transactions made by this user.
 * @param transactionsToAnalyze
 * @param userID
 * @return
 */
	public static ArrayList<Transaction> filter(ArrayList<Transaction> transactionsToAnalyze, int userID) {
		ArrayList<Transaction> transactionsByUser=new ArrayList<>();
		for (int i=0;i<transactionsToAnalyze.size();i++) {
			Transaction analyzedTransaction=transactionsToAnalyze.get(i);
			if(analyzedTransaction.getUserID()==userID){
				transactionsByUser.add(analyzedTransaction);
			}
		}
		
		return transactionsByUser;
	}



}
