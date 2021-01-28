package edu.henrys.grocery;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discount {

	private List<LineItem> lineItems;
	private List<DiscountOffer> eligibleDiscounts = new ArrayList<>();
	private List<DiscountOffer> basketQaulifiedDiscounts = new ArrayList<>();
	private Map<LineItem, DiscountOffer> lineItemsAndQualifiedDiscounts = new HashMap<>();
	private Map<LineItem, Double> lineItemDiscounts = new HashMap<>();
	private double total;
	private Map<DiscountOffer, Integer> qualifyingProductQuantity = new HashMap<>();

	public double calculateDiscountAmount(List<LineItem> lineItems, LocalDate transactionDate) {
		this.lineItems = lineItems;
		findActiveDiscounts(transactionDate);
		qualifyingProductCheck();
		productDiscountCheck();
		if (eligibleDiscounts.size() > 0 && basketQaulifiedDiscounts.size() > 0) {
			calcuateDiscountPerLineItem();
			for (Map.Entry<LineItem, Double> entry : lineItemDiscounts.entrySet()) {
				total = total + entry.getValue();
			}

			return Math.round(total * 100.00) / 100.00;

		}

		return 0.00;

	}

	private void findActiveDiscounts(LocalDate transactionDate) {
		List<DiscountOffer> discountOffers = Arrays.asList(DiscountOffer.values());

		for (DiscountOffer discountOffer : discountOffers) {
			if (transactionDate.isAfter(discountOffer.getStartDate())
					&& transactionDate.isBefore(discountOffer.getEndDate())) {
				eligibleDiscounts.add(discountOffer);
			}
		}

	}

	private void qualifyingProductCheck() {
		lineItems.forEach(lineItem -> {
			eligibleDiscounts.forEach(discount -> {

				if (discount.getQualifyingProductName().equalsIgnoreCase(lineItem.getProductName())
						&& discount.getQualifyingProductQuantity() <= lineItem.getQuantity()) {
					qualifyingProductQuantity.put(discount, lineItem.getQuantity());
					basketQaulifiedDiscounts.add(discount);
				}
			});
		});

	}

	private void productDiscountCheck() {
		basketQaulifiedDiscounts.forEach(discount -> {
			lineItems.forEach(lineItem -> {
				if (lineItem.getProductName().equalsIgnoreCase(discount.getProductToDiscount())) {
					lineItemsAndQualifiedDiscounts.put(lineItem, discount);
				}
			});

		});
	}

	private int numberOfProductsToDiscount(DiscountOffer discount) {

		return qualifyingProductQuantity.get(discount) / discount.getQualifyingProductQuantity();
	}

	private void calcuateDiscountPerLineItem() {
		for (Map.Entry<LineItem, DiscountOffer> entry : lineItemsAndQualifiedDiscounts.entrySet()) {

			lineItemDiscounts.put(entry.getKey(),
					(numberOfProductsToDiscount(entry.getValue())
							* Product.valueOf(entry.getKey().getProductName().toUpperCase()).getPricePerUnit()
							* entry.getValue().getDiscountPercent()));

		}
	}

}
