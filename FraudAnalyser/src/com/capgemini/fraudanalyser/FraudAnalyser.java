package com.capgemini.fraudanalyser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FraudAnalyser {

	//private Set listOfTransactions;
	private int[] suspects = { 542, 1052, 2103 };
	private int[] honestUsers = { 101, 606 };



	public Set<Transaction> generateListOfSuspectTransactions(ArrayList<Transaction> transactionsToAnalyze) {
		Set<Transaction> listOfSuspectTransactions = new HashSet<>();
		Set<Transaction> temporarySuspectTransactionsInAnalyzedList = new HashSet<>();
		for (int i = 0; i < transactionsToAnalyze.size(); i++) {
			Transaction t = transactionsToAnalyze.get(i);
			if (isUserAboveSuspicion(t.getUserID())) {
				temporarySuspectTransactionsInAnalyzedList.add(t);
			} else if (isUserSuspectForSure(t.getUserID())) {
				listOfSuspectTransactions.add(t);
			}
		}
		transactionsToAnalyze.removeAll(temporarySuspectTransactionsInAnalyzedList);
		
		Set <LocalDate> datesInAnalyzedList=new HashSet<>();
		datesInAnalyzedList=getUniqueDatesWithourHour(transactionsToAnalyze);
		Set usersInAnalyzedList=new HashSet<>();
		usersInAnalyzedList=getUniqueUsers(transactionsToAnalyze);
		for (int i = 0; i < transactionsToAnalyze.size(); i++) {
			Transaction t = transactionsToAnalyze.get(i);
			
		}

		// check conditions
		// add suspects to list
		// return
		if (listOfSuspectTransactions.isEmpty()) {
			return null;
			// throw new IllegalStateException("There are no suspect
			// transactions");
		}
		return listOfSuspectTransactions;
	}
	
	public static Set getUniqueUsers(ArrayList<Transaction> transactionsToAnalyze) {
		Set users = new HashSet<>();
		for (int i = 0; i < transactionsToAnalyze.size(); i++) {
			users.add(transactionsToAnalyze.get(i).getUserID());
		}

		return users;
	}

	public static Set<LocalDate> getUniqueDatesWithourHour(ArrayList<Transaction> transactionsToAnalyze) {
		Set<LocalDate> dates = new HashSet<>();
		for (int i = 0; i < transactionsToAnalyze.size(); i++) {
			Transaction t = transactionsToAnalyze.get(i);
			dates.add(t.getDateWithoutHour());
		}

		return dates;
	}
	public boolean isUserAboveSuspicion(int userID) {
		for (int i = 0; i < honestUsers.length; i++) {
			if (userID == honestUsers[i]) {
				return true;
			}
		}
		return false;
	}

	public boolean isUserSuspectForSure(int userID) {
		for (int i = 0; i < suspects.length; i++) {
			if (userID == suspects[i]) {
				return true;
			}
		}
		return false;

	}

}
