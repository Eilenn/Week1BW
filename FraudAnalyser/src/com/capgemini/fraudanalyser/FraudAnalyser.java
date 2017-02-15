package com.capgemini.fraudanalyser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FraudAnalyser {

	private Set listOfTransactions;
	private int[] suspects = { 542, 1052, 2103 };
	private int[] honestUsers = { 101, 606 };
	// private Set users;
	// private Set dates;

	public static Set getUniqueUsers(ArrayList<Transaction> transactionsForAnalize) {
		Set users = new HashSet<>();
		for (int i = 0; i < transactionsForAnalize.size(); i++) {
			users.add(transactionsForAnalize.get(i).getUserID());
		}

		return users;
	}

	public static Set getUniqueDates(ArrayList<Transaction> transactionsForAnalize) {
		Set dates = new HashSet<>();
		for (int i = 0; i < transactionsForAnalize.size(); i++) {
			dates.add(transactionsForAnalize.get(i).getDateOfTransfer());
		}

		return dates;
	}

	public Set generateListOfSuspectTransactions(ArrayList<Transaction> transactionsForAnalize) {
		Set listOfSuspectTransactions = new HashSet<>();
		Set<Transaction> suspectTransactionInList=new HashSet<>();
		for(int i=0;i<transactionsForAnalize.size();i++){
			Transaction t=transactionsForAnalize.get(i);
			if (isUserAboveSuspicion(t.getUserID())){
				suspectTransactionInList.add(t);
			}
			else if(isUserSuspectForSure(t.getUserID())){
				listOfSuspectTransactions.add(t);
			}
		}
		transactionsForAnalize.removeAll(suspectTransactionInList);
	
/*		for (Transaction t : transactionsForAnalize) {
			if (isUserAboveSuspicion(t.getUserID())) {
				transactionsForAnalize.remove(t);
			}
			else if(isUserSuspectForSure(t.getUserID())){
				listOfSuspectTransactions.add(t);
			}

		}*/

		// check conditions
		// add suspects to list
		// return
		if(listOfSuspectTransactions.isEmpty()){
			return null;
			//throw new IllegalStateException("There are no suspect transactions");
		}
		return listOfSuspectTransactions;
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
