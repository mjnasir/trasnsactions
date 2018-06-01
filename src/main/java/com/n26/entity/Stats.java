package com.n26.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Queue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Stats implements Serializable{

	private Double sum;
    private Double avg;
    private Double max;
    private Double min;
    private Long count;
	
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		this.min = min;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public static void setInstance(Stats instance) {
		Stats.instance = instance;
	}
		private static Stats instance = null;
	    private Stats(){
	    	
	    }
	    public static Stats getInstance(){
	    	if(instance == null){
	    		instance = new Stats();
	    	}
	    	return instance;
	    }
	    public void update(Queue<Transaction> transactions) {
	    	
	    	List<Double> last60SecondsTransaction = transactions.stream().map(Transaction::getAmount).collect(Collectors.toList());
            if(transactions.size() > 0){
	    	max = last60SecondsTransaction.stream().max(Double::compareTo).get();
	    	min = last60SecondsTransaction.stream().min(Double::compareTo).get();
	    	sum = last60SecondsTransaction.stream().mapToDouble(Double::doubleValue).sum();
	    	avg = last60SecondsTransaction.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
	    	count = (long) transactions.size();
	    	}

		}
	    
}
