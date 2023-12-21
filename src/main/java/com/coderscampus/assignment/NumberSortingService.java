package com.coderscampus.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberSortingService {

	
	ExecutorService ioExecutor = Executors.newFixedThreadPool(100);
	List<Integer> numbersList = new ArrayList<>();
	Map<Integer, AtomicInteger> numbersMap = new ConcurrentHashMap<>();
	
   //Sorting numbers Method
	public Map<Integer, AtomicInteger>sortNumbers() {
		Assignment8 assignment = new Assignment8();
		for (int i = 0; i < 1000; i++) {
			CompletableFuture.supplyAsync(() -> {
						numbersList = assignment.getNumbers();
						numbersList.stream()
								   .forEach(element -> checkForNumber(element));
						return numbersMap;
			}, ioExecutor);					
		}
		
		return numbersMap;
	}
	
	public void printDataToConsole(Map numbersMap) {
		System.out.println(numbersMap.toString());
	}

	public Map<Integer, AtomicInteger> checkForNumber(Integer key) {
		if(numbersMap.containsKey(key)) {
			synchronized (key) {
				numbersMap.get(key).getAndIncrement();	
			}
		} else {
			synchronized (key) {
				numbersMap.put(key, new AtomicInteger(1));
			}
		}
		return numbersMap;
	}
	
}
