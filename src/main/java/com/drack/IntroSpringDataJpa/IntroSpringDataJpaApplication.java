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
			Address juanAddress = new Address();
			juanAddress.setCountry("Mexico");
			juanAddress.setAddress("Calle 123");
			customer.setAddress(juanAddress);

			Customer ramon = new Customer();
			ramon.setName("Ramon");
			ramon.setPassword("5678");
			ramon.setUsername("mochemmon");
			Address ramonAddress = new Address();
			ramonAddress.setCountry("Mexico");
			ramonAddress.setAddress("Calle 456");
			ramon.setAddress(ramonAddress);

			Customer pepe = new Customer();
			pepe.setName("Pepe");
			pepe.setPassword("abcd");
			pepe.setUsername("pepito");
			Address pepeAddress = new Address();
			pepeAddress.setCountry("Mexico");
			pepeAddress.setAddress("Calle 789");
			pepe.setAddress(pepeAddress);


			System.out.println("/n Guardando clientes");
			List<Customer> customers = List.of(customer, ramon, pepe );

			//customerRepository.saveAll(customers);
		};
	}

	@Bean
	public CommandLineRunner testAddressCrudRepositoryCommand(AddressRepository  addressRepository) {
		return args -> {
			addressRepository.findAll()
					.forEach(eachAddress -> {
						System.out.println(eachAddress.getAddress() + "-" + eachAddress.getCustomer().getId());
					});
		};

	}

}
