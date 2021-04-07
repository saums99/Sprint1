package com.cg.sbs.service;

import java.util.List;

import com.cg.sbs.entity.Products;

public interface IProductService {

	Products addProduct(Products product);

	Products searchProduct(String id);

	Products updateProduct(Products product);

	Products removeProduct(String id);

	List<Products> viewAllItems(String name);

}
