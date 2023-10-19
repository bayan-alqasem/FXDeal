package com.progress.soft.fxdeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.soft.fxdeal.validator.CurrencyValidator;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyValidator currencyValidator;

	public boolean isCurrencyCodeValid(String code) {
		return currencyValidator.isValidCurrency(code);
	}

}
