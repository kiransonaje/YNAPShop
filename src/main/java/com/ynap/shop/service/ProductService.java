package com.ynap.shop.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Kiran Sonaje 
 * Date: 03/03/2020 
 */
public class ProductService {

	private static final String FILE_PATH = "src/main/resources/product-data.csv";

	public List<String> loadProducts() throws IOException {
		return Files.lines(Paths.get(FILE_PATH)).collect(Collectors.toList());
	}
}