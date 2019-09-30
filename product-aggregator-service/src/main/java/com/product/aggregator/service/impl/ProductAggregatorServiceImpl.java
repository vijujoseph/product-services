package com.product.aggregator.service.impl;

import com.product.aggregator.domain.Product;
import com.product.aggregator.domain.Statistics;
import com.product.aggregator.exception.AggregatorBusinessException;
import com.product.aggregator.repository.ProductRepository;
import com.product.aggregator.service.ProductAggregatorService;
import com.product.aggregator.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductAggregatorServiceImpl implements ProductAggregatorService {

    private static final Logger log = LoggerFactory.getLogger(ProductAggregatorServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional(isolation=Isolation.SERIALIZABLE)
    public boolean saveProducts(List<Product> productList) throws AggregatorBusinessException {
        int size = productList.size();
        int counter = 0;
        List<Product> temp = new ArrayList<>();
        for (Product product : productList) {
            temp.add(product);
            if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
                productRepository.saveAll(temp);
                temp.clear();
            }
            counter++;
        }
        return true;
    }

    @Override
    public List<Product> getAllProducts() {
        return toList(productRepository.findAll());
    }


    @Override
    public Statistics getStatistics(String date) throws ParseException {
        if(null == date) {
            date = DateUtils.getCurrentDateFormatted();
        }
        Statistics statistic = new Statistics();
        Date date1 = new Date();
        try {
            date1 = new SimpleDateFormat("ddMMyyyy").parse(date);
        } catch (ParseException ex) {
            statistic.setMessage("Invalid Date Format : " + date + ". Please Enter Valid Format [ddMMyyyy] e.g) 24092019");
            return statistic;
        }

        statistic.setTotalCreated(getAllCreatedProducts(date1).size());
        statistic.setTotalUpdated(getAllUpdatedProducts(date1).size());
        return statistic;
    }

    @Override
    public List<Product> getAllCreatedProducts(Date date) throws ParseException {
        return productRepository.fetchAllCreatedProducts(
                DateUtils.atStartOfDay(date), DateUtils.atEndOfDay(date));
    }

    @Override
    public List<Product> getAllUpdatedProducts(Date date) throws ParseException {
        return productRepository.fetchAllUpdateProducts(
                DateUtils.atStartOfDay(date), DateUtils.atEndOfDay(date));
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}