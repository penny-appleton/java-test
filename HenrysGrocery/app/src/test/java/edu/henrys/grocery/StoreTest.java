/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.henrys.grocery;

import org.junit.jupiter.api.Test;

import edu.henrys.grocery.Store;

import static org.junit.jupiter.api.Assertions.*;


class StoreTest {
	Store henrysGrocery = new Store();
	
    @Test void appHasAGreeting() {
        
        assertEquals(henrysGrocery.getGreeting(), "Welcome");
    }
    
    @Test void customerShouldBeAbleToAddProductsToBasket() {
    	henrysGrocery.addToBasket("Milk", 2);
    	
    	assertEquals(henrysGrocery.getProduct(), "Milk");
    	assertEquals(henrysGrocery.getQuantity(), 2);
    }
    
    @Test void newSubtotalShouldBeReturnedWhenProductIsAddedToBasket(){
    	henrysGrocery.addToBasket("Milk", 2);
    	
    	assertEquals(henrysGrocery.subtotal(), 2.6);
    }
    
    @Test void lineItemForEachProductShouldIncludeProductNameQuantityPricePerUnitAndSubTotal() {
    	henrysGrocery.addToBasket("Milk", 2);
    	
    	assertEquals(henrysGrocery.buildLineItem(), "Product: Milk  Quantity: 2  Cost/Unit: $1.30  Line item total: $2.60");
    }
    
    @Test void shouldGetPriceOfProductEntered() {
    	
    	assertEquals(henrysGrocery.getPricePerUnit("Milk"), 1.30);
    }
    
    
    
    
}
