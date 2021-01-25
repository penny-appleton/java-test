package edu.henrys.grocery;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Transaction {

	private List<LineItem> lineItems = new ArrayList<>();
	private double total;
	private int numberOfItems;

	public void addLineItem(String product, int quantity) {
		LineItem li = new LineItem(product, quantity);
		lineItems.add(li);
	}

	public String getLineItemReport(String product) {

		return findLineItem(product).getLineItemDetails();
	}

	public LineItem findLineItem(String product) {
		List<LineItem> result = lineItems.stream().filter(item -> item.getProductName().equalsIgnoreCase(product))
				.collect(Collectors.toList());
		return result.get(0);
	}

	public String getTotal() {
		DecimalFormat df = new DecimalFormat("#.00");

		return df.format(calculateTotal());

	}

	private double calculateTotal() {
		
		lineItems.forEach(lineItem -> {
			total = total + lineItem.subtotal();
		});
		
		return total - getDiscountAmount();
	}

	public int getNumberOfItems() {
		lineItems.forEach(lineItem -> {
			numberOfItems = numberOfItems + lineItem.getQuantity();
		});

		return numberOfItems;
	}
	
	private double getDiscountAmount() {
		Discount d = new Discount();
		 
		
		return d.calculateDiscountAmount(lineItems);
	}

}
