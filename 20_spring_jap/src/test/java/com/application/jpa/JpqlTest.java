package com.application.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.application.jpa.chapter03_persistenceQueries.JpqlRepository;
import com.application.jpa.entity.Product;

@SpringBootTest
public class JpqlTest {

	@Autowired
	private JpqlRepository jpqlRepository;

	// 쿼리 메서드 Test

	@Test
	public void findByDeliveryPrice() {
		for (Product product : jpqlRepository.findByDeliveryPrice(0)) {
			System.out.println(product);
		}
	}

	@Test
	public void findByPriceGreaterThan() {
		for (Product product : jpqlRepository.findByPriceGreaterThan(1000000)) {
			System.out.println(product);
		}
	}

	@Test
	public void findByPriceGreaterThanOrderByPriceDesc() {
		for (Product product : jpqlRepository.findByPriceGreaterThanOrderByPriceDesc(1000000)) {
			System.out.println(product);
		}
	}

	// JPQL Test

	// 1) basic 예시
	@Test
	public void basicEx() {
		for (Product product : jpqlRepository.basicEx()) {
			System.out.println(product);
		}
	}

	// 2) where 예시
	@Test
	public void whereEx() {
		for (Product product : jpqlRepository.whereEx(5000000, 10000000)) {
			System.out.println(product);
		}
		// where
		// p1_0.price between ? and ?

	}

	// 3) order by 예시
	@Test
	public void orderByEx() {
		for (Product product : jpqlRepository.orderByEx(0)) {
			System.out.println(product);
		}
	}

	// 4) group by 예시
	@Test
	public void groupByEx() {
		for (Object[] result : jpqlRepository.groupByEx()) {
			System.out.println(result[0] + "/" + result[1]);
		}
		
//		 select p1_0.delivery_price, avg(p1_0.price) from product p1_0 group by
//		 p1_0.delivery_price 0/
//		1234400.0 3000/1809725.0 
//		2500/1465830.0
		 
	}

	// 5) join 예시
	@Test
	public void joinEx() {
		for (Product product : jpqlRepository.joinEx("y")) {
			System.out.println(product);
		}
	}

	// 6) subquery 예시
		@Test
		public void subqueryEx() {
			for (Product product : jpqlRepository.subqueryEx()) {
				System.out.println(product);
			}
	}

}
