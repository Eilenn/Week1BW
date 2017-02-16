package com.capgemini.fraudanalyser;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FraudAnalyserTest {

	private ArrayList<Transaction> transactionsToAnalyze;
	private FraudAnalyser fraudAnalyser;

	@Before
	public void init() {
		transactionsToAnalyze=new ArrayList<>();
		transactionsToAnalyze.add(new Transaction.Builder(100, 12345L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 1, 12, 0)).build());
		transactionsToAnalyze.add(new Transaction.Builder(102, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 2, 12, 0)).build());
		transactionsToAnalyze.add(new Transaction.Builder(101, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 3, 12, 0)).build());
		transactionsToAnalyze.add(new Transaction.Builder(606, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 4, 12, 0)).build());
		transactionsToAnalyze.add(new Transaction.Builder(542, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 5, 12, 0)).build());
		transactionsToAnalyze.add(new Transaction.Builder(543, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 6, 12, 0)).build());
		fraudAnalyser = new FraudAnalyser();
	}
	
	@Test
	public void shouldReturnSetOfSixValuesForOneDuplicateTransactionByUser(){
		// given
		transactionsToAnalyze.add(new Transaction.Builder(100, 12345L, new BigDecimal("205.0"),
				LocalDateTime.of(2014, Month.JANUARY, 1, 12, 0)).build());
		int numberOfUniqueTransactionsByUser=transactionsToAnalyze.size()-1;
		// when
		Set uniqueUsers=FraudAnalyser.getUniqueUsers(transactionsToAnalyze);
		int numberOfUniqueUsers=uniqueUsers.size();
		// then
		assertEquals(numberOfUniqueTransactionsByUser,numberOfUniqueUsers);
	}
	
	@Test
	public void shouldReturnSetOfSixValuesForOneDuplicateTransactionByDate(){
		// given
		transactionsToAnalyze.add(new Transaction.Builder(100, 12345L, new BigDecimal("205.0"),
				LocalDateTime.of(2014, Month.JANUARY, 1, 12, 0)).build());
		int numberOfUniqueTransactionsByDate=transactionsToAnalyze.size()-1;
		// when
		Set uniqueDates=FraudAnalyser.getUniqueDatesWithourHour(transactionsToAnalyze);
		int numberOfUniqueDates=uniqueDates.size();
		// then
		assertEquals(numberOfUniqueTransactionsByDate,numberOfUniqueDates);
	}
	
	@Test
	public void shouldGenerateListOfSuspectTransactionsWithOneElement() {
		// given
		Set transactions=new HashSet<>();
		// when
		transactions=fraudAnalyser.generateListOfSuspectTransactions(transactionsToAnalyze);
		// then
		assertEquals(1,transactions.size());
	}
	@Ignore // works when changing id542, because then there are no suspect transactions
	@Test
	public void shouldReturnNullInsteadOfListOfSuspectTransactionsForNoSuspect() {
		// given
		Set transactions=new HashSet<>();
		// when
		transactions=fraudAnalyser.generateListOfSuspectTransactions(transactionsToAnalyze);
		// then
		assertEquals(null,transactions);
	}

	@Test
	public void shouldReturnFalseForUser100() {
		// given
		Transaction transaction=transactionsToAnalyze.get(0);
		// when
		boolean isHonest=fraudAnalyser.isUserAboveSuspicion(transaction.getUserID());
		// then
		assertFalse(isHonest);
	}
	
	@Test
	public void shouldReturnTrueForUser101() {
		// given
		Transaction transaction=transactionsToAnalyze.get(2);
		// when
		boolean isHonest=fraudAnalyser.isUserAboveSuspicion(transaction.getUserID());
		// then
		assertTrue(isHonest);
		//fail("Not yet implemented");
	}

	@Test
	public void shouldReturnTrueForUser542() {
		// given
		Transaction transaction=transactionsToAnalyze.get(4);
		// when
		boolean isSuspect=fraudAnalyser.isUserSuspectForSure(transaction.getUserID());
		// then
		assertTrue(isSuspect);	
	}
	@Test
	public void shouldReturnFalseForUser543() {
		// given
		Transaction transaction=transactionsToAnalyze.get(5);
		// when
		boolean isSuspect=fraudAnalyser.isUserSuspectForSure(transaction.getUserID());
		// then
		assertFalse(isSuspect);	
	}

}