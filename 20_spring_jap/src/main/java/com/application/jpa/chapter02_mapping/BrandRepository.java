package com.application.jpa.chapter02_mapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.jpa.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>  {

}
