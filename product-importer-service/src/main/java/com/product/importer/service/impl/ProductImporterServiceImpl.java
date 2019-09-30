package com.product.importer.service.impl;

import com.product.importer.domain.Product;
import com.product.importer.exception.ImporterBusinessException;
import com.product.importer.service.ProductImporterService;
import com.product.importer.util.ParseExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImporterServiceImpl implements ProductImporterService {

    private static final Logger log = LoggerFactory.getLogger(ProductImporterServiceImpl.class);

    @Override
    public List<Product> processFile(String fileName) throws ImporterBusinessException {
        try {
            return ParseExcelUtils.parseFile(fileName);
        } catch (Exception ex) {
            throw new ImporterBusinessException("Error while parsing excel file [ERR150], Msg : " + ex.getMessage()
                    ,ex);
        }
    }
}