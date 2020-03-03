package com.ynap.shop;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ynap.shop.model.Product;
import com.ynap.shop.service.ProductService;
import com.ynap.shop.utils.ProductUtil;

public class YNAPShop {
	double sum;

	ProductService productService = new ProductService();

	public void loadProducts() throws IOException {
		List<String> fileData = productService.loadProducts();
		System.out.println("File Data----> "+ fileData);
	}

	public List<String> getProducts() throws IOException {
		return productService.loadProducts();
	}

	public String displayProducts() throws IOException {
		System.out.println("Product Display---->");
		return productService.loadProducts().toString();
	}

	public void addProductToBasket(String productId) throws IOException {
		List<String> productList = productService.loadProducts();
		productList.add(productId);
		List<Product> basket = Arrays.asList(new Product(productList.get(5), productList.get(1), productList.get(2)));
		System.out.println(" Basket----> " + basket);
	}

	public List<Product> getBasketItems() throws IOException {

		List<String> productList = productService.loadProducts();

		List<Product> basket = Arrays.asList(new Product(productList.get(5), productList.get(1), productList.get(2)),
				new Product(productList.get(0), productList.get(1), productList.get(6)));

		return basket;
	}

	public void removeProductFromBasket(String productId) throws IOException {
		List<String> productList = productService.loadProducts();
		productList.remove(productId);
		System.out.println("Remove Product has completed");
	}

	public BigDecimal getTotal() throws IOException {
		List<String> totalAsListOfStrings = productService.loadProducts().stream().filter(s -> s.contains("."))
				.map(s -> s.replace("£", "")).map(s -> s.replaceAll("[^\\d.]", "")).map(s -> s.substring(1))
				.collect(Collectors.toList());

		List<Double> totalAslistOfDoubles = ProductUtil.convertStringListToIntList(totalAsListOfStrings,
				Double::parseDouble);

		double total = totalAslistOfDoubles.stream().mapToDouble(Double::doubleValue).sum();
		return BigDecimal.valueOf(ProductUtil.round(total, 2));

	}

}