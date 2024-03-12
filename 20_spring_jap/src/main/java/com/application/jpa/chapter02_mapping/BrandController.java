package com.application.jpa.chapter02_mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.jpa.entity.BrandDTO;

@Controller
class BrandTestController {
	
	@GetMapping("/brand/view")
	public String view() {
		return "brand";
	}
	
}

@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@GetMapping
	public List<BrandDTO> getAllBrands() {
		return brandService.getAllBrands();
	}
	
	@GetMapping("/{brandId}")
	public BrandDTO getBrandById(@PathVariable("brandId") Long brandId) {
		return brandService.getBrandById(brandId);
	}
	
	@PostMapping
	public void createBrand(@RequestBody BrandDTO brandDTO) {
		brandService.createBrand(brandDTO);
	} 
	
	@PutMapping
	public void updateBrand(@RequestBody BrandDTO brandDTO) {
		brandService.updateBrand(brandDTO);
	} 
	
	@DeleteMapping("/{brandId}")
	public void deleteBrand(@PathVariable("brandId") Long brandId) {
		brandService.deleteBrand(brandId);
	} 
	
	

}
