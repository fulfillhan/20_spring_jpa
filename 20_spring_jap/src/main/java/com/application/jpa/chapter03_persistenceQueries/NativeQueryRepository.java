package com.application.jpa.chapter03_persistenceQueries;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.jpa.entity.Product;

@Repository
public interface NativeQueryRepository extends JpaRepository<Product , Long>{

	/*
	 
	 	# native query
	 	
	 	JPQL과 같은 형태로 사용되며 @Query(nativeQuery = true//sql쿼리로 작성) 속성을 추가하여 사용한다.
	 
	  */
	
	// 1) basic 예시
	@Query(value="""
			SELECT *
			FROM   PRODUCT 
			""" , nativeQuery = true)
	public List<Product> basicEx();
	
	
	// 2) where 예시
	@Query(value="""
			SELECT *
			FROM   PRODUCT p
			WHERE PRICE BETWEEN :start AND :end
			""" , nativeQuery = true)
	public List<Product> whereEx(@Param("start") Integer start , @Param("end") Integer end);
	
	
	// 3) order by 예시
	@Query(value="""
			SELECT   p
			FROM     PRODUCT p
			WHERE    DELIVERY_PRICE= ?1 
			ORDER BY PRICE DESC
				""" , nativeQuery = true)
	public List<Product> orderByEx(Integer deliveryPrice);

	
	// 4) group by 예시
	@Query(value="""
			SELECT   DELIVERY_PRICE , AVG(PRICE)
			FROM	 PRODUCT
			GROUP BY DELIVERY_PRICE
			""" , nativeQuery = true)
	public List<Object[]> groupByEx();

	
	// 5) join 예시
	@Query(value="""
			SELECT *
			FROM   PRODUCT P
			JOIN   BRAND B
			ON     P.BRAND_ID = B.BRAND_ID
			WHERE  B.ACTIVE_YN = :activeYn
			""" , nativeQuery = true)
	public List<Object[]> joinEx(@Param("activeYn") String activeYn);
	
	
	// 6) subquery 예시
	@Query(value="""
			SELECT *
			FROM   PRODUCT
			WHERE  PRICE >= (SELECT AVG(PRICE) FROM PRODUCT)
			""" , nativeQuery = true)
	public List<Product> subqueryEx();
	
	
}
