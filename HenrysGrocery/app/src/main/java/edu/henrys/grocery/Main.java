package edu.henrys.grocery;

import java.util.Scanner;

public class Main {
	
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

}
