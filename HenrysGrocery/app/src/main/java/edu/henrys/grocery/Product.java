package edu.henrys.grocery;

public enum Product {
	MILK (1.30), APPLES (.10), SOUP (.65), BREAD (.80);
	
	private double pricePerUnit;

	private Product(double pricePerUnit) {
		this.setPricePerUnit(pricePerUnit);
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

}
