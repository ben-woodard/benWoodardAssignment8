package com.coderscampus.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberSortingService {

	ExecutorService ioExecutor = Executors.newCachedThreadPool();
	List<Integer> numbersList = new ArrayList<>();
	Map<Integer, AtomicInteger> numbersMap = new ConcurrentHashMap<>();
	List<CompletableFuture<List<Integer>>> futuresList = new ArrayList<>();

	// Sorting numbers Method
	public void sortNumbers() {
		Assignment8 assignment = new Assignment8();
		for (int i = 0; i < 1000; i++) {
			CompletableFuture<List<Integer>> task = CompletableFuture.supplyAsync(() -> {
				numbersList = assignment.getNumbers();
				numbersList.stream()
						   .forEach(element -> checkForNumber(element));
				return numbersList;
			}, ioExecutor);

			futuresList.add(task);
		}

		while (futuresList.stream().filter(CompletableFuture::isDone).count() < 1000) {
			// while loop to keep main thread alive
		}
		System.out.println(numbersMap);
	}
	
	// Method to check if number exists in map and increment value, else create new
	// Key and Value
	public void checkForNumber(Integer key) {
		if (numbersMap.containsKey(key)) {
			synchronized (key) {
				numbersMap.get(key).getAndIncrement();
			}
		} else {
			synchronized (key) {
				numbersMap.put(key, new AtomicInteger(1));
			}
		}
	}

}
