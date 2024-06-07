package com.drack.IntroSpringDataJpa;

import com.drack.IntroSpringDataJpa.persistence.entity.Customer;
import com.drack.IntroSpringDataJpa.persistence.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class IntroSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner testCusomerRepositoryCommand(CustomerRepository customerRepository) {
		return args -> {
			Customer customer = new Customer();
			customer.setName("Juan");
			customer.setPassword("1234");

			Customer ramon = new Customer();
			ramon.setName("Ramon");
			ramon.setPassword("5678");

			List<Customer> customers = List.of(customer, ramon);

			System.out.println("\nGuardando clientes:");
			customerRepository.saveAll(customers);

			System.out.println("\nCliente con Id 1:");
			customerRepository.findById(1L).ifPresent(System.out::println);

			System.out.println("\nBorrando cliente con Id 1:");
			customerRepository.deleteById(1L);

			System.out.println("\nActualizando cliente con Id 2:");
			Optional<Customer> customer2 = customerRepository.findById(4L);
			customer2.ifPresent(c -> {
				c.setName("Monchemon");
				c.setPassword("8765");
				customerRepository.save(c);
			});

			System.out.println("\nClientes guardados:");
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
