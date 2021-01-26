package edu.henrys.grocery;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DiscountTest {
	private Discount d = new Discount();
	private LocalDate todaysDate = LocalDate.now();

	@Test
	void applesShouldGet10PercentDiscount() {
		setAllDiscountsEligible();

		assertEquals(.06, d.calculateDiscountAmount(basketWithApples(), todaysDate));
	}

	@Test
	void twoTinsOfSoupShouldGive50PercentOffBread() {
		setAllDiscountsEligible();
		assertEquals(.40, d.calculateDiscountAmount(basketWith2SoupsAnd1Bread(), todaysDate));
	}

	@Test
	void only1UnitOfBreadShouldBeDiscountedWith2TinsOfSoup() {
		setAllDiscountsEligible();
		
		assertEquals(.40, d.calculateDiscountAmount(basketWith2SoupAnd2Bread(), todaysDate));
	}



	@Test void toBeEligibleForDiscountTransactionDateMustBeBetweenStartAndEndDateOfDiscount() {
		setAllDiscountsIneligible();
		
		assertEquals(0.00, d.calculateDiscountAmount(basketWith6Apple2SoupAnd2Bread(), todaysDate));
	}
	
	@Test void whenApplesAreEligibleAndBreadIsIneligibleShouldOnlyGetDiscountForApples() {
		setApplesEligibleAndBreadIneligible();
		
		assertEquals(.06, d.calculateDiscountAmount(basketWith6Apple2SoupAnd2Bread(), todaysDate));
	}
	
	@Test void whenBreadIsEligibleAndApplesAreIneligibleShouldOnlyGetDiscountForBread() {
		setBreadEligibleAndApplesIneligible();
		
		assertEquals(.40, d.calculateDiscountAmount(basketWith6Apple2SoupAnd2Bread(), todaysDate));
	}
	
	
	

	//Test Helpers
	
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
	
	private void setApplesEligibleAndBreadIneligible() {
		DiscountOffer.APPLE_DISCOUNT.setStartDate(LocalDate.now().minusDays(5));
		DiscountOffer.APPLE_DISCOUNT.setEndDate(LocalDate.now().plusMonths(1));
		DiscountOffer.BREAD_DISCOUNT.setStartDate(LocalDate.now().plusDays(5));
		DiscountOffer.BREAD_DISCOUNT.setEndDate(LocalDate.now().plusMonths(1));
	}
	
	private void setBreadEligibleAndApplesIneligible() {
		DiscountOffer.BREAD_DISCOUNT.setStartDate(LocalDate.now().minusDays(5));
		DiscountOffer.BREAD_DISCOUNT.setEndDate(LocalDate.now().plusMonths(1));
		DiscountOffer.APPLE_DISCOUNT.setStartDate(LocalDate.now().plusDays(5));
		DiscountOffer.APPLE_DISCOUNT.setEndDate(LocalDate.now().plusMonths(1));
		
	}
	
	private List<LineItem> basketWithApples() {


		List<LineItem> lis = new ArrayList<>();
		LineItem li = new LineItem("apple", 6);
		lis.add(li);

		return lis;
	}

	private List<LineItem> basketWith2SoupsAnd1Bread() {

		List<LineItem> lis = new ArrayList<>();
		LineItem li = new LineItem("soup", 2);
		LineItem li2 = new LineItem("Bread", 1);
		lis.add(li);
		lis.add(li2);

		return lis;
	}
	
	private List<LineItem> basketWith2SoupAnd2Bread() {
		List<LineItem> lis = new ArrayList<>();
		LineItem li2 = new LineItem("soup", 2);
		LineItem li3 = new LineItem("Bread", 2);
		lis.add(li2);
		lis.add(li3);
		return lis;
	}

	private List<LineItem> basketWith6Apple2SoupAnd2Bread() {


		List<LineItem> lis = new ArrayList<>();
		LineItem li = new LineItem("apple", 6);
		LineItem li2 = new LineItem("soup", 2);
		LineItem li3 = new LineItem("Bread", 2);
		lis.add(li);
		lis.add(li2);
		lis.add(li3);

		return lis;
	}

}
