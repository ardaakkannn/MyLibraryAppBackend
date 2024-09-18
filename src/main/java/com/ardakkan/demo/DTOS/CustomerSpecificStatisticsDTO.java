package com.ardakkan.demo.DTOS;

import java.math.BigDecimal;

public class CustomerSpecificStatisticsDTO {

    private String month;
    private int totalOrderCount;
    private int totalBookCount;
    private BigDecimal totalPurchasedAmount;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getTotalOrderCount() {
		return totalOrderCount;
	}
	public void setTotalOrderCount(int totalOrderCount) {
		this.totalOrderCount = totalOrderCount;
	}
	public int getTotalBookCount() {
		return totalBookCount;
	}
	public void setTotalBookCount(int totalBookCount) {
		this.totalBookCount = totalBookCount;
	}
	public BigDecimal getTotalPurchasedAmount() {
		return totalPurchasedAmount;
	}
	public void setTotalPurchasedAmount(BigDecimal totalPurchasedAmount) {
		this.totalPurchasedAmount = totalPurchasedAmount;
	}
	public CustomerSpecificStatisticsDTO(String month, int totalOrderCount, int totalBookCount,
			BigDecimal totalPurchasedAmount) {
		super();
		this.month = month;
		this.totalOrderCount = totalOrderCount;
		this.totalBookCount = totalBookCount;
		this.totalPurchasedAmount = totalPurchasedAmount;
	}
	public CustomerSpecificStatisticsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
