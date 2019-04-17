package com.jdev.microservices.customer;

import com.jdev.microservices.customer.Entity.Customer;
import com.jdev.microservices.customer.Repository.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(Repository repository){
		return (evt)->{
			repository.save(new Customer("Adam","adam@boot.com"));
			repository.save(new Customer("John","john@boot.com"));
			repository.save(new Customer("Smith","smith@boot.com"));
			repository.save(new Customer("Edgar","edgar@boot.com"));
			repository.save(new Customer("Martin","martin@boot.com"));
			repository.save(new Customer("Tom","tom@boot.com"));
			repository.save(new Customer("Sean","sean@boot.com"));
		};
	}

}
