package com.drack.IntroSpringDataJpa;

import com.drack.IntroSpringDataJpa.persistence.entity.Customer;
import com.drack.IntroSpringDataJpa.persistence.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class IntroSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner testCusomerRepositoryCommand(CustomerRepository customerRepository) {
		return args -> {
			/*Customer customer = new Customer();
			customer.setName("Juan");
			customer.setPassword("1234");
			customerRepository.save(customer);
			System.out.println("Se guardo el cliente juan");

			customer = new Customer();
			customer.setName("Pedro");
			customer.setPassword("5678");
			customerRepository.save(customer);
			System.out.println("\nSe guardo el cliente pedro");*/



			System.out.println("\nCliente con Id 1:");
			customerRepository.findById(1L).ifPresent(System.out::println);

			System.out.println("\nBorrando cliente con Id 1:");
			customerRepository.deleteById(1L);

			System.out.println("\nCliente con Id 1:");
			Optional<Customer> customer = customerRepository.findById(1L);
			customer.ifPresent(System.out::println);

			System.out.println("\nClientes guardados:");
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
