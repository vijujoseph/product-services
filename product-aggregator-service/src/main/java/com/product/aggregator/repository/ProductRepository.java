package com.product.aggregator.repository;

import com.product.aggregator.domain.Product;
import com.product.aggregator.util.DateUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByUuid(String uuid);

    //List<Product> findByCreatedDateIsNotNull();

    //List<Product> findByCreatedDateIsNullAndUpdatedDateIsNotNull();

    List<Product> findByCreatedDateIsNotNullAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(Date startDate, Date endDate);

    default List<Product> fetchAllCreatedProducts(final Date startDate, final Date endDate) {
        return findByCreatedDateIsNotNullAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(startDate, endDate);
    }

    List<Product> findByCreatedDateIsNullAndUpdatedDateIsNotNullAndUpdatedDateGreaterThanEqualAndUpdatedDateLessThanEqual(Date startDate, Date endDate);

    default List<Product> fetchAllUpdateProducts(final Date startDate, final Date endDate) {
        return findByCreatedDateIsNullAndUpdatedDateIsNotNullAndUpdatedDateGreaterThanEqualAndUpdatedDateLessThanEqual(startDate, endDate);
    }

}