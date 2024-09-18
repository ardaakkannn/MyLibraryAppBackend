package com.ardakkan.demo.repositories;

import com.ardakkan.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepo extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
