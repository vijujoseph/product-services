package com.product.importer;

import com.product.importer.domain.Product;
import com.product.importer.exception.ImporterBusinessException;
import com.product.importer.service.ProductImporterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductImporterServiceApplicationTests {

	@Autowired()
	private ProductImporterService productImporterService;

	@Test
	public void processFileValidCSVFile() throws ImporterBusinessException {
		List<Product> result = productImporterService.processFile("dataExample1.csv");
		assertEquals(result.size(), 1000);
	}

	@Test(expected = ImporterBusinessException.class)
	public void processFileInValidCSVFile() throws ImporterBusinessException {
		List<Product> result = productImporterService.processFile("dataExample2.csv");
	}

}
