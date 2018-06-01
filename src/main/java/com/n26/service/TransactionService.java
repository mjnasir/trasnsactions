package com.n26.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.n26.comparator.TimestampComparator;
import com.n26.entity.Stats;
import com.n26.entity.Transaction;
import com.n26.util.Util;

@Service
public class TransactionService {
	private static final int SIZE = 1000;
	private BlockingQueue<Transaction> transactions = new PriorityBlockingQueue<>(SIZE, new TimestampComparator());
	private Stats stats = Stats.getInstance();

	public boolean createTransaction(Transaction transaction) {
		if (Util.olderThan60Seconds(transaction)) {
			return transactions.add(transaction);
			
		}
		return false;
	}

	public Stats getStats() {
		return this.stats;
	}

	@Scheduled(fixedRate = 1)
	private void removeEntries() {
		while (!transactions.isEmpty() && !Util.olderThan60Seconds(transactions.peek())) {
			transactions.poll();
		}
		stats.update(transactions);
	}

}
