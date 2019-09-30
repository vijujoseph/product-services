package com.product.importer;

import com.product.importer.domain.Product;
import com.product.importer.exception.ImporterBusinessException;
import com.product.importer.util.ParseExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

@SpringBootApplication
public class ProductImporterApplication {

	private static final Logger log = LoggerFactory.getLogger(ProductImporterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductImporterApplication.class, args);
	}


	@Bean
	public CommandLineRunner startUp() {
		return (args) -> {
			//Parsing the CSV files(Sample data)
			List<Product> productList = ParseExcelUtils.parseFile("dataExample.csv");

			log.debug("Excel processed successfully. Total count of products : " +productList.size());
			log.debug("--------------------------------------------------------------");
/*			for (Product product : productList) {
				log.info(product.toString());
			}*/

            log.debug("---------Using concurrency for sending MSG--------");
            ForkJoinPool forkJoinPool = null;
            try {
                forkJoinPool = new ForkJoinPool(5);
                forkJoinPool.submit(() ->
                        productList.parallelStream()
                                .forEach(product -> log.info(product.toString()))

                ).get(); //this makes it an overall blocking call

            } catch (InterruptedException | ExecutionException ex) {
                throw new ImporterBusinessException("File not found [ERR151], Msg : " + ex.getMessage()
                        ,ex);
            } finally {
                if (forkJoinPool != null) {
                    forkJoinPool.shutdown();
                }
            }
		};
	}
}
