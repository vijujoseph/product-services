package com.product.importer.controller;

import com.product.importer.domain.Product;
import com.product.importer.exception.ImporterBusinessException;
import com.product.importer.service.ProductImporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductImporterController {

    @Autowired
    ProductImporterService productImporterService;

    @RequestMapping(value = "/uploadFile")
    public List<Product> reports(@RequestParam("fileName") String fileName) throws ImporterBusinessException {
        List<Product> productList = productImporterService.processFile(fileName);
        return productList;
    }

}
