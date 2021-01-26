package edu.henrys.grocery;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public enum DiscountOffer {

	APPLE_DISCOUNT("apples", "apples", LocalDate.now().plusDays(3), LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).plusMonths(1), .10), BREAD_DISCOUNT("soup", "bread", LocalDate.now().minusDays(1), LocalDate.now().plusDays(7), .5);

	private final String qualifyingProductName;
	private final String productToDiscountName;
	private LocalDate startDate = LocalDate.now();
	private LocalDate endDate = LocalDate.now();
	private final double discountPercent;

	private DiscountOffer(String qualifyingProductName, String productToDiscountName, LocalDate startDate, LocalDate endDate,
			double discountPercent) {
		this.qualifyingProductName = qualifyingProductName;
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

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
