package com.ardakkan.demo.repositories;

import com.ardakkan.demo.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersJpaRepo extends JpaRepository<Orders, Long> {
    List<Orders> findByCustomerId(Long customerId);
}

