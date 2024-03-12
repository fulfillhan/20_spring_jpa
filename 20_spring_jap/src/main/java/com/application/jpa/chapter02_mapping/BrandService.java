package com.application.jpa.chapter02_mapping;

import java.util.List;

import com.application.jpa.entity.Brand;
import com.application.jpa.entity.BrandDTO;

public interface BrandService {
	
	public List<BrandDTO> getAllBrands();
	public BrandDTO getBrandById(Long brandId);
	public void createBrand(BrandDTO brandDTO); // 받는 부분(메개변수) DTO 형태
	//public void updateBrand(Brand brand); 
	public void deleteBrand(Long brandId);
	public void updateBrand(BrandDTO brandDTO);
	
	
}
