package com.coderscampus.assignment;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberSortingService {

	Assignment8 assignment = new Assignment8();
	
	public void sortNumbers(Assignment8 assignment) {
		ExecutorService cpuExecutor = Executors.newFixedThreadPool(4);
		ExecutorService ioExecutor = Executors.newCachedThreadPool();
		List<CompletableFuture<Integer>> numbersList = assignment.getNumbers();
		
		CompletableFuture<Void> numbers = CompletableFuture.supplyAsync(() -> new Assignment8(), ioExecutor)
						 .thenAcceptAsync(numbers -> numbers.getNumbers(), cpuExecutor);
						
	
}
