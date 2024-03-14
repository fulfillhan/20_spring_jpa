package com.application.jpa.chapter03_persistenceQueries;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.application.jpa.entity.Product;
import com.querydsl.core.Tuple;

/*

~~~RepositoryCustom은 사용자가 정의한 인터페이스로 
표준 CRUD 메서드 외에 특정 엔티티에 대한 커스텀 쿼리 메서드를 정의할 수 있다.

*/



public interface QueryDslRepositoryCustom {
	
	// 1) basic 예시
		public List<Product> basicEx();
		
		// 2) where 예시
		public List<Product> whereEx(@Param("start") Integer start , @Param("end") Integer end);
		
		// 3) order by 예시
		public List<Product> orderByEx(@Param("deliveryPrice") Integer deliveryPrice);

		// 4) group by 예시
		public List<Tuple> groupByEx();

		// 5) join 예시
		public List<Product> joinEx(@Param("activeYn") String activeYn);
		
		// 6) subquery 예시
		public List<Product> subqueryEx();
		
	

}
