package edu.henrys.grocery;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public enum DiscountOffer {

	APPLE_DISCOUNT("apple", 1, "apple", LocalDate.now().plusDays(3), LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).plusMonths(1), .10), BREAD_DISCOUNT("soup", 2, "bread", LocalDate.now().minusDays(1), LocalDate.now().plusDays(7), .5);

	private final String qualifyingProductName;
	private final int qualifyingProductQuantity;
	private final String productToDiscountName;
	private LocalDate startDate = LocalDate.now();
	private LocalDate endDate = LocalDate.now();
	private final double discountPercent;

	private DiscountOffer(String qualifyingProductName, int qualifyingProductQuantity, String productToDiscountName, LocalDate startDate, LocalDate endDate,
			double discountPercent) {
		this.qualifyingProductName = qualifyingProductName;
		this.qualifyingProductQuantity = qualifyingProductQuantity;
		this.productToDiscountName = productToDiscountName;
		setStartDate(startDate);
		setEndDate(endDate);
		this.discountPercent = discountPercent;
	}

	public String getProductToDiscount() {
		return productToDiscountName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public String getQualifyingProductName() {
		return qualifyingProductName;
	}
	
	public int getQualifyingProductQuantity() {
		return qualifyingProductQuantity;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
