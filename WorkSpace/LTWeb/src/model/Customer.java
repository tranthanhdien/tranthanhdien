package model;

import java.util.ArrayList;

public class Customer {
	private String user;
	private String name;
	ArrayList<Product> shoppingCart;

	public Customer(String user, String name) {
		super();
		this.user = user;
		this.name = name;
		this.shoppingCart = new ArrayList<Product>();
	}
	public void addShoppingCart(Product p) {
		this.shoppingCart.add(p);
	}
	public ArrayList<Product> getShoppingCart() {
		return this.shoppingCart;
	}

}
