package com.application.jpa;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.jpa.chapter01_basic.BasicRepository;
import com.application.jpa.entity.Brand;

@SpringBootTest
public class BasicTest {

	
	@Autowired
	private BasicRepository basicRepository;
	

	@Test
	public void getAllBrands() {
		// findAll() : 테이블의 전체 데이터를 반환한다. (select * from brand)
		
		basicRepository.findAll(); 
		for (Brand brand : basicRepository.findAll()) {
			System.out.println(brand);
		}
	}
//	결과 : Brand(brandId=1, brandNm=samsung, enteredDt=2021-01-01 00:00:00.0, activeYn=Y)
//         Brand(brandId=2, brandNm=lg, enteredDt=2021-02-01 00:00:00.0, activeYn=Y)  ...

	@Test
	public void getBrandById() {
		// findById(primary key) : id에 해당되는 데이터 반환한다.
		
		//basicRepository.findById(1l/ (long)1); '1'은 int라서 long으로 형변환 필요하다. 
		System.out.println(basicRepository.findById((long)2));
		//결과:Optional[Brand(brandId=1, brandNm=samsung, enteredDt=2021-01-01 00:00:00.0, activeYn=Y)]
	}
	
	@Test
	public void createBrand() {
		// save() : 새로운 엔티티를 데이터베이스에 저장하며 이미 존재하는 엔티티의 경우 업데이트를 수행한다.
		// insert 구문
		Brand brand = new Brand();
		brand.setBrandId(100l);
		brand.setBrandNm("추가된브랜드100");
		brand.setActiveYn("N");
		brand.setEnteredDt(new Date());
		basicRepository.save(brand); 
	}
//	결과:Brand(brandId=6, brandNm=hp, enteredDt=2021-06-01 00:00:00.0, activeYn=N)
//	     Brand(brandId=100, brandNm=추가된브랜드100, enteredDt=2024-03-11 15:50:47.0, activeYn=N)
	
	@Test
	public void updateBrand() {
		// 기존에 저장되어 있는 데이터를 조회하여 수정한다.
		// save() : 새로운 엔티티를 데이터베이스에 저장하며 이미 존재하는 엔티티의 경우 업데이트를 수행한다.
		
		//Brand brand = new Brand();
		//brand.setBrandId(100l);
		Brand brand = basicRepository.findById(100l).orElse(null);// update brand set brandNm where brandId
		brand.setBrandNm("수정된브랜드101");
		brand.setActiveYn("y");
		brand.setEnteredDt(new Date());
		basicRepository.save(brand); 
	}
	
	@Test
	public void deleteBrand() {
		// deleteById(primary key); id에 해당되는 데이터 삭제한다. (delete form brand where brandId)
		basicRepository.deleteById(100l);
		
	}
	
	
}
