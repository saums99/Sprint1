package com.cg.sbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sbs.entity.Products;
import com.cg.sbs.exceptions.InvalidProductException;
import com.cg.sbs.exceptions.InvalidProductIdException;
import com.cg.sbs.exceptions.InvalidProductNameException;
import com.cg.sbs.exceptions.ProductNotFoundException;
import com.cg.sbs.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public Products addProduct(Products product) {
		validateProduct(product);
		Products saved = productRepository.save(product);
		return saved;
	}

//to search for the product by its product id
	@Override
	public Products searchProduct(String id) {
		Optional<Products> searchProduct = productRepository.findById(id);
		if (!searchProduct.isPresent()) {
			throw new ProductNotFoundException("Item with id not present=" + id);
		}
		return searchProduct.get();
	}

//to update the products
	@Override
	public Products updateProduct(Products product) {
		validateProduct(product);
		boolean exists = productRepository.existsById(product.getProductId());
		if (!exists) {
			throw new ProductNotFoundException("Product with id not present=" + product.getProductId());
		}
		Products updateProduct = productRepository.save(product);
		return updateProduct;
	}

//to remove the product by product id
	@Override
	public Products removeProduct(String id) {
		boolean exists = productRepository.existsById(id);
		if (!exists) {
			throw new ProductNotFoundException("Product with id not present=" + id);
		}
		Optional<Products> removeProduct = productRepository.findById(id);
		Products product = removeProduct.get();
		productRepository.deleteById(id);
		return removeProduct.get();

	}

//to view the list of all items
	@Override
	public List<Products> viewAllItems(String name) {
		List<Products> list = productRepository.findByProductName(name);
		return list;
	}

	void validateProduct(Products product) {
		if (product == null) {
			throw new InvalidProductException("Product can't be null");
		}
		validateProductName(product.getProductName());
		validateProductId(product.getProductId());

	}

	void validateProductName(String productName) {
		if (productName == null || productName.isEmpty() || productName.trim().isEmpty()) {
			throw new InvalidProductNameException("Product Name can't be null or empty");
		}
	}

	void validateProductId(String productId) {
		if (productId == null || productId.isEmpty() || productId.trim().isEmpty()) {
			throw new InvalidProductIdException("Product Id can't be null or empty");
		}
	}

}
