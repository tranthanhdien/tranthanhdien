package model;

import java.util.ArrayList;

public class ShoppingCart {
	Customer customer;
	ArrayList<ItemCart> listCart;

	public ShoppingCart(Customer customer) {
		super();
		this.customer = customer;
		listCart = new ArrayList<>();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<ItemCart> getListCart() {
		return listCart;
	}

	public void setListCart(ArrayList<ItemCart> listCart) {
		this.listCart = listCart;
	}

	// xu li cac phuong thuc mua hang
	public ItemCart findProduct(int id) {
		for (ItemCart i : listCart) {
			if (i.getP().getId() == id) {
				return i;
			}
		}
		return null;
	}

	public void addCart(Product p) {
		// neu gio hang chua co SP thi tao cart moi, quantyti =1

		// neu da ton tai p thi tang quatyti len
		ItemCart cart = findProduct(p.getId());
		if (cart == null) {
			// chua ton tai
			listCart.add(new ItemCart(p, 1));

		} else {
			// da ton tai roi
			cart.setQuantity(cart.getQuantity() + 1);

		}
	}

	public double totalPrice() {
		double result = 0;
		for (ItemCart i : listCart) {
			result += (i.getP().getPrice() * i.getQuantity());
		}
		return result;
	}

	public void tang(int index) {
		ItemCart item = listCart.get(index);

		item.setQuantity(item.getQuantity() + 1);

	}

	public void giam(int index) {
		ItemCart item = listCart.get(index);
		if (item.getQuantity() <= 1) {
			item.setQuantity(1);
		} else {
			item.setQuantity(item.getQuantity() - 1);
		}
	}

}
