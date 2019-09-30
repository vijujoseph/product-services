package com.product.importer.service;

import com.product.importer.domain.Product;
import com.product.importer.exception.ImporterBusinessException;

import java.util.List;

public interface ProductImporterService {

    List<Product> processFile(String fileName) throws ImporterBusinessException;

}
