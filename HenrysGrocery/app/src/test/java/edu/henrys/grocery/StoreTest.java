package edu.henrys.grocery;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


class StoreTest {
	
	@BeforeEach
	public void initEach() {
	henrysGrocery = new Store();
	henrysGrocery.startTransaction();
	}
	
	private Store henrysGrocery;
	
    
    @Test void customerShouldBeAbleToAddProductsToBasket() {
    	
    	henrysGrocery.addToBasket("Milk", 2);
    	
    	assertEquals(2, henrysGrocery.getNumberofItemsInBasket());
    	
    }
    
    @Test void customerShouldBeAbleToAddMultipleTypesOfProductsToBasket() {
    	henrysGrocery.addToBasket("Apple", 4);
    	henrysGrocery.addToBasket("Bread", 2);
    	
    	assertEquals(6, henrysGrocery.getNumberofItemsInBasket());
    	
    	
    }
    
    @Test void customerShouldGetTotalAfterAllItemsAdded() {
    	henrysGrocery.addToBasket("Milk", 4);
    	henrysGrocery.addToBasket("Bread", 2);
    	
    	
    	assertEquals("6.80", henrysGrocery.checkout());
    }
    
   
    

    
   
    
    
    
    
    
}
