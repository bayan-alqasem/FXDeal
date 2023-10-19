package com.progress.soft.fxdeal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.progress.soft.fxdeal.entity.FXDeal;

@Repository
public interface FXDealRepo extends MongoRepository<FXDeal, Integer> {

	


}
