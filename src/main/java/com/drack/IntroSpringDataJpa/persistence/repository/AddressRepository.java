package com.drack.IntroSpringDataJpa.persistence.repository;

import com.drack.IntroSpringDataJpa.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
