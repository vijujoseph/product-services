package com.product.aggregator;

import com.google.gson.Gson;
import com.product.aggregator.domain.Product;
import com.product.aggregator.exception.AggregatorBusinessException;
import com.product.aggregator.service.ProductAggregatorService;
import com.product.aggregator.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductAggregatorServiceApplicationTests {

	@Autowired()
	private ProductAggregatorService productAggregatorService;

	@Test
	public void saveValidProductsTest() throws AggregatorBusinessException {
		List<Product> productList = new ArrayList<>();
		Product prod1 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa11",
				"Samsung Galaxy Mobile",
				"smart phone",
				"Samsung Galaxy",
				"true",
				"PC",
				"ADMIN");
		Product prod2 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa22",
				"Samsung Galaxy Mobile2",
				"smart phone2",
				"Samsung Galaxy2",
				"true",
				"PC2",
				"ADMIN2");
		Product prod3 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa23",
				"Samsung Galaxy Mobile3",
				"smart phone3",
				"Samsung Galaxy3",
				"true",
				"PC3",
				"ADMIN3");
		Product prod4 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa14",
				"Samsung Galaxy Mobile1",
				"smart phone",
				"Samsung Galaxy",
				"true",
				"PC",
				"ADMIN");
		Product prod5 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa25",
				"Samsung Galaxy Mobile2",
				"smart phone2",
				"Samsung Galaxy2",
				"true",
				"PC2",
				"ADMIN2");
		Product prod6 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa25",
				"Samsung Galaxy Mobile22",
				"smart phone2",
				"Samsung Galaxy2",
				"true",
				"PC2",
				"ADMIN2");
		Product prod7 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa26",
				"Samsung Galaxy Mobile33",
				"smart phone2",
				"Samsung Galaxy2",
				"true",
				"PC2",
				"ADMIN2");

		productList.add(prod1);
		productList.add(prod2);
		productList.add(prod3);
		productList.add(prod4);
		productList.add(prod5);
		productList.add(prod6);
		productList.add(prod7);

		boolean result = productAggregatorService.saveProducts(productList);


		//boolean result1 = productAggregatorService.saveProducts(productList);
		productList =  productAggregatorService.getAllProducts();

		assertTrue(result);
	}

	@Test
	public void fetchByCreatedDateNotNullValidProductsTest() throws AggregatorBusinessException, ParseException {
		List<Product> productList = new ArrayList<>();
		Product prod1 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa11",
				"Samsung Galaxy Mobile",
				"smart phone",
				"Samsung Galaxy",
				"true",
				"PC",
				"ADMIN");
		Product prod2 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa22",
				"Samsung Galaxy Mobile2",
				"smart phone2",
				"Samsung Galaxy2",
				"true",
				"PC2",
				"ADMIN2");
		Product prod3 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa23",
				"Samsung Galaxy Mobile3",
				"smart phone3",
				"Samsung Galaxy3",
				"true",
				"PC3",
				"ADMIN3");

		productList.add(prod1);
		productList.add(prod2);
		productList.add(prod3);

		boolean result = productAggregatorService.saveProducts(productList);
		Date date1 = new SimpleDateFormat("ddMMyyyy").parse("30092019");
		List<Product> createdProducts = productAggregatorService.getAllCreatedProducts(date1);
		List<Product> updatedProducts = productAggregatorService.getAllUpdatedProducts(date1);

		assertEquals(createdProducts.size(), 3);
		assertEquals(updatedProducts.size(), 0);

		List<Product> productList1 = new ArrayList<>();
		Product prod11 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa11",
				"Samsung Galaxy Mobile",
				"smart phone",
				"Samsung Galaxy",
				"true",
				"PC",
				"ADMIN");
		Product prod22 = new Product("fccc13f1-f337-480b-9305-a5bb56bcaa22",
				"Samsung Galaxy Mobile2",
				"smart phone2",
				"Samsung Galaxy2",
				"true",
				"PC2",
				"ADMIN2");

		productList1.add(prod11);
		productList1.add(prod22);
		boolean result1 = productAggregatorService.saveProducts(productList1);

		List<Product> createdProducts1 = productAggregatorService.getAllCreatedProducts(date1);
		List<Product> updatedProducts1 = productAggregatorService.getAllUpdatedProducts(date1);
		assertEquals(updatedProducts1.size(), 2);
	}


}
