package com.ardakkan.demo.DTOS;

import java.math.BigDecimal;

public class GeneralStatisticsDTO {

    private String month;
    private int totalOrderCount;
    private int totalBookCount;
    private BigDecimal totalPurchasedAmount;
	public GeneralStatisticsDTO(String month, int totalOrderCount, int totalBookCount,
			BigDecimal totalPurchasedAmount) {
		super();
		this.month = month;
		this.totalOrderCount = totalOrderCount;
		this.totalBookCount = totalBookCount;
		this.totalPurchasedAmount = totalPurchasedAmount;
	}
	public GeneralStatisticsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
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

    
}
