package com.kh.spring23.vo;

import lombok.Data;

@Data
public class KakaoPayReadyRequestVO {
	private String item_name;
	private int quantity;
	private long total_amount;
	
	public String getQuantity_string() {
		return String.valueOf(quantity);
	}
	public String getTotal_amount_string() {
		return String.valueOf(total_amount);
	}
}