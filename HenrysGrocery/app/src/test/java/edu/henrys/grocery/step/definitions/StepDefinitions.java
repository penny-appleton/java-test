package edu.henrys.grocery.step.definitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.henrys.grocery.Store;
import io.cucumber.java8.En;

public class StepDefinitions implements En {

	private Store henrysGrocery = new Store();
	private double totalCost = 0;
	
	
	public StepDefinitions() {
	
	Given("I have {int} tin of {word}", (Integer count, String word) -> {
		henrysGrocery.addToBasket(word, count);
	});

	When("I choose to checkout", () -> {
		totalCost = henrysGrocery.checkout();
	});

	Then("The total cost should be ${double}", (Double totalCost) -> {
	   assertEquals(totalCost, this.totalCost );
	});
	
}
}