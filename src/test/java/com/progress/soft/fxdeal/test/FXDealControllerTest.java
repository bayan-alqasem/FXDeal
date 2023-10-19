package com.progress.soft.fxdeal.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.progress.soft.fxdeal.dto.FXDealDto;
import com.progress.soft.fxdeal.entity.FXDeal;
import com.progress.soft.fxdeal.repository.FXDealRepo;
import com.progress.soft.fxdeal.service.FXDealService;

@SpringBootTest
public class FXDealControllerTest {

	@Autowired
	private FXDealRepo fXDealRepo;
	@Autowired
	private FXDealService fXDealService;

	@Test
	void saveTest() {
		FXDealDto fxDealDto = createValidFXDealDto();
		FXDeal fxDealService = fXDealService.save(fxDealDto);

		FXDeal fxDealRepo = fXDealRepo.findById(fxDealService.getId()).get();

		assertEquals(fxDealService.getId(), fxDealRepo.getId());
		fXDealRepo.deleteById(fxDealService.getId());

	}

	@Test
	void findByIdTest() {
		FXDeal fxdeal = createValidFXDeal();
		FXDeal fxDealRepo = fXDealRepo.save(fxdeal);

		FXDeal fxDealService = fXDealService.findById(fxDealRepo.getId());

		assertEquals(fxDealRepo.getId(), fxDealService.getId());
		fXDealRepo.deleteById(fxDealRepo.getId());

	}

	private FXDealDto createValidFXDealDto() {
		return FXDealDto.builder().dealId("8888").fromCurrency("EUR").toCurrency("USD")
				.transactionalDate(LocalDateTime.now()).amount(BigDecimal.valueOf(1000)).build();
	}

	private FXDeal createValidFXDeal() {
		return FXDeal.builder().id(1000).dealId("12345").fromCurrency("USD").toCurrency("EUR")
				.transactionalDate(LocalDateTime.now()).amount(BigDecimal.valueOf(1000)).build();
	}

}
