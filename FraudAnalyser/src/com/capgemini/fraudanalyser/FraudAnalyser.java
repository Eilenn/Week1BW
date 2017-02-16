package com.capgemini.fraudanalyser;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FraudAnalyser {

	// private Set listOfTransactions;
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

		Set<LocalDate> uniqueDatesInAnalyzedList = new HashSet<>();
		uniqueDatesInAnalyzedList = getUniqueDatesWithoutHour(transactionsToAnalyze);
		Set uniqueUsersInAnalyzedList = new HashSet<>();
		uniqueUsersInAnalyzedList = getUniqueUsers(transactionsToAnalyze);
		analyseNumberOfTransactionsPerUserPerDay(transactionsToAnalyze, uniqueUsersInAnalyzedList,
				uniqueDatesInAnalyzedList);
		for (int i = 0; i < transactionsToAnalyze.size(); i++) {
			Transaction t = transactionsToAnalyze.get(i);

		}

		// check conditions
		// add suspects to list
		// returns
		if (listOfSuspectTransactions.isEmpty()) {
			return null;
			// throw new IllegalStateException("There are no suspect
			// transactions");
		}
		return listOfSuspectTransactions;
	}

	public Set<Transaction> analyseNumberOfTransactionsPerUserPerDay(ArrayList<Transaction> transactionsToAnalyze,
			Set uniqueUsersInAnalyzedList, Set<LocalDate> uniqueDatesInAnalyzedList) {
		Set<Transaction> suspectTransactions = new HashSet<>();
		// converting set to list, so it's navigable
		List users=new ArrayList();
		users.addAll(uniqueUsersInAnalyzedList);
		List<LocalDate> dates=new ArrayList<>();
		dates.addAll(uniqueDatesInAnalyzedList);
		transactionsToAnalyze.sort(Transaction.COMPARE_BY_DATE_OF_TRANSFER);
		for (int user = 0; user < users.size(); user++) {
			
			for (int date = 0; date < dates.size(); date++) {
				ArrayList<Transaction> transactionsOnSpecificDay= new ArrayList<>();
				transactionsOnSpecificDay = FilteringByDate.filter(transactionsToAnalyze,
						dates.get(date));
				ArrayList<Transaction> transactionsOnSpecificDayBySpecificUser= new ArrayList<>();
				transactionsOnSpecificDayBySpecificUser = FilteringByUser.filter(transactionsOnSpecificDay,
						(Integer)users.get(user));
				// if more than five on one day by user - susspect transaction
				int countTransactions=transactionsOnSpecificDayBySpecificUser.size();
				if(countTransactions>5){
					suspectTransactions.addAll(transactionsOnSpecificDayBySpecificUser);
				}
			}
		}

		return suspectTransactions;

	}

	public static Set getUniqueUsers(ArrayList<Transaction> transactionsToAnalyze) {
		Set users = new HashSet<>();
		for (int i = 0; i < transactionsToAnalyze.size(); i++) {
			users.add(transactionsToAnalyze.get(i).getUserID());
		}

		return users;
	}

	public static Set<LocalDate> getUniqueDatesWithoutHour(ArrayList<Transaction> transactionsToAnalyze) {
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
