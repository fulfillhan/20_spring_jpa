package com.application.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.jpa.chapter03_persistenceQueries.QueryDslRepository;
import com.application.jpa.entity.Product;
import com.querydsl.core.Tuple;

@SpringBootTest
public class QueryDslTest {

	
	@Autowired// 실제로는 Service에서 구현한다
	private QueryDslRepository queryDslRepository;

	
	// 1) basic 예시
	@Test
	public void basicEx() {
		for (Product product : queryDslRepository.basicEx()) {
			System.out.println(product);
		}
	}
	
	// 2) where 예시
	@Test
	public void whereEx() {
		for (Product product : queryDslRepository.whereEx(500000,1000000)) {
			System.out.println(product);
		}
	}
	
	// 3) order by 예시
	@Test
	public void orderByEx() {
		for (Product product : queryDslRepository.orderByEx(0)) {
			System.out.println(product);
		}
	}
	
	// 4) group by 예시
	@Test
	public void groupByEx() {
		List<Tuple> results = queryDslRepository.groupByEx();
		
		// 타입 변환
		for (Tuple result : results) {
			Object[] temp = result.toArray(); // 배열로 변환
			System.out.println(temp[0] + " / " + temp[1]); // temp[0] : deliveryPrice , temp[1] avg(price)
		}
		
	}
	
	// 5) join 예시
	@Test
	public void joinEx() {
		for (Product product : queryDslRepository.joinEx("y")) {
			System.out.println(product);
		}
	}
	
	// 6) subquery 예시
	@Test
	public void subqueryEx() {
		for (Product product : queryDslRepository.subqueryEx()) {
			System.out.println(product);
		}
		
	}
	
	
}
