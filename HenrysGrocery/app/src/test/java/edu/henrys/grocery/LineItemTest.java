package edu.henrys.grocery;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineItemTest {

	private LineItem li = new LineItem("Milk", 2);

	@Test
	void newSubtotalShouldBeReturnedWhenProductIsAddedToBasket() {

		assertEquals(2.6, li.subtotal());
	}
	
  @Test void lineItemForEachProductShouldIncludeProductNameQuantityPricePerUnitAndSubTotal() {
	
	
	assertEquals( "Product: Milk  Quantity: 2  Cost/Unit: $1.30  Line item total: $2.60", li.getLineItemDetails());
}
}
