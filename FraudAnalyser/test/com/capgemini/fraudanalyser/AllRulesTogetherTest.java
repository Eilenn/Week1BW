package com.capgemini.fraudanalyser;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AllRulesTogetherTest {
	private ArrayList<Transaction> listOfTransactions;
	private Transaction transOrd, transSuspID, transSuspID2, transSuspID3, transHon1, transHon2;
	private Transaction transFirst5000, transSecond5000, transThird5000, transFourth5000, transExactly5000;
	private Transaction transFirst10000, transSecond10000, transThird10000, transExactly10000;
	private Transaction trans1, trans2, trans3, trans4, trans5, trans6;
	private Transaction transAccount1, transAccount2,transAccount3,transAccount4,transAccount5;
	private FraudAnalyser analyser;

	@Before
	public void init() {
		listOfTransactions = new ArrayList<>();
		analyser = new FraudAnalyser();
		transOrd = new Transaction.Builder().withUserID(100).withRecipientAccount(1200L)
				.withAmountOfMoneyTransferred(new BigDecimal(200)).withDateOfTransfer(LocalDateTime.now()).build();
		// id 542, 1052 or 2103
		transSuspID = new Transaction.Builder().withUserID(542).withRecipientAccount(1200L)
				.withAmountOfMoneyTransferred(new BigDecimal(200)).withDateOfTransfer(LocalDateTime.now()).build();
		transSuspID2 = new Transaction.Builder().withUserID(1052).withRecipientAccount(1200L)
				.withAmountOfMoneyTransferred(new BigDecimal(200)).withDateOfTransfer(LocalDateTime.now()).build();
		transSuspID3 = new Transaction.Builder().withUserID(2103).withRecipientAccount(1200L)
				.withAmountOfMoneyTransferred(new BigDecimal(200)).withDateOfTransfer(LocalDateTime.now()).build();
		// id 101 or 606
		transHon1 = new Transaction.Builder().withUserID(101).withRecipientAccount(1200L)
				.withAmountOfMoneyTransferred(new BigDecimal(200)).withDateOfTransfer(LocalDateTime.now()).build();
		transHon2 = new Transaction.Builder().withUserID(606).withRecipientAccount(1200L)
				.withAmountOfMoneyTransferred(new BigDecimal(200)).withDateOfTransfer(LocalDateTime.now()).build();
		// more than 3 transactions amounting to more than 5000
		transFirst5000 = new Transaction.Builder().withUserID(102).withRecipientAccount(1200L)
				.withAmountOfMoneyTransferred(new BigDecimal(1000)).withDateOfTransfer(LocalDateTime.now()).build();
		transSecond5000 = new Transaction.Builder().withUserID(102).withRecipientAccount(1201L)
				.withAmountOfMoneyTransferred(new BigDecimal(2050)).withDateOfTransfer(LocalDateTime.now()).build();
		transThird5000 = new Transaction.Builder().withUserID(102).withRecipientAccount(1202L)
				.withAmountOfMoneyTransferred(new BigDecimal(1949)).withDateOfTransfer(LocalDateTime.now()).build();
		transFourth5000 = new Transaction.Builder().withUserID(102).withRecipientAccount(1203L)
				.withAmountOfMoneyTransferred(new BigDecimal(2)).withDateOfTransfer(LocalDateTime.now()).build();
		transExactly5000 = new Transaction.Builder().withUserID(102).withRecipientAccount(1203L)
				.withAmountOfMoneyTransferred(new BigDecimal(1)).withDateOfTransfer(LocalDateTime.now()).build();
		// more than 2 transactions amounting to 10000
		transFirst10000 = new Transaction.Builder().withUserID(103).withRecipientAccount(1203L)
				.withAmountOfMoneyTransferred(new BigDecimal(8000)).withDateOfTransfer(LocalDateTime.now()).build();
		transSecond10000 = new Transaction.Builder().withUserID(103).withRecipientAccount(1203L)
				.withAmountOfMoneyTransferred(new BigDecimal(1999)).withDateOfTransfer(LocalDateTime.now()).build();
		transThird10000 = new Transaction.Builder().withUserID(103).withRecipientAccount(1203L)
				.withAmountOfMoneyTransferred(new BigDecimal(2)).withDateOfTransfer(LocalDateTime.now()).build();
		transExactly10000 = new Transaction.Builder().withUserID(103).withRecipientAccount(1203L)
				.withAmountOfMoneyTransferred(new BigDecimal(1)).withDateOfTransfer(LocalDateTime.now()).build();
		// more than 5 transaction of a user in one day
		trans1 = new Transaction.Builder().withUserID(104).withRecipientAccount(1203L)
				.withAmountOfMoneyTransferred(new BigDecimal(1)).withDateOfTransfer(LocalDateTime.now()).build();
		trans2 = new Transaction.Builder().withUserID(104).withRecipientAccount(1204L)
				.withAmountOfMoneyTransferred(new BigDecimal(1)).withDateOfTransfer(LocalDateTime.now()).build();
		trans3 = new Transaction.Builder().withUserID(104).withRecipientAccount(1205L)
				.withAmountOfMoneyTransferred(new BigDecimal(1)).withDateOfTransfer(LocalDateTime.now()).build();
		trans4 = new Transaction.Builder().withUserID(104).withRecipientAccount(1206L)
				.withAmountOfMoneyTransferred(new BigDecimal(1)).withDateOfTransfer(LocalDateTime.now()).build();
		trans5 = new Transaction.Builder().withUserID(104).withRecipientAccount(1207L)
				.withAmountOfMoneyTransferred(new BigDecimal(1)).withDateOfTransfer(LocalDateTime.now()).build();
		trans6 = new Transaction.Builder().withUserID(104).withRecipientAccount(1208L)
				.withAmountOfMoneyTransferred(new BigDecimal(1)).withDateOfTransfer(LocalDateTime.now()).build();
		// more than 4 transactions to the same account
		transAccount1=new Transaction.Builder().withUserID(105).withRecipientAccount(1208L)
				.withAmountOfMoneyTransferred(new BigDecimal(10)).withDateOfTransfer(LocalDateTime.now()).build();
		transAccount2=new Transaction.Builder().withUserID(105).withRecipientAccount(1208L)
				.withAmountOfMoneyTransferred(new BigDecimal(101)).withDateOfTransfer(LocalDateTime.now()).build();
		transAccount3=new Transaction.Builder().withUserID(105).withRecipientAccount(1208L)
				.withAmountOfMoneyTransferred(new BigDecimal(110)).withDateOfTransfer(LocalDateTime.now()).build();
		transAccount4=new Transaction.Builder().withUserID(105).withRecipientAccount(1208L)
				.withAmountOfMoneyTransferred(new BigDecimal(30)).withDateOfTransfer(LocalDateTime.now()).build();
		transAccount5=new Transaction.Builder().withUserID(105).withRecipientAccount(1208L)
				.withAmountOfMoneyTransferred(new BigDecimal(150)).withDateOfTransfer(LocalDateTime.now()).build();
	}

	@Test
	public void shouldReturnNullForOrdinaryUser() {
		// given
		listOfTransactions.add(transOrd);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(null, suspiciousTransactions);
	}

	@Test
	public void shouldReturnOneForSuspectUser542() {
		// given
		listOfTransactions.add(transSuspID);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(1, suspiciousTransactions.size());
	}

	@Test
	public void shouldReturnOneForSuspectUser1052() {
		// given
		listOfTransactions.add(transSuspID2);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(1, suspiciousTransactions.size());
	}

	@Test
	public void shouldReturnOneForSuspectUser2103() {
		// given
		listOfTransactions.add(transSuspID3);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(1, suspiciousTransactions.size());
	}

	@Test
	public void shouldReturnNullForHonestUser101() {
		// given
		listOfTransactions.add(transHon1);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(null, suspiciousTransactions);
	}

	@Test
	public void shouldReturnNullForHonestUser606() {
		// given
		listOfTransactions.add(transHon2);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(null, suspiciousTransactions);
	}

	@Test
	public void shouldReturnThreeForAllHonestSuspiciousAndOrdinary() {
		// given
		addTransactionsToList(listOfTransactions, transOrd, transHon1, transHon2, transSuspID, transSuspID2,
				transSuspID3);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(3, suspiciousTransactions.size());
	}

	@Test
	public void shouldReturnNullForThreeTransactionsForMoreThan5000() {
		// given
		addTransactionsToList(listOfTransactions, transFirst5000, transSecond5000, transThird5000);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(null, suspiciousTransactions);
	}

	@Test
	public void shouldReturnNullForFourTransactionsForExactly5000() {
		// given
		addTransactionsToList(listOfTransactions, transFirst5000, transSecond5000, transThird5000, transExactly5000);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(null, suspiciousTransactions);
	}

	@Test
	public void shouldReturnFourForFourTransactionsForMoreThan5000() {
		// given
		addTransactionsToList(listOfTransactions, transFirst5000, transSecond5000, transThird5000, transFourth5000);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(4, suspiciousTransactions.size());
	}

	@Test
	public void shouldReturnNullForThreeTransactionsForExactly10000() {
		// given
		addTransactionsToList(listOfTransactions, transFirst10000, transSecond10000, transExactly10000);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(null, suspiciousTransactions);
	}

	@Test
	public void shouldReturnThreeForThreeTransactionsForMoreThan10000() {
		// given
		addTransactionsToList(listOfTransactions, transFirst10000, transSecond10000, transThird10000);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(3, suspiciousTransactions.size());
	}

	@Test
	public void shouldReturnSixForSixTransactionsSameUserSameDay() {
		// given
		addTransactionsToList(listOfTransactions, trans1, trans2, trans3, trans4,trans5,trans6);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(6, suspiciousTransactions.size());
	}
	
	@Test
	public void shouldReturnNullForFiveTransactionsSameUserSameDay() {
		// given
		addTransactionsToList(listOfTransactions, trans1, trans2, trans3, trans4,trans5);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(null, suspiciousTransactions);
	}
	@Test
	public void shouldReturnFiveForFiveTransactionsToSameAccount() {
		// given
		addTransactionsToList(listOfTransactions, transAccount1, transAccount2, transAccount3, transAccount4,transAccount5);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(5, suspiciousTransactions.size());
	}
	
	@Test
	public void shouldReturnNullForFourTransactionsToSameAccount() {
		// given
		addTransactionsToList(listOfTransactions, transAccount1, transAccount2, transAccount3, transAccount4);
		// when
		Set<Transaction> suspiciousTransactions = analyser.getSuspiciousTransactions(listOfTransactions);
		// then
		assertEquals(null, suspiciousTransactions);
	}
	private void addTransactionsToList(ArrayList<Transaction> list, Transaction... transactions) {
		for (Transaction t : transactions) {
			list.add(t);
		}
	}

}
