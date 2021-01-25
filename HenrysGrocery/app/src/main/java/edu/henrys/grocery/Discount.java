package edu.henrys.grocery;

import java.util.List;
import java.util.stream.Collectors;

public class Discount {

	public double calculateDiscountAmount(List<LineItem> lineItems) {
		getApplesDiscount(lineItems);
		getBreadDiscount(lineItems);

		return getApplesDiscount(lineItems) + getBreadDiscount(lineItems);

	}

	private double getApplesDiscount(List<LineItem> lineItems) {
		List<LineItem> apples = lineItems.stream().filter(item -> item.getProductName().equalsIgnoreCase("apple"))
				.collect(Collectors.toList());
		try {

			if (apples.size() > 0) {
				return Math.round((apples.get(0).subtotal() * .1) * 100.00) / 100.00;

			}

		} catch (IndexOutOfBoundsException e) {

		}

		return 0;

	}

	private double getBreadDiscount(List<LineItem> lineItems) {
		boolean milk = checkForBreadLineItem(lineItems);
		boolean soupQualification = checkForSoupLineItemAndQuantity(lineItems);

		if (milk == true && soupQualification == true) {
			return Product.BREAD.getPricePerUnit() * .5;
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
