package com.comparator.heatingcomparator;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.comparator.heatingcomparator.repositories.ProductRepository;
import com.comparator.heatingcomparator.models.Product;
@SpringBootApplication

public class HeatingComparatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeatingComparatorApplication.class, args);
	}

	// @Bean
	// ApplicationRunner loaderData(ProductRepository productRepo){
	// 	return args->{
	// 		productRepo.save(new Product("Thema 25", "1A1A1", "Heating Group", "Boiler"));
	// 		productRepo.save(new Product("Hello 30", "2B2B", "Heating Pump Group", "Heating Pump"));
	// 		productRepo.save(new Product("Cold 30", "3C3C", "Colding Group", "Colding"));

	// 	};
	// }
}
