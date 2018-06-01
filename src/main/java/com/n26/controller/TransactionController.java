package com.n26.controller;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.entity.Stats;
import com.n26.entity.Transaction;
import com.n26.service.TransactionService;

@RestController
public class TransactionController {


	@Autowired
	TransactionService service;

	@RequestMapping(value={"/transactions"},method=RequestMethod.POST)
	@ResponseBody
	public Callable<ResponseEntity> transactions(@RequestBody Transaction transaction)
			throws IOException, ExecutionException, InterruptedException {

		return ()->{
			return ResponseEntity.status(service.createTransaction(transaction)?HttpStatus.CREATED:HttpStatus.NO_CONTENT).body(null);
		};
	}
	@RequestMapping(value={"/statistics"},method=RequestMethod.GET)
	public Stats statistics()
			throws IOException, ExecutionException, InterruptedException {
			return service.getStats();
	}	
}

