package com.n26.util;

import com.n26.entity.Transaction;

public class Util {

	
	public static boolean inLast60Seconds(Transaction transaction){
		return System.currentTimeMillis() - transaction.getTimeStamp() <= 60000;
	}
	
} 
