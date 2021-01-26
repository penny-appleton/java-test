package edu.henrys.grocery;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Discount {

	private List<DiscountOffer> eligibleDiscounts = new ArrayList<>();
	
	
//refactor this too many if statements
	public double calculateDiscountAmount(List<LineItem> lineItems, LocalDate transactionDate) {
		if (findEligibleDiscounts(transactionDate).size() > 0) {
			double apples = 0;
			double bread = 0;
			for (DiscountOffer eligibleDiscount : eligibleDiscounts) {
				if (eligibleDiscount.getProductToDiscount() == DiscountOffer.APPLE_DISCOUNT.getProductToDiscount()) {
					apples = getApplesDiscount(lineItems);
				}

				if (eligibleDiscount.getProductToDiscount() == DiscountOffer.BREAD_DISCOUNT.getProductToDiscount()) {
					bread = getBreadDiscount(lineItems);
				}
			}
			return apples + bread;
		}

		return 0;

	}

	private List<DiscountOffer> findEligibleDiscounts(LocalDate transactionDate) {
		List<DiscountOffer> discountOffers = Arrays.asList(DiscountOffer.values());

		for (DiscountOffer discountOffer : discountOffers) {
			if (transactionDate.isAfter(discountOffer.getStartDate())
					&& transactionDate.isBefore(discountOffer.getEndDate())) {
				eligibleDiscounts.add(discountOffer);
			}
		}

		return eligibleDiscounts;
	}

	private double getApplesDiscount(List<LineItem> lineItems) {
		List<LineItem> apples = lineItems.stream().filter(item -> item.getProductName().equalsIgnoreCase("apple"))
				.collect(Collectors.toList());

		try {
			if (apples.size() > 0) {
				return Math.round((apples.get(0).subtotal() * DiscountOffer.APPLE_DISCOUNT.getDiscountPercent()) * 100.00) / 100.00;

			}

		} catch (IndexOutOfBoundsException e) {

		}

		return 0;
	}

	private double getBreadDiscount(List<LineItem> lineItems) {

		if (checkForBreadLineItem(lineItems) == true && checkForSoupLineItemAndQuantity(lineItems) == true) {
			return Product.BREAD.getPricePerUnit() * DiscountOffer.BREAD_DISCOUNT.getDiscountPercent();
		}

		return 0;
	}

	private boolean checkForSoupLineItemAndQuantity(List<LineItem> lineItems) {
		List<LineItem> soup = lineItems.stream().filter(item -> item.getProductName().equalsIgnoreCase("soup"))
				.collect(Collectors.toList());

		try {
			if (soup.get(0).getQuantity() >= 2) {
				return true;
			}

		}

		catch (IndexOutOfBoundsException e) {

		}
		return false;

	}

	private boolean checkForBreadLineItem(List<LineItem> lineItems) {
		List<LineItem> milk = lineItems.stream().filter(item -> item.getProductName().equalsIgnoreCase("bread"))
				.collect(Collectors.toList());

		try {
			if (milk.get(0).getQuantity() >= 1) {
				return true;
			}
		} catch (IndexOutOfBoundsException e) {

		}
		return false;

	}

}
