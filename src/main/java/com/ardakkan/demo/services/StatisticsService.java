package com.ardakkan.demo.services;

import com.ardakkan.demo.DTOS.CustomerSpecificStatisticsDTO;
import com.ardakkan.demo.DTOS.GeneralStatisticsDTO;
import com.ardakkan.demo.entities.Orders;
import com.ardakkan.demo.repositories.OrdersJpaRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    private final OrdersJpaRepo ordersJpaRepo;

    public StatisticsService(OrdersJpaRepo ordersJpaRepo) {
        this.ordersJpaRepo = ordersJpaRepo;
    }

    
    public List<CustomerSpecificStatisticsDTO> getMonthlyStatisticsForCustomer(Long customerId) {
        List<Orders> customerOrders = ordersJpaRepo.findAll().stream()
                .filter(order -> order.getCustomer().getId().equals(customerId))
                .collect(Collectors.toList());

        Map<Month, List<Orders>> ordersByMonth = customerOrders.stream()
                .collect(Collectors.groupingBy(order -> order.getOrderDate().getMonth()));

        return ordersByMonth.entrySet().stream()
                .map(entry -> {
                    Month month = entry.getKey();
                    List<Orders> ordersInMonth = entry.getValue();

                    int totalOrderCount = ordersInMonth.size();
                    int totalBookCount = ordersInMonth.stream().mapToInt(order -> order.getBooks().size()).sum();
                    BigDecimal totalPurchasedAmount = ordersInMonth.stream()
                            .map(Orders::getTotalPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    CustomerSpecificStatisticsDTO dto = new CustomerSpecificStatisticsDTO();
                    dto.setMonth(month.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
                    dto.setTotalOrderCount(totalOrderCount);
                    dto.setTotalBookCount(totalBookCount);
                    dto.setTotalPurchasedAmount(totalPurchasedAmount);

                    return dto;
                })
                .collect(Collectors.toList());
    }

   
    public List<GeneralStatisticsDTO> getMonthlyGeneralStatistics() {
        List<Orders> allOrders = ordersJpaRepo.findAll();

        Map<Month, List<Orders>> ordersByMonth = allOrders.stream()
                .collect(Collectors.groupingBy(order -> order.getOrderDate().getMonth()));

        return ordersByMonth.entrySet().stream()
                .map(entry -> {
                    Month month = entry.getKey();
                    List<Orders> ordersInMonth = entry.getValue();

                    int totalOrderCount = ordersInMonth.size();
                    int totalBookCount = ordersInMonth.stream().mapToInt(order -> order.getBooks().size()).sum();
                    BigDecimal totalPurchasedAmount = ordersInMonth.stream()
                            .map(Orders::getTotalPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    GeneralStatisticsDTO dto = new GeneralStatisticsDTO();
                    dto.setMonth(month.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
                    dto.setTotalOrderCount(totalOrderCount);
                    dto.setTotalBookCount(totalBookCount);
                    dto.setTotalPurchasedAmount(totalPurchasedAmount);

                    return dto;
                })
                .collect(Collectors.toList());
    }
}

