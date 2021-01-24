package edu.henrys.grocery;

import java.text.DecimalFormat;

public class LineItem {
	
	private String product;
	private int quantity;

	public LineItem(String productName, int quantity) {
		this.product = productName;
		this.quantity = quantity;
		subtotal();
		
	}

	public double subtotal() {
		
		return Product.valueOf(product.toUpperCase()).getPricePerUnit() * quantity;
		
	}

	public String getLineItemDetails() {
		DecimalFormat df = new DecimalFormat("#.00");
		StringBuilder builder = new StringBuilder();
		builder.append("Product: ");
		builder.append(product);
		builder.append("  Quantity: ");
		builder.append(quantity);
		builder.append("  Cost/Unit: $");
		builder.append(df.format(Product.valueOf(product.toUpperCase()).getPricePerUnit()));
		builder.append("  Line item total: $");
		builder.append(df.format(subtotal()));
		
		return builder.toString();
		
	}
	
	public String getProductName() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
	
}

