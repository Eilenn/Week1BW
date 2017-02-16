package com.capgemini.fraudanalyser;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FilteringByRecipientAccountTest {

	private ArrayList<Transaction> transactionsToAnalyze;
	private FilteringByDate filteringByRecipientAccount;

	@Before
	public void init() {
		transactionsToAnalyze = new ArrayList<>();
		transactionsToAnalyze.add(new Transaction.Builder(100, 12345L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 1, 12, 0)).build());
		transactionsToAnalyze.add(new Transaction.Builder(102, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 2, 12, 0)).build());
		transactionsToAnalyze.add(new Transaction.Builder(101, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 3, 12, 0)).build());
		transactionsToAnalyze.add(new Transaction.Builder(103, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 3, 12, 0)).build());
		filteringByRecipientAccount = new FilteringByDate();
	}

	@Test
	public void shouldReturnEmptyListForAccountNotOnTheList() {
		// given
		ArrayList<Transaction> filteredTransactions = new ArrayList<>(); // when
		filteredTransactions = FilteringByRecipientAccount.filter(transactionsToAnalyze, 12340L);
		// then
		assertEquals(0, filteredTransactions.size());
	}

	@Test
	public void shouldReturnOneElementListForOneTransactionOfWithRecipientAccountOnTheList() {
		// given
		ArrayList<Transaction> filteredTransactions = new ArrayList<>();
		// when
		filteredTransactions = FilteringByRecipientAccount.filter(transactionsToAnalyze, 12345L);
		// then
		assertEquals(1, filteredTransactions.size());
	}

	@Test
	public void shouldReturnFiveFor5TransactionsWithRecipientAccountOnTheList() {
		// given
		ArrayList<Transaction> transactionsToAnalyzeByAccount = new ArrayList<>();
		transactionsToAnalyzeByAccount.add(new Transaction.Builder(101, 12345L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 1, 12, 0)).build());
		transactionsToAnalyzeByAccount.add(new Transaction.Builder(100, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 2, 12, 0)).build());
		transactionsToAnalyzeByAccount.add(new Transaction.Builder(100, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 3, 12, 0)).build());
		transactionsToAnalyzeByAccount.add(new Transaction.Builder(100, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 4, 12, 0)).build());
		transactionsToAnalyzeByAccount.add(new Transaction.Builder(100, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 5, 12, 0)).build());
		transactionsToAnalyzeByAccount.add(new Transaction.Builder(100, 12346L, new BigDecimal("200.0"),
				LocalDateTime.of(2014, Month.JANUARY, 6, 12, 0)).build());
		ArrayList<Transaction> filteredTransactions = new ArrayList<>();
		// when
		filteredTransactions = FilteringByRecipientAccount.filter(transactionsToAnalyzeByAccount, 12346L);
		// then
		assertEquals(5, filteredTransactions.size());
	}

}
