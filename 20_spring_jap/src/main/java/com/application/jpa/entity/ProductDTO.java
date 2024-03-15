package com.application.jpa.entity;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {

	private long productId;
	private String productNm;
	private int price;
	private int deliveryPrice;
	private Date enrollDt;
	private long brandId;
	
}
