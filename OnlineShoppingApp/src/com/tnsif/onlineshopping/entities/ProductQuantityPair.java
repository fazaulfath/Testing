//Program to define ProductQuantityPair class
package com.tnsif.onlineshopping.entities;

public class ProductQuantityPair {
	private Product product;
	private int quantity;

	public ProductQuantityPair (Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	//getters and setters
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}