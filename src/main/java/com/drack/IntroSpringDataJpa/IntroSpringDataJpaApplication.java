package com.drack.IntroSpringDataJpa;

import com.drack.IntroSpringDataJpa.persistence.entity.Customer;
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
	public CommandLineRunner testQueryMethodCommand(CustomerRepository customerRepository) {
		return args -> {
			Customer customer = new Customer();
			customer.setName("Juan");
			customer.setPassword("1234");
			customer.setUsername("juanito");

			Customer ramon = new Customer();
			ramon.setName("Ramon");
			ramon.setPassword("5678");
			ramon.setUsername("mochemmon");

			Customer pepe = new Customer();
			pepe.setName("Pepe");
			pepe.setPassword("abcd");
			pepe.setUsername("pepito");

			Customer pepe2 = new Customer();
			pepe2.setName("Pepo");
			pepe2.setPassword("abcd");
			pepe2.setUsername("pepon");


			System.out.println("/n Guardando clientes");
			List<Customer> customers = List.of(customer, ramon, pepe, pepe2);

			customerRepository.saveAll(customers);

//pruebas 1
//			System.out.println("/n Buscando por nombre de usuario");
//			System.out.println(customerRepository.findByUsername("pepon"));
//			System.out.println("/n Buscando por nombre de usuario");
//			System.out.println(customerRepository.searchByUsername("juanito"));

			//pruebas 2
			System.out.println("/n Buscando por nombre con la letra o");
			customerRepository.findByNameContaining("o").forEach(System.out::println);
			System.out.println("/n Buscando por nombre que empieza con P");
			System.out.println(customerRepository.queryByNameStartingWith("P"));
			System.out.println("/n Buscando por nombre que termina con o");
			customerRepository.readByNameEndingWith("o").forEach(System.out::println);

			System.out.println("/n Buscando por nombre que contenga e y id mayor a 1");
			customerRepository.findByNameContainingAndIdGreaterThanOrderByIdDesc("e", 1L).forEach(System.out::println);

			System.out.println("/n Buscando por nombre que contenga e y id mayor a 1 usando jpql y la anotacion @Query");
			customerRepository.findAllByNameAndIdGreaterThan("e", 1L).forEach(System.out::println);

			System.out.println("/n Buscando por nombre que contenga e y id mayor a 1 usando sql nativo y la anotacion @Query");
			customerRepository.findAllByNameAndIdGreaterThanWhitSQL("e", 1L).forEach(System.out::println);

		};
	}

}
