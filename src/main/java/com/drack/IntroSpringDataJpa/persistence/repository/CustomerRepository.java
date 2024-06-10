package com.drack.IntroSpringDataJpa.persistence.repository;


import com.drack.IntroSpringDataJpa.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByUsername(String username);
    Optional<Customer> searchByUsername(String username);

    //select c. * from clientes c where c.nombre like %name%
    List<Customer> findByNameContaining(String name);

    //select c. * from clientes c where c.nombre like name%

    List<Customer> queryByNameStartingWith(String name);

    //select c. * from clientes c where c.nombre like %name
    List<Customer> readByNameEndingWith(String name);

    //select c. * from clientes c where c.nombre like %name% and c.id > id order by c.id desc
    List<Customer> findByNameContainingAndIdGreaterThanOrderByIdDesc(String name, Long id);

}
