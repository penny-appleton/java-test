package edu.henrys.grocery;

import java.util.Scanner;

public class Store {

	private Transaction t;

	public static void main(String[] args) {
		Store hg = new Store();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome");
		hg.startTransaction();

		String n = "n";
		while (n.matches("n")) {
			System.out.println("Enter the product name you wish to add to your basket");
			String p = sc.next();

			System.out.println("Enter the quantity of the product");
			int q = sc.nextInt();

			hg.addToBasket(p, q);

			System.out.println("Would you like to checkout? y or n");
			n = sc.next();

			if (n.matches("y") || n.matches("Y")) {

				hg.checkout();
			}

		}

		sc.close();
	}


	public void addToBasket(String product, int quantity) {
		t.addLineItem(product, quantity);
		System.out.println(t.getLineItemReport(product));
	}

	public String checkout() {
		String totalCost = t.getTotal();
		System.out.println("Your total is: $" + totalCost);
		return totalCost;
	}

	public Integer getNumberofItemsInBasket() {
		return t.getNumberOfItems();
	}
	
	public void startTransaction() {
		t = new Transaction();
	}

}
