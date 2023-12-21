package com.coderscampus.assignment;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class NumbersDto {

	private Integer number;
	private AtomicInteger instanceCount;
	NumbersDto newNumberDto;

	public void createNumbers(Optional<AtomicInteger> number) {

		if (number.isPresent()) {
			incrementInstanceCount();
		} else {
			newNumberDto = new NumbersDto(number);
		}
	}

	public NumbersDto(Integer number) {
		this.number = number;
		this.instanceCount = new AtomicInteger(1);
	}

	public void incrementInstanceCount() {
		synchronized (instanceCount) {
			instanceCount.getAndIncrement();
		}
	}

	public Integer getNumber() {
		return number;
	}

	public Integer setNumber(Integer number) {
		this.number = number;
		return number;
	}

	public AtomicInteger getInstanceCount() {
		return instanceCount;
	}

	public AtomicInteger setInstanceCount() {
		this.instanceCount = 1;
		return instanceCount;
	}

}
