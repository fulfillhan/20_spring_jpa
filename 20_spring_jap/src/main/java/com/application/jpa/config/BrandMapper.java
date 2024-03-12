package com.application.jpa.config;

import java.util.List;
import java.util.stream.Collectors;

import com.application.jpa.entity.Brand;
import com.application.jpa.entity.BrandDTO;

// @어노테이션 하지 않는다.  -> 정적메서드  static을 사용해서 바로 클래스변수로 사용
public class BrandMapper {

	public static BrandDTO toDTO(Brand entity) {  // dto로 내보내기
		 BrandDTO dto = new BrandDTO();
		 dto.setBrandId(entity.getBrandId());
		 dto.setBrandNm(entity.getBrandNm());
		 dto.setEnteredDt(entity.getEnteredDt());
		 dto.setActiveYn(entity.getActiveYn());
		 
		return dto;
	}
	
	
	public static Brand toEntity(BrandDTO dto) {  // entity로 내보내기 
		 Brand entity = new Brand();
		 entity.setBrandId(dto.getBrandId());
		 entity.setBrandNm(dto.getBrandNm());
		 entity.setEnteredDt(dto.getEnteredDt());
		 entity.setActiveYn(dto.getActiveYn());
		 
		return entity;
	}
	
	
	public static List<BrandDTO> toDTOList(List<Brand> brands){
		
		/*
		 
		객체.stream() : 스트림변환
		 
			- 객체.stream()을 통해 객체들의 스트림(Stream)을 생성한다.
			- 스트림은 자바 8부터 도입된 컬렉션을 효율적으로 처리하기 위한 API이다.
	
		.map(BrandMapper::toDTO) : 매핑
		
			- 구문은 각 entity 객체를 DTO 객체로 변환하는 작업을 수행한다. 
		 	-  BrandMapper::toDTO는 메소드 레퍼런스로, BrandMapper 클래스에 정의된 toDTO 메소드를 각 Brand 객체에 적용한다.
		
		.collect(Collectors.toList()) : 결과 수집
		
			- 스트림을 통해 변환된 BrandDTO 객체들을 새로운 리스트로 수집한다.

	 */
		
		return brands.stream().map(BrandMapper::toDTO).collect(Collectors.toList());
	}
	
}
