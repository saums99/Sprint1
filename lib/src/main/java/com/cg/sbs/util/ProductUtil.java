package com.cg.sbs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.cg.sbs.dto.Product.ProductDetails;
import com.cg.sbs.entity.Products;

@Component
public class ProductUtil {

	public Products getProduct() {
		return new Products();
	}

	public ProductDetails toProductDetails(Products product) {
		ProductDetails id = new ProductDetails();
		id.setCost(product.getCost());
		id.setQuantity(product.getQuantity());
		id.setProductName(product.getProductName());
		return id;
	}

	public List<ProductDetails> toProductDetailsList(List<Products> list) {
		List<ProductDetails> result = new ArrayList<>();
		for (Products product : list) {
			result.add(toProductDetails(product));
		}
		return result;
	}

	public String generateId() {
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int randomNum = random.nextInt(10);
			builder.append(randomNum);
		}
		return builder.toString();
	}

}
