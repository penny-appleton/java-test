package edu.henrys.grocery;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DiscountTest {
	private Discount d = new Discount();

	@Test void applesShouldGet10PercentDiscount() {
		List<LineItem> lis = new ArrayList<>();
		LineItem li = new LineItem("apple", 6);
		lis.add(li);
		
		assertEquals(.06, d.calculateDiscountAmount(lis));
	}
	
	@Test void twoTinsOfSoupShouldGive50PercentOffMilk() {
		List<LineItem> lis = new ArrayList<>();
		LineItem li = new LineItem("soup", 2);
		LineItem li2 = new LineItem("Bread", 1);
		lis.add(li);
		lis.add(li2);
		
		assertEquals(.40, d.calculateDiscountAmount(lis));
	}
	
	@Test void only1UnitOfMilkShouldBeDiscountedWith2TinsOfSoup() {
		List<LineItem> lis = new ArrayList<>();
		LineItem li = new LineItem("soup", 2);
		LineItem li2 = new LineItem("Bread", 2);
		lis.add(li);
		lis.add(li2);
		
		assertEquals(.40, d.calculateDiscountAmount(lis));
	}

}
