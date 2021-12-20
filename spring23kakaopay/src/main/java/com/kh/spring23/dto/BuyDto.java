package com.kh.spring23.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BuyDto {
	private int no;
	private String tid;
	private String itemName;
	private Long totalAmount;
	private Date buyTime;
}
