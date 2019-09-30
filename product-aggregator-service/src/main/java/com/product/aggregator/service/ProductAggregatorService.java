package com.product.aggregator.service;

import com.product.aggregator.domain.Product;
import com.product.aggregator.domain.Statistics;
import com.product.aggregator.exception.AggregatorBusinessException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ProductAggregatorService {

    boolean saveProducts(List<Product> productList) throws AggregatorBusinessException;

    List<Product> getAllProducts();

    List<Product> getAllCreatedProducts(Date date) throws ParseException;

    List<Product> getAllUpdatedProducts(Date date) throws ParseException;

    Statistics getStatistics(String date) throws ParseException;

}
