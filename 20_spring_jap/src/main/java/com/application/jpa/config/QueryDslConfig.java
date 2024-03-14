package com.application.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/*

@Configuration

해당 클래스가 Spring의 설정 정보를 제공하는 클래스임을 나타낸다.
Spring 컨테이너는 이 어노테이션이 붙은 클래스를 구성 클래스로 인식하고 
이 안에 정의된 @Bean 메서드들을 통해 빈(Bean) 객체를 생성 및 관리한다.

*/

@Configuration
public class QueryDslConfig {
	
	/*
	 
	@PersistenceContext 어노테이션은 EntityManager의 인스턴스를 자동으로 주입한다. 
	EntityManager는 JPA(Java Persistence API)의 핵심 인터페이스로 엔티티 객체의 생명주기를 관리하고 데이터베이스 쿼리를 수행하는 역할을 한다. 
	이 인스턴스는 영속성 컨텍스트와 연결되어 있으며 JPA 작업을 위한 기본적인 인터페이스를 제공한다.

*/
		@PersistenceContext
		private EntityManager em;
		
		
		/*
		 
		 JPAQueryFactory는 QueryDSL을 사용하여 타입 세이프 쿼리를 생성할 때 사용되는 클래스
		 이 객체를 통해 JPQL이 아닌 자바 코드로 데이터베이스 쿼리를 구성하고 실행할 수 있다.
	
		QueryDSL 사용을 위한 기본 설정을 제공하며 EntityManager를 사용하여 
		JPAQueryFactory 빈을 생성하고 스프링 애플리케이션에서 사용할 수 있도록 한다.
		
	*/
		@Bean
		public JPAQueryFactory jPAQueryFactory() {
			return new JPAQueryFactory(em);
		}

}
