package edu.henrys.grocery.step.definitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.henrys.grocery.Store;
import io.cucumber.java8.En;

public class StepDefinitions implements En {

	private Store henrysGrocery;
	private String totalCost = "0";
	
	
	public StepDefinitions() {
		Before(() -> {
			henrysGrocery = new Store();
			henrysGrocery.startTransaction();
		});
	
	Given("I have {int} {word}", (Integer count, String word) -> {
		
		henrysGrocery.addToBasket(word, count);
	});

	When("I choose to checkout", () -> {
		totalCost = henrysGrocery.checkout();
	});

	Then("The total cost should be ${word}", (String totalCost) -> {
	   assertEquals(totalCost, this.totalCost );
	});
	
}
}