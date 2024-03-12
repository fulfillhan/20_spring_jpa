package com.application.jpa.chapter01_basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*

- JpaRepository 인터페이스를 상속하여 사용한다.
	JpaRepository는 Spring Data JPA가 제공하는 인터페이스로 
	기본적인 CRUD(Create, Read, Update, Delete) 작업과 추가 기능들(정렬,페이징,등)을 제공한다.

- <Entity Type , Primary Key Type>
	- 첫번째 인자는 Repository가 다룰 엔티티 타입(데이터베이스에 저장 및 검색)을 나타낸다.
	- 두번째 인자는 엔티티 기본 키(Primary Key)의 타입을 나타낸다.

- BasicRepository 인터페이스를 통해 데이터베이스와의 상호작용을 쉽게 처리할 수 있으며, 
	복잡한 SQL 쿼리 없이도 필요한 데이터 작업을 할 수 있다.

- 개발자가 특정 데이터베이스 작업을 위한 쿼리 메서드를 직접 작성할 필요가 없다. 
Spring Data JPA가 제공하는 메서드를 사용하거나, 메서드 이름 규칙에 따라 새로운 쿼리 메서드를 정의하기만 하면 된다.
이 인터페이스를 사용함으로써, 데이터베이스 작업을 보다 효율적이고 간결하게 수행할 수 있게 된다. 

*/

import com.application.jpa.entity.Brand;

@Repository
public interface BasicRepository extends JpaRepository<Brand, Long> {// <,래퍼클래스>
	// dao의미
	
	

}
