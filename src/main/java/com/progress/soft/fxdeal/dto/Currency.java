package com.progress.soft.fxdeal.dto;

public enum Currency {

	USD("USD", "United States Dollar"), EUR("EUR", "Euro"), GBP("GBP", "British Pound Sterling");

	private final String code;
	private final String name;

	Currency(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}
