package com.n26.comparator;

import java.util.Comparator;

import com.n26.entity.Transaction;

public class TimestampComparator implements Comparator<Transaction>{

	@Override
	 public int compare(Transaction t1, Transaction t2) {
        return t1.getTimeStamp().compareTo(t2.getTimeStamp());
    }
}
