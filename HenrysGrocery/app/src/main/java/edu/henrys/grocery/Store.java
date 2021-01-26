package edu.henrys.grocery;

import java.time.LocalDate;

public class Store {

	private Transaction t;

	public Store() {
	}


	public void addToBasket(String product, int quantity) {
		t.addLineItem(product, quantity);
		System.out.println(t.getLineItemReport(product));
	}

	//I don't like this implementation
	public String checkout() {
		String totalCost = t.getTotal();
		System.out.println("Your total is: $" + totalCost);
		return totalCost;
	}

	public Integer getNumberofItemsInBasket() {
		return t.getNumberOfItems();
	}
	
	public void startTransaction() {
		
		t = new Transaction(LocalDate.now());
	}


}
