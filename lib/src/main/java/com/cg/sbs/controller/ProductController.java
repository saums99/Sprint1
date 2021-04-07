package com.cg.sbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sbs.dto.Product.AddProduct;
import com.cg.sbs.dto.Product.ProductDetails;
import com.cg.sbs.dto.Product.RemoveProduct;
import com.cg.sbs.dto.Product.UpdateProduct;
import com.cg.sbs.entity.Products;
import com.cg.sbs.service.IProductService;
import com.cg.sbs.util.ProductUtil;

@Validated
@RequestMapping("/products")
@RestController
public class ProductController {
	@Autowired
	private IProductService productService;

	@Autowired
	private ProductUtil productUtil;

	@PostMapping("/add")
	public ProductDetails addItem(@RequestBody AddProduct request) {
		Products product = productUtil.getProduct();
		
		product.setCost(request.getCost());
		product.setProductId(productUtil.generateId());
		product.setProductName(request.getProductName());
		product.setQuantity(request.getQuantity());
		product = productService.addProduct(product);
		return productUtil.toProductDetails(product);
	}	
		
	@PutMapping("/update")
		public ProductDetails updateProduct(@RequestBody UpdateProduct request) {
			Products product= productService.searchProduct(request.getProductId());
			product.setCost(request.getCost());
			product.setProductName(request.getProductName());
			product.setQuantity(request.getQuantity());
			return productUtil.toProductDetails(productService.updateProduct(product));

		}

		@DeleteMapping("/remove")
		public ProductDetails removeProduct(@RequestBody RemoveProduct request) {
			return productUtil.toProductDetails(productService.removeProduct(request.getProductId()));
		}
		@GetMapping("/search/{id}")
		public ProductDetails searchProduct(@PathVariable String id) {
			return productUtil.toProductDetails(productService.searchProduct(id));
		}
	


}
