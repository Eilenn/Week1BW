package com.capgemini.fraudanalyser;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class FilteringByDate{
	
	public static ArrayList<Transaction> filter(ArrayList<Transaction> transactionsToAnalyze, LocalDate dateOfTransaction) {
		ArrayList<Transaction> transactionsByDate=new ArrayList<>();
		for (int i=0;i<transactionsToAnalyze.size();i++) {
			Transaction analyzedTransaction=transactionsToAnalyze.get(i);
			if(analyzedTransaction.getDateWithoutHour().equals(dateOfTransaction)){
				transactionsByDate.add(analyzedTransaction);
			}
		}
		
		return transactionsByDate;
	}

	}
