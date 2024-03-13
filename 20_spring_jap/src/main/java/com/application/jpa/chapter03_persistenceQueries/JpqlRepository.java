package com.application.jpa.chapter03_persistenceQueries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.jpa.entity.Product;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Repository
public interface JpqlRepository  extends JpaRepository<Product, Long> {
// product DB활용
	
	/*
	
	1. 쿼리 메서드
	
	Spring Data JPA는 메소드 이름을 분석하여 특정 필드를 사용한 쿼리를 자동으로 생성하고 실행한다.
	
	[ 레퍼런스 메뉴얼 ]
	
	https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

 */
	
	public List<Product> findByDeliveryPrice (Integer DeliveryPrice);
	public List<Product> findByPriceGreaterThan(Integer price);
	public List<Product> findByPriceGreaterThanOrderByPriceDesc(Integer price);
	
	/*
	 
	 2. JPQL (Java Persistence Query Language)
	 
	 - JPQL은 SQL과 유사하지만 데이터베이스 테이블 대신 엔티티 객체 모델을 대상으로 쿼리를 작성한다.
	 
	 - Keyword는 대소문자를 구분하지만 엔티티 및 속성은 대소문자를 구분한다.
	 
	 - 엔티티 이름에는 ALIAS를 지정하여 사용한다.
	 
	 - JPQL로 전달되는 데이터는 파라메타의 순서 및 파라메타명으로 접근할 수 있다.
	  
		  1) 파라메타 순서는 ?index로 표현한다.
		  
		  	[ 예시 ]
		  	
		  	@Query("SELECT p from Product p WHERE p.price >= ?1 and p.deliveryPrice = ?2")
		  	List<Product> ex(Integer price , Integer deliveryPrice); 
	 
		  2) 파라메타 이름은 @Param(파라메타명)으로 데이터를 전달받고 :파라메타명으로 표현한다.
		  
			  [ 예시 ]
			  
			  @Query("SELECT p from Product p WHERE p.price >= :price and p.deliveryPrice = :deliveryPrice")
			  List<Product> ex(@Param("price") Integer price , @Param("deliveryPrice") Integer deliveryPrice);
	 
		 [ 레퍼런스 메뉴얼 ]
		 
		 http://www.java2s.com/Tutorials/Java/JPA/4800__JPA_Query_new_Object.htm

*/


// 1) basic 예시
	
	@Query(value="""
			SELECT p
			FROM Product p
			""")
	public List<Product> basicEx();

// 2) where 예시
	@Query(value="""
			SELECT p
			FROM   Product p
			WHERE  p.price between :start and :end
			""")
	public List<Product> whereEx(@Param("start") Integer start ,
								@Param("end") Integer end);
	// 받는 값이 들어올때 @param

// 3) order by 예시
	
	@Query(value="""
			SELECT p
			FROM Product p
			WHERE p.deliveryPrice = ?1
			ORDER BY p.price DESC
			""")
	public List<Product> orderByEx(Integer deliveryPrice);
	//데이터값이 들어와서 param을 써도되고안써도 되지만 안쓰는게나음

// 4) group by 예시
	@Query(value="""
			select p.deliveryPrice, avg(p.price)
			from Product p
			group by p.deliveryPrice
			""")
	public List<Object[]> groupByEx();
	// Object타입의 배열이 들어간다..

// 5) join 예시
	@Query(value="""
			select p
			from Product p
			join p.brand b
			where b.activeYn = :activeYn
			""")
	public List<Product> joinEx(@Param("activeYn")String activeYn);

// 6) subquery 예시 상품가격보다 높은 가격
	@Query(value="""
			select p
			from Product p
			where p.price >= (select avg(p.price) from Product p)
			""")
	public List<Product> subqueryEx();
	
	

	

}
