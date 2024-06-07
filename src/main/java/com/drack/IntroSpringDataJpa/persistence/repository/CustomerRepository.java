package com.drack.IntroSpringDataJpa.persistence.repository;


import com.drack.IntroSpringDataJpa.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
