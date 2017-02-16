package com.capgemini.fraudanalyser;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FilteringByUserTest {

	private ArrayList<Transaction> transactionsToAnalyze;
	private FilteringByUser filteringByUser;

	@Before
	public void init() {
		transactionsToAnalyze=new ArrayList<>();
		transactionsToAnalyze.add(new Transaction.Builder(100, 12345L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 1, 12, 0)).build());
		transactionsToAnalyze.add(new Transaction.Builder(102, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 1, 12, 0)).build());
		transactionsToAnalyze.add(new Transaction.Builder(101, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 1, 12, 0)).build());
		filteringByUser = new FilteringByUser();
	}

	@Test
	public void shouldReturnEmptyListForUserNotOnTheList() {
		// given
		ArrayList<Transaction> filteredTransactions = new ArrayList<>();
		// when
		filteredTransactions = FilteringByUser.filter(transactionsToAnalyze, 200);
		// then
		assertEquals(0, filteredTransactions.size());
	}
	
	@Test
	public void shouldReturn1ElementListForOneTransactionOfTheUserOnTheList() {
		// given
		ArrayList<Transaction> filteredTransactions = new ArrayList<>();
		// when
		filteredTransactions = FilteringByUser.filter(transactionsToAnalyze, 100);
		// then
		assertEquals(1, filteredTransactions.size());
	}
	
	@Test
	public void shouldReturnTrueForOneTransactionOfTheUser100OnTheList() {
		// given
		ArrayList<Transaction> filteredTransactions = new ArrayList<>();
		// when
		filteredTransactions = FilteringByUser.filter(transactionsToAnalyze, 100);
		boolean isUser100=filteredTransactions.get(0).getUserID()==100;;
		// then
		assertTrue(isUser100);
	}

}
