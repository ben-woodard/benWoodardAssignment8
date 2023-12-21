package com.coderscampus.assignment;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Assignment8Application {

	public static void main(String[] args) {
		NumberSortingService service = new NumberSortingService();
		service.sortNumbers();
	}
}
