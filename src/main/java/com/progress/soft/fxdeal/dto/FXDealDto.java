package com.progress.soft.fxdeal.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FXDealDto {

	
	@Min(value = 1, message = "Deal ID must be a positive integer")
	private String dealId;

	@NotNull(message = "FromCurrency is required")
	@Size(min = 3, max = 3, message = "FromCurrency must be exactly 3 characters long")
	private String fromCurrency;

	@NotNull(message = "ToCurrency is required")
	@Size(min = 3, max = 3, message = "ToCurrency must be exactly 3 characters long")
	@Pattern(regexp = "^[A-Z]{3}$", message = "Currency code must consist of 3 uppercase letters")
	private String toCurrency;

	@NotNull(message = "dealDate is required")
	@Past(message = "dealDate must be a date in the past")
	private LocalDateTime transactionalDate;

	@NotNull(message = "Amount is required")
	private BigDecimal amount;

}
