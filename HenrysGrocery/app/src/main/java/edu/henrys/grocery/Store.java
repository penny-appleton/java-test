/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.henrys.grocery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
	private List<LineItem> lineItems = new ArrayList<>();
	private double total;

	public static void main(String[] args) {
		Store hg = new Store();
		Scanner sc = new Scanner(System.in);

		System.out.println(hg.getGreeting());

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

	public String getGreeting() {
		return "Welcome";
	}

	public void addToBasket(String product, int quantity) {
		LineItem li = new LineItem(product, quantity);
		lineItems.add(li);
		System.out.println(li.getLineItemDetails());
	}

	public List<LineItem> getLineItems() {

		return lineItems;

	}

	public double checkout() {
		calculateTotal();

		return total;

	}

	private void calculateTotal() {

		lineItems.forEach(lineItem -> {
			total = total + lineItem.subtotal();
		});

	}

}
