/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.henrys.grocery;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class StoreTest {
	Store henrysGrocery = new Store();
	
    @Test void appHasAGreeting() {
        
        assertEquals(henrysGrocery.getGreeting(), "Welcome");
    }
    
    @Test void customerShouldBeAbleToAddProductsToBasket() {
    	henrysGrocery.addToBasket("Milk", 2);
    	
    	assertEquals(henrysGrocery.getLineItems().size(), 1);
    	
    }
    
    @Test void customerShouldBeAbleToAddMultipleTypesOfProductsToBasket() {
    	henrysGrocery.addToBasket("Apple", 4);
    	henrysGrocery.addToBasket("Bread", 2);
    	
    	assertEquals(henrysGrocery.getLineItems().size(), 2);
    	
    	
    }
    
    @Test void customerShouldGetTotalAfterAllItemsAdded() {
    	henrysGrocery.addToBasket("Apple", 4);
    	henrysGrocery.addToBasket("Bread", 2);
    	
    	
    	assertEquals(henrysGrocery.checkout(), 2.0);
    }
    
   
    

    
   
    
    
    
    
    
}
