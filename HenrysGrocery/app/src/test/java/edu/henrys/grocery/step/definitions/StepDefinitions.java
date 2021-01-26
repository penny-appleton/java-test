package edu.henrys.grocery.step.definitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import edu.henrys.grocery.DiscountOffer;
import edu.henrys.grocery.Store;
import io.cucumber.java8.En;

public class StepDefinitions implements En {

	private Store henrysGrocery;
	private String totalCost = "0";
	
	
	public StepDefinitions() {
	
	Given ("All discounts are currently {word}", (String status) ->{
		if(status.matches("active")) {
			setAllDiscountsEligible();
		}
		if(status.matches("inactive")) {
			setAllDiscountsIneligible();
		}
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
		System.out.println(DiscountOffer.APPLE_DISCOUNT.getStartDate());
	   assertEquals(totalCost, this.totalCost );
	});
	
}
	
	//Helper Methods to set discount dates
	private void setAllDiscountsEligible() {
		DiscountOffer.APPLE_DISCOUNT.setStartDate(LocalDate.now().minusDays(5));
		DiscountOffer.APPLE_DISCOUNT.setEndDate(LocalDate.now().plusMonths(1));
		DiscountOffer.BREAD_DISCOUNT.setStartDate(LocalDate.now().minusDays(5));
		DiscountOffer.BREAD_DISCOUNT.setEndDate(LocalDate.now().plusMonths(1));
	}
	
	private void setAllDiscountsIneligible() {
		DiscountOffer.APPLE_DISCOUNT.setStartDate(LocalDate.now().plusDays(5));
		DiscountOffer.APPLE_DISCOUNT.setEndDate(LocalDate.now().plusMonths(1));
		DiscountOffer.BREAD_DISCOUNT.setStartDate(LocalDate.now().plusDays(5));
		DiscountOffer.BREAD_DISCOUNT.setEndDate(LocalDate.now().plusMonths(1));
	}
	

}