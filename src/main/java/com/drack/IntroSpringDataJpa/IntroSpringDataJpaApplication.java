package com.drack.IntroSpringDataJpa;

import com.drack.IntroSpringDataJpa.persistence.entity.Address;
import com.drack.IntroSpringDataJpa.persistence.entity.Customer;
import com.drack.IntroSpringDataJpa.persistence.repository.AddressRepository;
import com.drack.IntroSpringDataJpa.persistence.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class IntroSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner testOneToOneRelationShipCommand(CustomerRepository customerRepository) {
		return args -> {
			Customer customer = new Customer();
			customer.setName("Juan");
			customer.setPassword("1234");
			customer.setUsername("juanito");
			Address juanAddressOne = new Address();
			juanAddressOne.setCountry("Mexico");
			juanAddressOne.setAddress("Calle 123");
			Address juanAddressTwo = new Address();
			juanAddressTwo.setCountry("Mexico");
			juanAddressTwo.setAddress("Calle 456");
			customer.setAddress(List.of(juanAddressOne, juanAddressTwo));


			System.out.println("/n Guardando cliente");
			customerRepository.save(customer);

			//customerRepository.saveAll(customers);
		};
	}



}
