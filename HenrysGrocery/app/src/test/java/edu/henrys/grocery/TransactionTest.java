package edu.henrys.grocery;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransactionTest {

	@Test void shouldFindLineItemByProduct() {
		Transaction ta = new Transaction();
		ta.addLineItem("Milk", 1);
		ta.addLineItem("Soup", 1);
		
		assertEquals("Soup", ta.findLineItem("soup").getProductName());
		
	}
	
	@Test void shouldDetermineDiscountBeforeGettingTotal() {
		Transaction ta = new Transaction();
		ta.addLineItem("apple", 6);
		
		assertEquals(".54", ta.getTotal());
	}
	
	

}
