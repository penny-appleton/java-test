package edu.henrys.grocery.step.definitions;

import io.cucumber.java8.En;

public class StepDefinitions implements En {

	private int quantity = 0;
	private String productName = "";
	
	public StepDefinitions() {
		
	Given("I have {int} tin of {word}", (Integer count, String word) -> {
	    quantity = count;
	    productName = word;
	});

	When("I choose to checkout", () -> {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java8.PendingException();
	});

	Then("The total cost should be ${double}", (Double totalCost) -> {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java8.PendingException();
	});
	
}
}