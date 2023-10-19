package com.progress.soft.fxdeal.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.soft.fxdeal.dto.FXDealDto;
import com.progress.soft.fxdeal.entity.FXDeal;
import com.progress.soft.fxdeal.exception.IdNotFoundException;
import com.progress.soft.fxdeal.exception.InvalidISOCurrency;
import com.progress.soft.fxdeal.repository.FXDealRepo;
import com.progress.soft.fxdeal.validator.CurrencyValidator;

@Service
public class FXDealService {

	private final FXDealRepo fXDealRepo;

	@Autowired
	private ModelMapper modelMapper;

	private final CurrencyValidator currencyValidator;

	public FXDealService(FXDealRepo fXDealRepo, CurrencyValidator currencyValidator) {
		this.fXDealRepo = fXDealRepo;
		this.currencyValidator = currencyValidator;
	}

	public FXDeal save(FXDealDto fxDealDto) throws InvalidISOCurrency {

		if (!currencyValidator.isValidCurrency(fxDealDto.getFromCurrency())) {
			throw new InvalidISOCurrency("Invalid 'fromCurrency' value: " + fxDealDto.getFromCurrency());
		}

		if (!currencyValidator.isValidCurrency(fxDealDto.getToCurrency())) {
			throw new InvalidISOCurrency("Invalid 'toCurrency' value: " + fxDealDto.getToCurrency());
		}

		
		FXDeal fxDeal = modelMapper.map(fxDealDto, FXDeal.class);
		fxDeal = fXDealRepo.save(fxDeal);
		return fxDeal;
	}

	public FXDeal findById(Integer id) {
		Optional<FXDeal> fxDeal = fXDealRepo.findById(id);
		if (fxDeal.isPresent()) {
			return fxDeal.get();
		} else {
			throw new IdNotFoundException("Deal with ID " + id + " not found");
		}
	}

}
