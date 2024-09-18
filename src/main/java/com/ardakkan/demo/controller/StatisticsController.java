package com.ardakkan.demo.controller;

import com.ardakkan.demo.DTOS.CustomerSpecificStatisticsDTO;
import com.ardakkan.demo.DTOS.GeneralStatisticsDTO;
import com.ardakkan.demo.services.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardakkan.demo.services.*;
import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    // Statistics for spesific customer
    @GetMapping("/monthly/customer/{customerId}")
    public List<CustomerSpecificStatisticsDTO> getMonthlyStatisticsForCustomer(@PathVariable Long customerId) {
        return statisticsService.getMonthlyStatisticsForCustomer(customerId);
    }

    // General statistics
    @GetMapping("/monthly/general")
    public List<GeneralStatisticsDTO> getMonthlyGeneralStatistics() {
        return statisticsService.getMonthlyGeneralStatistics();
    }
}

