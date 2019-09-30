package com.product.aggregator.controller;

import com.product.aggregator.domain.Product;
import com.product.aggregator.domain.Statistics;
import com.product.aggregator.exception.AggregatorBusinessException;
import com.product.aggregator.service.ProductAggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductAggregatorController {

    private static final String SUCCESS_MSG = "SUCCESS";
    private static final String FAILURE_MSG = "FAILURE";

    @Autowired
    ProductAggregatorService productAggregatorService;

    @RequestMapping(method = RequestMethod.POST)
    public String saveProducts(@RequestBody List<Product> products) throws AggregatorBusinessException {
        return productAggregatorService.saveProducts(products) ? SUCCESS_MSG : FAILURE_MSG;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productAggregatorService.getAllProducts();
    }

    @RequestMapping(value = "/statistics/{date}", method = RequestMethod.GET)
    public Statistics statistics(@PathVariable ("date") String date) throws ParseException {
        return productAggregatorService.getStatistics(date);
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public Statistics todayStatistics() throws ParseException {
        return productAggregatorService.getStatistics(null);
    }

}
