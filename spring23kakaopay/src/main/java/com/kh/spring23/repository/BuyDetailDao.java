package com.kh.spring23.repository;

import java.util.List;

import com.kh.spring23.dto.BuyDetailDto;

public interface BuyDetailDao {
	void insert(BuyDetailDto buyDetailDto);
	
	List<BuyDetailDto> list(int buyNo);
}