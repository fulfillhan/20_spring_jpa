package com.application.jpa.chapter02_mapping;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.jpa.config.BrandMapper;
import com.application.jpa.entity.Brand;
import com.application.jpa.entity.BrandDTO;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<BrandDTO> getAllBrands() {
		
		// 정적 메서드 매핑
		List<Brand> brands = brandRepository.findAll();
		return BrandMapper.toDTOList(brands);
		
		// modelMapper 매핑
//		return brandRepository.findAll().stream()  					  // 함수형 방식으로 처리할 수 있게반환
//				.map(brand -> modelMapper.map(brand, BrandDTO.class)) // 각 Brand 객체를 BrandDTO 객체로 변환
//				.collect(Collectors.toList());						  // 변환된 BrandDTO 객체들을 리스트로 수집하여 List로 변환	 
		
		
	}

	@Override
	public BrandDTO getBrandById(Long brandId) {
		 //정적메서드 매핑
//		Brand brand = brandRepository.findById(brandId).orElse(null);
//		return BrandMapper.toDTO(brand);  // 정적메서드 사용으로 클래스이름 불러서 직접 쓴다.
		
		//ModelMapper 매핑
		return brandRepository.findById(brandId)
				.map(brand -> modelMapper.map(brand, BrandDTO.class)).orElse(null);
		
	}

	@Override
	public void createBrand(BrandDTO brandDTO) {
		// 정적 메서드 매핑
		brandRepository.save(BrandMapper.toEntity(brandDTO));
		
		// modelMapper 매핑
		//brandRepository.save(modelMapper.map(brandDTO, Brand.class));
	
	}

	@Override
	public void updateBrand(BrandDTO brandDTO) {
		// 정적 메서드 매핑
		brandRepository.save(BrandMapper.toEntity(brandDTO));
		
		// modelMapper 매핑
		//brandRepository.save(modelMapper.map(brandDTO, Brand.class));

	}
	
	@Override
	public void deleteBrand(Long brandId) {
		brandRepository.deleteById(brandId);
	}



}
