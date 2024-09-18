package com.ardakkan.demo.services;

import com.ardakkan.demo.DTOS.OrderDTO;
import com.ardakkan.demo.entities.Book;
import com.ardakkan.demo.entities.Customer;
import com.ardakkan.demo.entities.Orders;
import com.ardakkan.demo.repositories.BookJpaRepo;
import com.ardakkan.demo.repositories.CustomerJpaRepo;
import com.ardakkan.demo.repositories.OrdersJpaRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrdersJpaRepo ordersJpaRepo;
    private final CustomerJpaRepo customerJpaRepo;
    private final BookJpaRepo bookJpaRepo;

    public OrderService(OrdersJpaRepo ordersJpaRepo, CustomerJpaRepo customerJpaRepo, BookJpaRepo bookJpaRepo) {
        this.ordersJpaRepo = ordersJpaRepo;
        this.customerJpaRepo = customerJpaRepo;
        this.bookJpaRepo = bookJpaRepo;
    }

    
    public List<OrderDTO> getAllOrders() {
        return ordersJpaRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) {
        return ordersJpaRepo.findByCustomerId(customerId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    
    public Optional<OrderDTO> getOrderById(Long id) {
        return ordersJpaRepo.findById(id)
                .map(this::convertToDTO);
    }
    
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        Orders order = convertToEntity(orderDTO);

        
        BigDecimal totalPrice = order.getBooks().stream()
            .map(Book::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        
        order.setTotalPrice(totalPrice);

        Orders savedOrder = ordersJpaRepo.save(order);
        return convertToDTO(savedOrder);
    }


    
    public void deleteOrder(Long id) {
        ordersJpaRepo.deleteById(id);
    }

    
    private Orders convertToEntity(OrderDTO dto) {
        Orders order = new Orders();

        // Find customer and add 
        Customer customer = customerJpaRepo.findById(dto.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomer(customer);

        // Find book and add
        List<Book> books = dto.getBookIds().stream()
            .map(bookId -> bookJpaRepo.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book not found")))
            .collect(Collectors.toList());
        order.setBooks(books);

        // Calculate total price of books
        BigDecimal totalPrice = books.stream()
            .map(Book::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalPrice(totalPrice);

        // other areas
        order.setOrderDate(dto.getOrderDate());

        return order;
    }


    
    private OrderDTO convertToDTO(Orders order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCustomerId(order.getCustomer().getId());
        dto.setBookIds(order.getBooks().stream()
                .map(Book::getId)
                .collect(Collectors.toList()));
        dto.setTotalPrice(order.getTotalPrice());
        dto.setOrderDate(order.getOrderDate());
        return dto;
    }
}



