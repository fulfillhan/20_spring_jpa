package com.application.jpa.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	
	/*
	 
	- @ManyToOne
	
		Product와 Brand 간의 다대일(Many-to-One) 관계를 나타낸다. 
		즉 하나의 브랜드가 여러 제품을 가질 수 있음을 의미한다.
	
	- @JoinColumn(name = "brand_Id")
	
		연관된 브랜드를 참조하기 위한 외래 키(foreign key)가 brand_Id라는 이름의 열(column)에 저장됨을 명시한다.
	
	- private Brand brand;
	
		Product 엔티티와 연관된 Brand 엔티티의 인스턴스를 참조하는 필드이다.
		이 클래스를 통해, Product 엔티티는 Brand 엔티티와의 관계를 매핑하며 
		이를 통해 ORM(Object-Relational Mapping)을 구현한다. 
	
*/

	
	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name="brand_id")
	private Brand brand;
	

}
