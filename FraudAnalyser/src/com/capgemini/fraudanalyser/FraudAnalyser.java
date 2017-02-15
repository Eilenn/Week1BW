package com.capgemini.fraudanalyser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FraudAnalyser {

	private Set listOfTransactions;
	//private Set users;
	//private Set dates;
	
	public static Set getUniqueUsers(ArrayList<Transaction> transactionsForAnalyze){
		Set users=new HashSet<>();
		for(int i=0;i<transactionsForAnalyze.size();i++){
			users.add(transactionsForAnalyze.get(i).getUserID());
		}
		
		return users;
	}
	
	public static Set getUniqueDates(ArrayList<Transaction> transactionsForAnalyze){
		Set dates=new HashSet<>();
		for(int i=0;i<transactionsForAnalyze.size();i++){
			dates.add(transactionsForAnalyze.get(i).getDateOfTransfer());
		}
		
		return dates;
	}
	
	public void generateListOfTransactions(){
		
	}
}
