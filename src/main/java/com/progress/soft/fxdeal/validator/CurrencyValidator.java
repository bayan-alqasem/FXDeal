package com.progress.soft.fxdeal.validator;

import org.springframework.stereotype.Component;

import com.progress.soft.fxdeal.dto.Currency;

@Component
public class CurrencyValidator {

	public boolean isValidCurrency(String code) {
        for (Currency currency : Currency.values()) {
            if (currency.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
}
