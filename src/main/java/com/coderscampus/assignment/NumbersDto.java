package com.coderscampus.assignment;

import java.util.concurrent.atomic.AtomicInteger;

public class NumbersDto {

	private AtomicInteger number;
	private AtomicInteger instanceCount;

	public NumbersDto(AtomicInteger number) {
		this.number = number;
		this.instanceCount = new AtomicInteger(1);
	}

	public void incrementInstanceCount() {
		synchronized (instanceCount) {
			instanceCount.getAndIncrement();
		}
	}

	public AtomicInteger getNumber() {
		return number;
	}

	public void setNumber(AtomicInteger number) {
		this.number = number;
	}

	public AtomicInteger getInstanceCounter() {
		return instanceCount;
	}

	public void setInstanceCounter(AtomicInteger instanceCounter) {
		this.instanceCount = instanceCounter;
	}

}
