package com.application.jpa;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.jpa.chapter03_persistenceQueries.NativeQueryRepository;
import com.application.jpa.entity.Product;

@SpringBootTest
public class NativeQueryTest {

	@Autowired
	private NativeQueryRepository nativeQueryRepository;

	
	
	// 1) basic 예시
	@Test
	public void basicEx() {
		for (Product product : nativeQueryRepository.basicEx()) {
			System.out.println(product);
		}
	}
	
	// 2) where 예시
	@Test
	public void whereEx() {
		for (Product product : nativeQueryRepository.whereEx(500000,1000000)) {
			System.out.println(product);
		}
	}
	
	// 3) order by 예시
	@Test
	public void orderByEx() {
		for (Product product : nativeQueryRepository.orderByEx(0)) {
			System.out.println(product);
		}
	}
	
	// 4) group by 예시
	@Test
	public void groupByEx() {
		for (Object[] result : nativeQueryRepository.groupByEx()) {
			System.out.println(result[0] + " / " + result[1]);
		}
	}
	
	// 5) join 예시
	@Test
	public void joinEx() {
		for (Object[] result : nativeQueryRepository.joinEx("y")) {
			System.out.println(Arrays.toString(result));
		}
	}
	
	// 6) subquery 예시
	@Test
	public void subqueryEx() {
		for (Product product : nativeQueryRepository.subqueryEx()) {
			System.out.println(product);
		}
	}
	
	
}
