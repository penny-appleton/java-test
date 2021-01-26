package edu.henrys.grocery;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TransactionTest {

	@Test void shouldFindLineItemByProduct() {
		Transaction ta = new Transaction(LocalDate.now());
		ta.addLineItem("Milk", 1);
		ta.addLineItem("Soup", 1);
		
		assertEquals("Soup", ta.findLineItem("soup").getProductName());
		
	}
	
	@Test void shouldDetermineDiscountBeforeGettingTotal() {
		DiscountOffer.APPLE_DISCOUNT.setStartDate(LocalDate.now().minusDays(5));
		DiscountOffer.APPLE_DISCOUNT.setEndDate(LocalDate.now().plusMonths(1));
		Transaction ta = new Transaction(LocalDate.now());
		ta.addLineItem("apple", 6);
		
		assertEquals(".54", ta.getTotal());
	}
	
	

}
