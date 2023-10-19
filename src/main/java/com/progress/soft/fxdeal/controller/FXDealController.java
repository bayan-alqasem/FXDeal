package com.progress.soft.fxdeal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progress.soft.fxdeal.dto.FXDealDto;
import com.progress.soft.fxdeal.entity.FXDeal;
import com.progress.soft.fxdeal.service.FXDealService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/FXDeal")
@Slf4j
public class FXDealController {

	@Autowired
	private FXDealService fXDealService;

	@PostMapping("/save")
	public ResponseEntity<FXDeal> save(@Valid @RequestBody FXDealDto fxDealDto) {
		log.info("Save The FXDeal: {}", fxDealDto);
		FXDeal fxDeal = fXDealService.save(fxDealDto);
		return ResponseEntity.ok(fxDeal);

	}

	@GetMapping("findById/{id}")
	public ResponseEntity<FXDeal> findById(@PathVariable Integer id) {
		log.info("Finding FXDeal using dealId: {}", id);
		FXDeal fxDeal = fXDealService.findById(id);
		log.info("Response recevied: {}", fxDeal);
		return ResponseEntity.ok(fxDeal);
	}
}
