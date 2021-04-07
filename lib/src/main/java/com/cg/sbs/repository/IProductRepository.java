package com.cg.sbs.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sbs.entity.Products;

public interface IProductRepository extends JpaRepository<Products, String>{

		List<Products> findByProductName(String name);

		
}


