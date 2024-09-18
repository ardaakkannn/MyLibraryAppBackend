package com.ardakkan.demo.services;

import com.ardakkan.demo.DTOS.CustomerDTO;
import com.ardakkan.demo.entities.Customer;
import com.ardakkan.demo.repositories.CustomerJpaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

	@Autowired
    private final CustomerJpaRepo customerJpaRepo;

    public CustomerService(CustomerJpaRepo customerJpaRepo) {
        this.customerJpaRepo = customerJpaRepo;
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerJpaRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<CustomerDTO> getCustomerById(Long id) {
        return customerJpaRepo.findById(id).map(this::convertToDTO);
    }

    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = convertToEntity(customerDTO);
        Customer savedCustomer = customerJpaRepo.save(customer);
        return convertToDTO(savedCustomer);
    }

    public void deleteCustomer(Long id) {
        customerJpaRepo.deleteById(id);
    }

    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        // Siparişlerin mappingini ekleyebilirsiniz
        return dto;
    }

    private Customer convertToEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        // Siparişlerin mappingini ekleyebilirsiniz
        return customer;
    }
}

