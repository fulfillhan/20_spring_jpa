package com.application.jpa.chapter03_persistenceQueries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.jpa.entity.Product;

@Repository
public interface QueryDslRepository extends JpaRepository<Product, Long>, QueryDslRepositoryCustom{
		
}
