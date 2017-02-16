package com.capgemini.fraudanalyser;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AllRulesTogetherTest {
	private ArrayList<Transaction> listOfTransactions;
	private Transaction t;
	private FraudAnalyser analyser;

	@Before
	public void init() {
		listOfTransactions = new ArrayList<>();
		analyser = new FraudAnalyser();
		t = new Transaction.Builder().withUserID(100).withRecipientAccount(1200L)
				.withAmountOfMoneyTransferred(new BigDecimal(200)).withDateOfTransfer(LocalDateTime.now()).build();

	}

	@Test
	public void shouldReturnNullForOrdinaryUser() {
		// given
		listOfTransactions.add(t);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(null, suspiciousTransactions);

	}

}
