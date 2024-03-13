package com.application.jpa.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data

public class Product {
	@Id
	private Long productId;
	private String productNm;
	private Integer price;
	private Integer deliveryPrice;
	private Date enrollDt;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	

}
